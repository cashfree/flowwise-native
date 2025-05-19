package com.cashfree.extensions.gateway.exceptions;

import com.cashfree.extensions.gateway.domains.internal.ErrorData;

public class InvalidRequestException extends CFBaseException {

  public InvalidRequestException(String message) {
    super(message);
  }

  public InvalidRequestException(ErrorData errorData) {
    super(errorData);
  }
}
