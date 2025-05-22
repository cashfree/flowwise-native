package com.cashfree.extensions.gateway.exceptions;

import com.cashfree.extensions.gateway.domains.internal.PGError;

public class ReconRefundPGInvalidResponseException extends CFGatewayException {
  private PGError pgError;

  public ReconRefundPGInvalidResponseException(String message) {
    super(message);
  }

  public ReconRefundPGInvalidResponseException(String message, PGError pgError) {
    super(message);
    this.pgError = pgError;
  }
}
