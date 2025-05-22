package com.cashfree.extensions.gateway.exceptions;

import lombok.Getter;

@Getter
public class ValidationResponseException extends CFGatewayException {

  public ValidationResponseException(String message) {
    super(message);
  }

  @Override
  public String toString() {
    return new StringBuilder("message :: ")
        .append(super.toString())
        .append(" , pg :: ")
        .append(" , mode :: ")
        .toString();
  }
}
