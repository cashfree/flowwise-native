package com.cashfree.extensions.gateway.exceptions;

public class WebhookSignatureValidationException extends CFBaseException {
  public WebhookSignatureValidationException(String message) {
    super(message);
  }
}
