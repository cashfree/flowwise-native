package com.cashfree.extensions.gateway.domains.webhook;

import com.cashfree.extensions.gateway.domains.extension.ExtensionConfigMapResponse;

public interface WebhookProcessor {
  // return uniq id from webhook headers
  String getWebhookId(WebhookMessage message);

  WebhookProcessingResult processWebhook(
      WebhookMessage message, ExtensionConfigMapResponse configMap);

  String getPgName();
}
