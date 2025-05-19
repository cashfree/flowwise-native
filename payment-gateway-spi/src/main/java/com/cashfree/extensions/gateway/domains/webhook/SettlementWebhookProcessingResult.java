package com.cashfree.extensions.gateway.domains.webhook;

import com.cashfree.extensions.gateway.domains.settlement.SettlementDTO;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class SettlementWebhookProcessingResult extends WebhookProcessingResult {
  SettlementDTO settlementDTO;
}
