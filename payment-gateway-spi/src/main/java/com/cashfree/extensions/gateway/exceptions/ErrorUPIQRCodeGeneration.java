package com.cashfree.extensions.gateway.exceptions;

public class ErrorUPIQRCodeGeneration extends RuntimeException {
  public ErrorUPIQRCodeGeneration(String message) {
    super(message);
  }
}
