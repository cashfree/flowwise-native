package com.cashfree.extensions.gateway.exceptions;

import com.cashfree.extensions.gateway.domains.internal.PGError;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class PayInitiateException extends CFGatewayException {
  PGError pgError;

  public PayInitiateException(String message) {
    super(message);
  }

  public PayInitiateException(String message, PGError pgError) {
    super(message);
    this.pgError = pgError;
  }

  public PayInitiateException(String message, String pgError) {
    super(message);
  }
}
