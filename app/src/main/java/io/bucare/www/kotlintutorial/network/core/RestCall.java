package io.bucare.www.kotlintutorial.network.core;

import android.util.Log;
import retrofit2.Call;

public class RestCall<T> {
  private final String TAG = "RestCall";
  private final Call<T> call;

  public RestCall(Call<T> call) {
    this.call = call;
  }

  public RestResponse<T> execute() {
    RestResponse<T> restResponse;
    try {
      restResponse = new RestResponse<>(call.execute());
    } catch (Exception e) {
      Log.e(TAG,
            e.getMessage(),
            e.getCause());
      restResponse = new RestResponse<>(e);
    }
    return restResponse;
  }
}
