package com.cashfree.extensions.gateway.constants;

import com.cashfree.extensions.gateway.domains.internal.PGError;

public class ErrorConstants {

  public static final String INVALID_CARD_DATA_ERROR = "INVALID_CARD_DATA_ERROR";

  public static final String PAYMENT_METHOD_INVALID = "Invalid Payment Method";

  public static final String PROCESSOR_INVALID = "Invalid Processor";

  public static final String INVALID_CHECKSUM = "Invalid Checksum";

  public static final String WEBHOOK_INVALID = "Invalid webhook";

  public static final String CHRONOLOGY_INVALID = "Invalid Start time / end time combination";

  public static final String ORDER_ID_INVALID = "order_id invalid";

  public static final String INVALID_PG_RESPONSE_ERROR = "INVALID_PG_RESPONSE_ERROR";

  public static final String PAYMENT_ID_INVALID = "payment_id invalid";

  public static final String PAYMENT_NOT_FOUND = " payment not found";

  public static final String PAYMENT_NOT_FOUND_FOR_ORDER = "payment not found for order";

  public static final String SUCCESS_PAYMENT_NOT_FOUND =
      "Successful  payment not found for the given order_id";

  public static final String PAYMENT_NOT_SUCCESSFUL_FOR_REFUND_CREATION =
      "Payment was not successful, refund cannot be created.";
  public static final String PAYMENT_REFUND_NOT_FOUND = " payment refund not found";

  public static final String ORDER_ALREADY_PAID = "Order is already PAID for given order_id";

  public static final String ORDER_EXPIRED = "Order is expired for given order_id";
  public static final String MAX_TRANSACTION_REACHED_FOR_ORDER =
      "The maximum number of transactions has been reached for this order.";

  public static final String PAYMENT_AMOUNT_INVALID =
      "Payment amount cannot be different from the order amount";

  public static final String INVALID_WEBHOOK_PAYLOAD =
      "Invalid webhook payload provided or payment was not found";
  public static final String PAYMENT_ATTEMPT_IS_NOT_ELIGIBLE_FOR_REFUND =
      "Payment Attempt for the given hash need to be SUCCESSFUL to be able to initiate a refund";

  public static final String UNKNOWN_ERROR_CODE = "CN00";

  public static final String UNKNOWN_ERROR_MESSAGE = "Description/Reason not available";

  public static final String INVALID_AMOUNT =
      "Total refund amount cannot be greater than the payment amount";

  public static final String PAYMENT_METHOD_NOT_SUPPORTED_ON_PG =
      "Payment method not supported on the selected PG";

  private static final String ENCRYPTION_FAILURE_CODE = "ENCRYPTION_FAILURE";

  private static final String DECRYPTION_FAILURE_CODE = "DECRYPTION_FAILURE";
  public static final PGError ENCRYPTION_FAILURE_ERROR =
      PGError.builder()
          .pgErrorCode(ENCRYPTION_FAILURE_CODE)
          .pgErrorDescription("Error While Encrypting")
          .build();

  public static final PGError DECRYPTION_FAILURE_ERROR =
      PGError.builder()
          .pgErrorCode(DECRYPTION_FAILURE_CODE)
          .pgErrorDescription("Error While Decrypting")
          .build();

  public static final String INTERNAL_GATEWAY_ERROR_CODE = "INTERNAL_GATEWAY_ERROR";
  public static final String WRONG_CREDENTIALS = "WRONG_CREDENTIALS";
  public static final String INTERNAL_UNKNOWN_ERROR_CODE = "INTERNAL_UNKNOWN_ERROR";

  // User Flow
  public static final String USER_ID_INVALID = "User ID is invalid";
  public static final String ROLE_ID_INVALID = "Role ID is invalid";
  public static final String PERMISSION_ID_INVALID = "Permission ID is invalid";
  public static final String PROJECT_ID_INVALID = "Project ID is invalid";
  public static final String SESSION_ID_INVALID = "Session ID is invalid";
  public static final String EMAIL_INVALID = "Email is invalid";

  public static final String ORGANIZATION_ADMIN_FORBIDDEN = "Organization admin role forbidden";

  public static final String RECON_MISMATCH_NOT_FOUND = "Recon Mismatch Record not found";
}
