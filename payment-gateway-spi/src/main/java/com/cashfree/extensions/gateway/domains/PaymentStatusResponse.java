package com.cashfree.extensions.gateway.domains;

import com.cashfree.extensions.gateway.constants.CaptureStatus;
import com.cashfree.extensions.gateway.constants.PayConstants;
import com.cashfree.extensions.gateway.domains.internal.PGError;
import com.cashfree.extensions.gateway.utils.JsonUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class PaymentStatusResponse {

  @JsonProperty(value = "order_id")
  private String orderId;

  @JsonProperty(value = "payment_id")
  private String paymentId;

  private PayConstants.PaymentStatus status;

  @JsonProperty("capture_status")
  private CaptureStatus captureStatus;

  @JsonProperty("capture_amount")
  private BigDecimal captureAmount;

  @JsonProperty(value = "payment_amount")
  private BigDecimal paymentAmount;

  @JsonProperty(value = "payment_currency")
  private String paymentCurrency;

  @JsonProperty(value = "payment_method")
  private String paymentMethod;

  @JsonProperty(value = "payment_message")
  @JsonInclude(Include.NON_EMPTY)
  private String paymentMessage;

  @JsonProperty(value = "redirect_url")
  @JsonInclude(Include.NON_EMPTY)
  private String redirectUrl;

  @JsonProperty(value = "gateway_details")
  private GatewayPaymentDetailsDTO gatewayDetails;

  @JsonProperty(value = "error_details")
  @JsonInclude(Include.NON_NULL)
  private PGError pgError;

  @Override
  public String toString() {
    return JsonUtil.prettyPrint(this, false);
  }
}
