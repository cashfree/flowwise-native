package com.cashfree.extensions.gateway.domains;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class VerifyOTPRequest {

  private String paymentId;

  private String orderId;

  private BigDecimal paymentAmount;

  private String currency;

  private String paymentMethod;

  private String processorRef;

  private String paymentHash;

  private String otp;

  private String verifyOTPUrl;
}
