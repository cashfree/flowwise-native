package com.cashfree.extensions.gateway.constants;

public class EnvConstants {

  public static final String DEVO = "devo";
  public static final String MASTER = "master";
  public static final String PROD = "prod";
  public static final String AC = "ac";
  public static final String PG = "pg";

  public static final String REDIRECT_HTML = "templates/redirect.html";
  public static final String NATIVE_OTP_HTML = "templates/native_otp.html";
  public static final String UPI_QR_HTML = "templates/qr.html";
  public static final String UPI_INTENT_HTML = "templates/intent.html";
  public static final String STATUS_SUCCESS_HTML = "templates/status_success.html";
  public static final String STATUS_PENDING_HTML = "templates/status_pending.html";
  public static final String STATUS_FAILED_HTML = "templates/status_failed.html";

  public static final String HEALTH_CHECK = "OK";

  public static final String DB_INITIALIZR =
      "%s:%s://%s:%s/%s?useSSL=false&zeroDateTimeBehavior=convertToNull&useLegacyDatetimeCode=false&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";

  private EnvConstants() {}
}
