package com.cashfree.extensions.gateway.domains;

import com.cashfree.extensions.gateway.constants.PayConstants.PaymentRefundStatus;
import com.cashfree.extensions.gateway.constants.PayConstants.PaymentRefundType;
import com.cashfree.extensions.gateway.utils.JsonUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class PaymentRefundResponse {

  @JsonProperty(value = "payment_id")
  private String paymentId;

  @JsonProperty(value = "order_id ")
  private String orderId;

  @JsonProperty(value = "refund_id")
  private String refundId;

  @JsonProperty(value = "refund_amount")
  private BigDecimal refundAmount;

  @JsonProperty(value = "refund_status")
  private PaymentRefundStatus refundStatus;

  @JsonProperty(value = "refund_type")
  private PaymentRefundType refundType;

  @JsonProperty(value = "refund_note")
  private String refundNote;

  @JsonProperty(value = "refund_message")
  private String refundMessage;

  @JsonProperty(value = "gateway_details")
  private GatewayRefundDetailsDTO gatewayDetails;

  @Override
  public String toString() {
    return JsonUtil.prettyPrint(this, false);
  }
}
