package com.cashfree.extensions.gateway.exceptions;

import com.cashfree.extensions.gateway.domains.internal.PGError;

public class RefundPGInvalidResponseException extends CFGatewayException {
  private PGError pgError;

  public RefundPGInvalidResponseException(String message) {
    super(message);
  }

  public RefundPGInvalidResponseException(String message, PGError pgError) {
    super(message);
    this.pgError = pgError;
  }
}
