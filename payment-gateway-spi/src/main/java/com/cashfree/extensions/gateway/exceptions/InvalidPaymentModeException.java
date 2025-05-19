package com.cashfree.extensions.gateway.exceptions;

public class InvalidPaymentModeException extends RuntimeException {

  public InvalidPaymentModeException(String message) {
    super(message);
  }
}
