package com.cashfree.extensions.gateway.exceptions;

public class ResponseParseException extends CFGatewayException {
  public ResponseParseException(String message) {
    super(message);
  }

  public ResponseParseException(String message, Throwable cause) {
    super(message, cause);
  }
}
