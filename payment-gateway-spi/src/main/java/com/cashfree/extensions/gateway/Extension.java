package com.cashfree.extensions.gateway;

import com.cashfree.extensions.gateway.domains.webhook.WebhookProcessor;
import com.cashfree.extensions.gateway.gateway.PaymentGateway;
import java.util.Collections;
import java.util.List;

public interface Extension {

  default List<PaymentGateway> getPaymentGateways() {
    return Collections.emptyList();
  }

  default List<WebhookProcessor> getWebhookProcessors() {
    return Collections.emptyList();
  }
}
