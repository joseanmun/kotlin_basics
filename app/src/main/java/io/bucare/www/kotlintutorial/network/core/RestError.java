package io.bucare.www.kotlintutorial.network.core;

import com.google.gson.annotations.SerializedName;
import io.bucare.www.kotlintutorial.network.Constants;

public class RestError {
  @SerializedName("statusCode") private Integer code =
      Constants.BackEndStatusCode.STATUS_UNKNOWN_ERROR;
  @SerializedName("error_message") private String strMessage = "";

  public RestError(String strMessage) {
    this.strMessage = strMessage;
  }

  public RestError(Integer code) {
    this.code = code;
  }

  public RestError(Integer code, String strMessage) {
    this.code = code;
    this.strMessage = strMessage;
  }

  public RestError(Exception e) {
    // TODO: 4/07/16 Implement the logic for the different exceptions
    if (isSessionExpired(e)) {
      this.code = Constants.BackEndStatusCode.STATUS_UNAUTHORIZED_USER;
    } else {
      this.code = Constants.BackEndStatusCode.STATUS_UNKNOWN_ERROR;
      this.strMessage = e.getMessage();
    }
  }

  public boolean isSessionExpired(Throwable e) {
    return false;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getStrMessage() {
    return strMessage;
  }

  public void setStrMessage(String strMessage) {
    this.strMessage = strMessage;
  }
}
