package com.cashfree.extensions.gateway.exceptions;

import com.cashfree.extensions.gateway.domains.internal.ErrorData;

public class UnAuthorizedRequestException extends CFBaseException {

  public UnAuthorizedRequestException(ErrorData errorData) {
    super(errorData);
  }

  public UnAuthorizedRequestException(String message) {
    super(message);
  }
}
