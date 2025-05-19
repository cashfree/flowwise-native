package com.cashfree.extensions.gateway.constants.error;

public enum ErrorCode {
  VALUE_INVALID("value_invalid"),
  NOT_FOUND("not_found"),
  ALREADY_EXISTS("already_exists"),
  MISSING("missing"),
  UNSUPPORTED("unsupported"),
  FAILED("failed"),
  API_ERROR("api_error"),
  REQUEST_TIMEOUT("request_timeout"),
  JSON_CONVERSION_FAILED("json_conversion_failed"),
  TRANSACTION_LIMIT_REACHED_FOR_ORDER("transaction_limit_reached_for_order"),
  INTERNAL_SERVICE_ERROR("internal_service_error"),
  UNAUTHORIZED("unauthorized"),
  FORBIDDEN("forbidden"),
  PG_ERROR("pg_error"),
  WRONG_CREDENTIALS("wrong_credentials"),
  REQUEST_INVALID("request_invalid");

  private String description;

  ErrorCode(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}
