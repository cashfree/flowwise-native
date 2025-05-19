package com.cashfree.extensions.gateway.constants.error;

public class ErrorMessage {

  public static final String ID_ALREADY_EXISTS = " with given id already exists";
  public static final String ID_ALREADY_USED = " is already used";
  public static final String ALREADY_EXISTS = " already exists";
  public static final String ID_NOT_FOUND = " with given id not found";
  public static final String CODE_NOT_FOUND = " with given code not found";
  public static final String RESOURCE_NOT_FOUND = "resource not found";
  public static final String INVALID_VALUE = "invalid value";
  public static final String PARAMETER_MISSING = "parameter missing";
  public static final String HEADER_MISSING = "header missing";
  public static final String REQUEST_VALIDATION_FAILED = "Request validation failed";
  public static final String CONSTRAINTS_VIOLATED = "Constraints Violated";
  public static final String SOMETHING_WENT_WRONG = "something went wrong";
  public static final String REQUEST_TIMEOUT = "request timed out";
  public static final String UNSUPPORTED_OPERATION = " is not supported for this operation";
  public static final String NO_ORDER_EXISTS = "No order entity exists with id: ";
  public static final String ORDER_NOT_PAID = "Order Is Not Paid ";
  public static final String PAYMENT_GATEWAY_NOT_ENABLED = "Payment Gateway not Enabled";

  public static final String REFUND_ALREADY_IN_PROCESS =
      "One refund request is already being processed";
  public static final String REFUND_TIME_EXCEED =
      "Refund cannot be initiated for payments older than six months";

  public static final String ORDER_ALREADY_EXISTS =
      "Order already exists for the provided order_id";
  public static final String INVALID_MAX_ORDER_AMOUNT =
      "Order amount exceeds the maximum allowed limit.";
  public static final String INVALID_MIN_ORDER_AMOUNT =
      "The order amount is less than the allowed minimum.";
  public static final String INVALID_ORDER_EXPIRY_TIME =
      "Order expiry time should be greater than current time";

  public static final String REFUND_ENTITY_ALREADY_EXISTS =
      "Refund Entity already exists for the provided refund_id";
}
