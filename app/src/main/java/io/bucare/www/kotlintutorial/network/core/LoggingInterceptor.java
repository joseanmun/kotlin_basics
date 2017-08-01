package io.bucare.www.kotlintutorial.network.core;

import io.bucare.www.kotlintutorial.utils.LoggingProvider;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import javax.inject.Inject;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;

/**
 * Created by joseanmun on 7/1/16.
 */
public class LoggingInterceptor implements Interceptor {
  private static final Charset UTF8 = Charset.forName("UTF-8");
  private LoggingProvider loggingProvider;

  @Inject public LoggingInterceptor(LoggingProvider loggingProvider) {
    this.loggingProvider = loggingProvider;
  }

  /**
   * Returns true if the body in question probably contains human readable text. Uses a small
   * sample
   * of code points to detect unicode control characters commonly used in binary file signatures.
   */
  static boolean isPlaintext(Buffer buffer) {
    try {
      Buffer prefix = new Buffer();
      long byteCount = buffer.size() < 64 ? buffer.size() : 64;
      buffer.copyTo(prefix,
                    0,
                    byteCount);
      for (int i = 0; i < 16; i++) {
        if (prefix.exhausted()) {
          break;
        }
        int codePoint = prefix.readUtf8CodePoint();
        if (Character.isISOControl(codePoint) && !Character.isWhitespace(codePoint)) {
          return false;
        }
      }
      return true;
    } catch (EOFException e) {
      return false; // Truncated UTF-8 sequence.
    }
  }

  @Override public Response intercept(Interceptor.Chain chain) throws IOException {
    Request request = chain.request();
    RequestBody requestBody = request.body();
    boolean hasRequestBody = requestBody != null;

    Connection connection = chain.connection();
    Protocol protocol = connection != null ? connection.protocol() : Protocol.HTTP_1_1;
    String requestStartMessage = "--> " + request.method() + ' ' + request.url() + ' ' + protocol;
    loggingProvider.d(requestStartMessage);
    if (!hasRequestBody) {
      loggingProvider.d("NO BODY FOUND " + request.method());
    } else {
      Buffer buffer = new Buffer();
      requestBody.writeTo(buffer);

      Charset charset = UTF8;
      MediaType contentType = requestBody.contentType();
      if (contentType != null) {
        charset = contentType.charset(UTF8);
      }
      if (isPlaintext(buffer)) {
        loggingProvider.json(buffer.readString(charset));
      }
    }

    Response response = chain.proceed(request);

    if (response.body() != null) {
      String bodyString = response.body()
          .string();
      loggingProvider.json(bodyString);

      response = response.newBuilder()
          .body(ResponseBody.create(response.body()
                                        .contentType(),
                                    bodyString))
          .build();
    } else {
      loggingProvider.e("The response does not contain a valid JSON, the reason is not clear at this point");
    }
    return response;
  }
}
