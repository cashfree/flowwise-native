package com.cashfree.extensions.gateway.domains.webhook;

import java.math.BigDecimal;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class RefundWebhookProcessingResult extends WebhookProcessingResult {
  private String paymentId;
  private String orderId;
  private String utr;
  private BigDecimal refundAmount;
  private String refundRefId;
}
