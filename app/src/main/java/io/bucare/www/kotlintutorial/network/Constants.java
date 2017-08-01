package io.bucare.www.kotlintutorial.network;

public class Constants {
  private Constants() {
  }

  public static final class BackEndStatusCode {
    public static final int STATUS_OK = 0;
    public static final int STATUS_MODEL_ERROR = -1;
    public static final int STATUS_ERROR = -1;
    public static final int STATUS_UNAUTHORIZED_USER = 401;
    public static final int CANCELED = -2;
    public static final int STATUS_ERROR_RESOURCE_NOT_FOUND = 1001;
    public static final int STATUS_ERROR_DEV_APP_EXISTS_ALREADY_IN_DB = 1002;
    public static final int STATUS_ERROR_REQUIRED_FIELD_IS_EMPTY = 1101;
    public static final int STATUS_ERROR_REQUIRED_FIELD_IS_MISSING = 1102;
    public static final int STATUS_ERROR_FIELD_IS_TOO_LONG = 1103;
    public static final int STATUS_ERROR_INVALID_NAME = 1104;
    public static final int STATUS_ERROR_TAGS_ARE_INVALID = 1105;
    public static final int STATUS_ERROR_URL_ARE_INVALID = 1106;
    public static final int STATUS_ERROR_TOO_MANY_IMAGES = 1107;
    public static final int STATUS_ERROR_INVALID_IMAGE_TYPE = 1201;
    public static final int STATUS_ERROR_INVALID_IMAGE_SIZE = 1202;
    public static final int STATUS_NOT_NETWORK_AVAILABLE = 1998;
    public static final int STATUS_UNKNOWN_ERROR = 1999;

    private BackEndStatusCode() {

    }
  }
}
