package com.cashfree.extensions.gateway.constants;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.List;
import java.util.Map;

public class PayConstants {

  public static final String TPV_WHITELIST_ACC = "whitelist_acc";

  public static final String TPV_WHITELIST_IFSC = "whitelist_ifsc";

  public static final Map<String, PaymentStatus> paymentStatusMap =
      Map.of(
          "SUCCESS", PaymentStatus.SUCCESS,
          "FAILED", PaymentStatus.FAILED,
          "REDIRECTED", PaymentStatus.REDIRECTED,
          "PENDING", PaymentStatus.PENDING,
          "USER_DROPPED", PaymentStatus.USER_DROPPED,
          "INITIATED", PaymentStatus.INITIATED);

  public static String getDefaultAttemptMessage(PaymentStatus transactionStatus) {
    switch (transactionStatus) {
      case SUCCESS:
        return TransactionDefaultMessage.TXN_SUCCESS_MSG.messageString;
      case FAILED:
        return TransactionDefaultMessage.TXN_FAILED_MSG.messageString;
      case PENDING:
        return TransactionDefaultMessage.TXN_PENDING_MSG.messageString;
      case USER_DROPPED:
        return TransactionDefaultMessage.TXN_USER_DROPPED_MSG.messageString;
      case REVERSED:
        return TransactionDefaultMessage.TXN_REVERSED_MSG.messageString;
      default:
        return TransactionDefaultMessage.TXN_INCOMPLETE_MSG.messageString;
    }
  }

  public enum TransactionDefaultMessage {
    TXN_SUCCESS_MSG("Payment Success"),
    TXN_FAILED_MSG("Payment Failed"),
    TXN_CANCELLED_MSG("Payment Cancelled"),
    TXN_PENDING_MSG("Payment Pending"),
    TXN_INCOMPLETE_MSG("Payment Incomplete"),
    TXN_REVERSED_MSG("Payment Auto Refund"),
    TXN_USER_DROPPED_MSG("Payment User Dropped");
    String messageString;

    TransactionDefaultMessage(String messageString) {
      this.messageString = messageString;
    }

    @JsonValue
    public String getMessageString() {
      return this.messageString;
    }
  }

  public enum PaymentMode {
    CREDIT_CARD,
    DEBIT_CARD,
    PREPAID_CARD,
    CORPORATE_CREDIT_CARD,
    CREDIT_CARD_EMI,
    NET_BANKING,
    PAY_LATER,
    EMI,
    DEBIT_CARD_EMI,
    UPI,
    CARDLESS_EMI,
    WALLET,
    CARD
  }

  public enum PayUPIType {
    COLLECT,
    INTENT,
    QR_CODE
  }

  public enum Currency {
    INR
  }

  public enum OrderStatus {
    PAID,
    ACTIVE,
    EXPIRED
  }

  public enum PaymentStatus {
    SUCCESS("SUCCESS"),
    FAILED("FAILED"),
    REDIRECTED("REDIRECTED"),
    PENDING("PENDING"),
    INITIATED("INITIATED"),
    USER_DROPPED("USER_DROPPED"),
    REVERSED("REVERSED"),
    INIT_FAILED("INIT_FAILED");
    /* All below status have been removed on 28th April 2025
    REFUNDED("REFUNDED"),
    CANCELLED("CANCELLED"),
    NOT_ATTEMPTED("NOT_ATTEMPTED"),
    SUCCESS_CONFLICT("SUCCESS_CONFLICT"),
    VOID("VOID"),
    VOID_FAILED("VOID_FAILED"),
    CREATED("CREATED"),
    INVALID("INVALID");
     */

    String statusString;

    PaymentStatus(String statusString) {
      this.statusString = statusString;
    }

    @JsonValue
    public String getStatusString() {
      return this.statusString;
    }
  }

  public enum EventLogType {
    ORDER_CREATION,
    PAYMENT_CREATION,
    RULES_EXECUTION_REQUEST,
    RULES_EXECUTION_RESPONSE,
    DYNAMIC_ROUTING_RESPONSE,
    PAYMENT_REDIRECT,
    PAYMENT_RECONCILE,
    FORCE_PAYMENT_RECONCILE_API,
    FORCE_PAYMENT_RECONCILE_DASHBOARD,
    FORCE_ORDER_RECONCILE_API,
    FORCE_ORDER_RECONCILE_DASHBOARD,
    WEBHOOK_DECRYPT,
    ORDER_UPDATE,
    PAYMENT_UPDATE,
    PAYMENT_AUTHORIZATION,
    USER_DROPPED_PAYMENT,
    AUTO_REFUND,
    REFUND_REQUEST,
    REFUND_RESPONSE,
    WEBHOOK_PAYMENT_UPDATE,
    WEBHOOK_REFUND_UPDATE,
    NOTIFICATION,
    PAYMENT_CREATION_FAILED_AT_GATEWAY
  }

  public enum ForceReconStatus {
    SUCCESS("RECONCILIATION SUCCESSFUL"),
    FAILED("RECONCILIATION FAILED");
    final String reconciliationMessage;

    ForceReconStatus(String reconciliationMessage) {
      this.reconciliationMessage = reconciliationMessage;
    }

    @JsonValue
    public String getReconciliationMessage() {
      return this.reconciliationMessage;
    }
  }

  public enum PaymentRefundStatus {
    SUCCESS("SUCCESS"),
    FAILED("FAILED"),
    USER_DROPPED("USER_DROPPED"),
    CANCELLED("CANCELLED"),
    PENDING("PENDING");
    String statusString;

    PaymentRefundStatus(String statusString) {
      this.statusString = statusString;
    }

    @JsonValue
    public String getStatusString() {
      return this.statusString;
    }
  }

  public enum PaymentRefundType {
    MERCHANT_INITIATED,
    CUSTOMER_INITIATED,
    AUTO_REFUND
  }

  public enum RefundDefaultMessage {
    REFUND_SUCCESS_MSG("Refund is Initiated"),
    REFUND_FAILED_MSG("Refund has Failed"),
    REFUND_PENDING_MSG("Refund is Pending");
    String messageString;

    RefundDefaultMessage(String messageString) {
      this.messageString = messageString;
    }

    @JsonValue
    public String getMessageString() {
      return this.messageString;
    }
  }

  public static String getDefaultRefundMessage(PaymentRefundStatus refundStatus) {
    switch (refundStatus) {
      case SUCCESS:
        return RefundDefaultMessage.REFUND_SUCCESS_MSG.messageString;
      case FAILED:
        return RefundDefaultMessage.REFUND_FAILED_MSG.messageString;
      default:
        return RefundDefaultMessage.REFUND_PENDING_MSG.messageString;
    }
  }

  public static final List<String> NON_TERMINAL_STATUSES =
      List.of(
          PaymentStatus.INITIATED.getStatusString(),
          PaymentStatus.REDIRECTED.getStatusString(),
          PaymentStatus.PENDING.getStatusString());

  public static final List<PaymentStatus> TERMINAL_STATUSES =
      List.of(
          PaymentStatus.SUCCESS,
          PaymentStatus.FAILED,
          PaymentStatus.USER_DROPPED,
          PaymentStatus.INIT_FAILED,
          PaymentStatus.REVERSED);
}
