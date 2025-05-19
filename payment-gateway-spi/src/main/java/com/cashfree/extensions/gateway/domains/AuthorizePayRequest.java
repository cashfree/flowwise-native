package com.cashfree.extensions.gateway.domains;

import com.cashfree.extensions.gateway.constants.Action;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class AuthorizePayRequest {
  private Action action;
  private String orderId;
  private String paymentId;
  private String currency;

  private BigDecimal captureAmount; // in case of capture
}
