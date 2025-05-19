package com.cashfree.extensions.gateway.domains.webhook;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebhookMessage {
  private Integer extensionConfigId;
  private String headers;
  private String payload;
  private LocalDateTime receivedAt;
}
