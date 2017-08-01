package io.bucare.www.kotlintutorial.network.core;

import com.google.gson.annotations.SerializedName;

public class ResponseStatus {
  @SerializedName("code") private int code;
  @SerializedName("message") private String message;

  public int getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }
}
