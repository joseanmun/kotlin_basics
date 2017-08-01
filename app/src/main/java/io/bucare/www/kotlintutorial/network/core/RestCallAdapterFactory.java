package io.bucare.www.kotlintutorial.network.core;

import com.google.gson.internal.$Gson$Types;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RestCallAdapterFactory extends CallAdapter.Factory {
  private static Type getCallResponseType(Type returnType) {
    if (!(returnType instanceof ParameterizedType)) {
      throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
    final Type responseType = getSingleParameterUpperBound((ParameterizedType) returnType);

    // Ensure the Call response type is not Response, we automatically deliver the Response object.
    if ($Gson$Types.getRawType(responseType) == Response.class) {
      throw new IllegalArgumentException("Call<T> cannot use Response as its generic parameter. "
                                             + "Specify the response body type only (e.g., Call<TweetResponse>).");
    }
    return responseType;
  }

  public static Type getSingleParameterUpperBound(ParameterizedType type) {
    Type[] types = type.getActualTypeArguments();
    if (types.length != 1) {
      throw new IllegalArgumentException("Expected one type argument but got: "
                                             + Arrays.toString(types));
    }
    Type paramType = types[0];
    if (paramType instanceof WildcardType) {
      return ((WildcardType) paramType).getUpperBounds()[0];
    }
    return paramType;
  }

  @Override public CallAdapter<?, RestCall<?>> get(Type returnType, Annotation[] annotations,
                                                   Retrofit retrofit) {
    if ($Gson$Types.getRawType(returnType) != RestCall.class) {
      return null;
    }

    final Type responseType = getCallResponseType(returnType);

    return new CallAdapter<RestResponse<?>, RestCall<?>>() {
      @Override public Type responseType() {
        return responseType;
      }

      @Override public RestCall<?> adapt(Call<RestResponse<?>> call) {
        return new RestCall<>(call);
      }
    };
  }
}
