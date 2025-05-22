package com.cashfree.extensions.gateway.exceptions;

import com.cashfree.extensions.gateway.domains.internal.ErrorData;

public class InvalidGatewayRequestException extends CFGatewayException {

  public InvalidGatewayRequestException(ErrorData errorData) {
    super(errorData);
  }
}
