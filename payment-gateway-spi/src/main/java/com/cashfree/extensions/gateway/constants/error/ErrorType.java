package com.cashfree.extensions.gateway.constants.error;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorType {
  CONNECTION_ERROR("connection_error"),
  INTERNAL_ERROR("internal_error"),
  GATEWAY_ERROR("gateway_error"),
  ELIGIBILITY_ERROR("eligibility_error"),
  WEBHOOK_ERROR("webhook_error"),
  PAYOUT_ERROR("payout_error"),
  VALIDATION_ERROR("validation_error"),
  AUTHENTICATION_ERROR("authentication_error"),
  AUTHORIZATION_ERROR("authorization_error"),
  REQUEST_INVALID("request_invalid"),
  CREDENTIALS_ERROR("credentials_error");
  private String description;

  ErrorType(String description) {
    this.description = description;
  }

  @JsonValue
  public String getDescription() {
    return description;
  }
}
