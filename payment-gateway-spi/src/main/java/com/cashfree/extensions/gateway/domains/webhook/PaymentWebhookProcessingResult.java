package com.cashfree.extensions.gateway.domains.webhook;

import java.math.BigDecimal;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class PaymentWebhookProcessingResult extends WebhookProcessingResult {
  private String utr;
  private String orderId;
  private BigDecimal amount;
}
