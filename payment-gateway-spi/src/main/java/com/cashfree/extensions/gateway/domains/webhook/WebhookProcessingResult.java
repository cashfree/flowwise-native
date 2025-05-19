package com.cashfree.extensions.gateway.domains.webhook;

import com.cashfree.extensions.gateway.domains.internal.PGError;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public abstract class WebhookProcessingResult {
  private WebhookEntityType entityType;
  private String gatewayRefId;
  private WebhookEventStatus status;
  private String eventType;
  private PGError error;
}
