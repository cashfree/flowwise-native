package com.cashfree.extensions.gateway.domains.webhook;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class DisputeWebhookProcessingResult extends WebhookProcessingResult {
  // Add Dispute specific  attributes  here
  private String disputeStatus;
  private String disputeType;
}
