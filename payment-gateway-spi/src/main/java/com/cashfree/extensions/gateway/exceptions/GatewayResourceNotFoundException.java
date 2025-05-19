package com.cashfree.extensions.gateway.exceptions;

import com.cashfree.extensions.gateway.domains.internal.ErrorData;

public class GatewayResourceNotFoundException extends CFGatewayException {

  public GatewayResourceNotFoundException(ErrorData errorData) {
    super(errorData);
  }
}
