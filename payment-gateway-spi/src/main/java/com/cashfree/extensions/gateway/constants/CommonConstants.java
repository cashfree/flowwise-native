package com.cashfree.extensions.gateway.constants;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class CommonConstants {
  public static final String EMPTY_STRING = "";
  public static final String SPACE = " ";
  public static final String REDIRECTION_LINK = "link";
  public static final String REDIRECTION_FORM_TYPE = "form";
  public static final String REDIRECTION_FORM_POST = "POST";
  public static final String MULTIPART_FORM_DATA = "multipart/form-data";
  public static final String PIPE = "|";
  public static final String PIPE_WITH_SPACE = " | ";
  public static final String UNDERSCORE = "_";
  public static final String COLON_WITH_SPACE = " : ";
  public static final String ID = "id";
  public static final String UPDATED_ON = "updatedOn";

  public static final String MODE_NAME = "modeName";

  public static final String MODE_CODE = "modeCode";
  public static final String CURRENCY_CODE = "currencyCode";
  public static final String PAYMENT_GROUP = "paymentGroup";
  public static final String MID = "MID";
  public static final String SECRET_KEY = "secretKey";
  public static final String ACCOUNT_ID = "accountId";
  public static final String ORDER_ID = "order_id";
  public static final String CASHFREE = "cashfree";
  public static final String AMOUNT = "amount";
  public static final String PAYMENT_ID = "payment_id";
  public static final String PAYMENT_METHOD = "payment_method";
  public static final String ORDER_AMOUNT = "order_amount";
  public static final String ORDER_CURRENCY = "order_currency";
  public static final String UDF1 = "udf1";
  public static final String UDF2 = "udf2";
  public static final String UDF3 = "udf3";
  public static final String WEBHOOK_PAYLOAD = "webhook_payload";
  public static final String GATEWAY = "gateway";
  public static final String ROUTING = "routing";
  public static final String PAYMENT_HASH = "payment_hash";
  public static final String SUCCESS_PAYMENT_ENTITY = "success_payment_entity";
  public static final String PAYMENT_REFUND_ID = "refund_id";
  public static final String PHONEPE_PAYMENT_ID = "phonepe_payment_id";
  public static final String RAZORPAY_PAYMENT_ID = "razorpay_payment_id";
  public static final String RAZORPAY_ORDER_ID = "razorpay_order_id";
  public static final String RAZORPAY_SIGNATURE = "razorpay_signature";
  public static final String ORDER_ENTITY = "order_entity";
  public static final String NETBANKING_BANK_CODE = "netbanking_bank_code";
  public static final String CUSTOMER_NAME = "customer_name";
  public static final String VPA = "vpa";
  public static final String CHANNEL = "channel";
  public static final String INDEX_QR_URL = "{{index . \"qrUrl\"}}";
  public static final String INDEX_INTENT_URL = "{{index . \"intentUrl\"}}";
  public static final String INDEX_POLLING_URL = "{{index . \"pollingUrl\"}}";
  public static final String INDEX_RETURN_URL = "{{index . \"returnUrl\"}}";
  public static final String INDEX_AMOUNT = "{{index . \"amount\"}}";
  public static final String INDEX_CURRENCY = "{{index . \"currency\"}}";
  public static final String INDEX_URL_TYPE = "{{index . \"urlType\"}}";
  public static final String CARD_NUMBER = "card_number";
  public static final String CARD_HOLDER_NAME = "card_holder_name";
  public static final String CARD_EXPIRY_MM = "card_expiry_mm";
  public static final String CARD_EXPIRY_YY = "card_expiry_yy";
  public static final String CARD_CVV = "card_cvv";
  private static final String TOKEN_DETAILS = "tokenDetails";

  public static final String CARD = "card";
  public static final String NETBANKING = "netbanking";
  public static final String UPI = "upi";
  public static final String WALLET = "wallet";
  public static final String CARD_SCHEME = "card_scheme";
  public static final String CARD_BIN = "card_bin";
  public static final String CARD_BANK_NAME = "card_bank_name";
  public static final String CARD_COUNTRY = "card_country";
  public static final String NETBANKING_BANK_NAME = "netbanking_bank_name";
  public static final String INTENT = "intent";
  public static final String QR_CODE = "qrcode";
  public static final String COLLECT = "collect";
  public static final LocalDateTime START_TIME = LocalDateTime.of(2000, 1, 1, 0, 0, 0);
  public static final LocalDateTime END_TIME = LocalDateTime.of(2100, 1, 1, 0, 0, 0);
  public static final String FORWARD_SLASH = "/";
  public static final String ERROR_CODE = "error_code";
  public static final String ERROR_DESCRIPTION = "error_description";

  public static final Long DEFAULT_ORDER_EXPIRY_TIME_IN_MINUTES = 43200L;
  public static final String HTTP_AGENT_BROWSER = "userAgentBrowserValue";
  public static final String DEFAULT_USER_AGENT_VALUE =
      "Mozilla/5.0 (X11; Ubuntu; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.61 Safari/537.36 RuxitSynthetic/1.0 v346893929 t18859";
  public static final String ENVIRONMENT = "environment";
  public static final String STATUS = "status";
  public static final String EXTENSION_ENTITY = "extensionEntity";
  public static final String CUSTOMER_ID = "customer_id";
  public static final String IS_SAVED_CARD = "is_saved_card";
  public static final String TOKEN_REQUESTOR_ID = "token_requestor_id";
  public static final String CARD_DISPLAY = "card_display";
  public static final String CRYPTOGRAM = "cryptogram";
  public static final String INSTRUMENT_ID = "instrument_id";
  public static final String CARD_TYPE = "card_type";
  public static final String CARD_EXPIRY_YEAR_PREFIX = "20";

  public static final String WEBHOOKS_SORT_COLUMN = "receivedAt";

  public static final Map<String, String> CARD_DETAILS_PLACEHOLDER =
      Map.of(
          CARD_NUMBER, "(( CARD_NUMBER ))",
          CARD_HOLDER_NAME, "(( CARD_HOLDER_NAME ))",
          CARD_CVV, "(( CARD_CVV ))",
          CARD_EXPIRY_MM, "(( CARD_EXPIRY_MM ))",
          CARD_EXPIRY_YY, "(( CARD_EXPIRY_YY ))");

  public static Map<String, Object> convertToMap(Object obj) {
    Map<String, Object> resultMap = new HashMap<>();
    Class<?> clazz = obj.getClass();

    Field[] fields = clazz.getDeclaredFields();
    try {
      for (Field field : fields) {
        field.setAccessible(true);

        String fieldName = field.getName();
        Object fieldValue = field.get(obj);

        resultMap.put(fieldName, fieldValue);
      }
    } catch (Exception e) {
      return null;
    }
    return resultMap;
  }

  public static final String WEIGHTED_DR = "WEIGHTED_DR";
  public static final String PURE_DR = "PURE_DR";
  public static final String SUCCESS_RATE_THRESHOLD = "success_rate_threshold";
  public static final String WEIGHTED_DR_ALGO = "weighted_dr_algo";

  public enum UrlType {
    IMAGE,
    LINK
  }

  public static final Map<UrlType, String> eligibleUrlTypes =
      Map.of(
          UrlType.IMAGE, "img",
          UrlType.LINK, "link");

  public static final String DEFAULT_PHONE = "9898989898";
  public static final String DEFAULT_EMAIL = "customer@customer.com";
}
