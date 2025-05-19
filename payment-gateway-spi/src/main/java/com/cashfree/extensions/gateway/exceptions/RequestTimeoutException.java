package com.cashfree.extensions.gateway.exceptions;

import com.cashfree.extensions.gateway.domains.internal.ErrorData;

public class RequestTimeoutException extends CFGatewayException {

  public RequestTimeoutException(ErrorData errorData) {
    super(errorData);
  }
}
