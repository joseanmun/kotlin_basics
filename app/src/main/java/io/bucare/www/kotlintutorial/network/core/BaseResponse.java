package io.bucare.www.kotlintutorial.network.core;

import com.google.gson.annotations.SerializedName;
import io.bucare.www.kotlintutorial.network.Constants;

public class BaseResponse<T> {
  @SerializedName("status") ResponseStatus status;
  @SerializedName("data") T data;

  public BaseResponse() {
    // Used for empty responses, when any data is needed
  }

  public BaseResponse(T data) {
    this.data = data;
  }

  public ResponseStatus getStatus() {
    return status;
  }

  public T getData() {
    return data;
  }

  public boolean isSuccesful() {
    return status.getCode() == Constants.BackEndStatusCode.STATUS_OK;
  }
}
