package io.bucare.www.kotlintutorial.network.services;

import io.bucare.www.kotlintutorial.network.core.BaseResponse;
import io.bucare.www.kotlintutorial.network.core.RestCall;
import io.bucare.www.kotlintutorial.network.model.RestUser;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserService {
  @GET("user/{name}") RestCall<BaseResponse<RestUser>> getUser(@Path("name") String username);
  @PUT("user") RestCall<BaseResponse> updateUser(@Body RestUser restUser);
}
