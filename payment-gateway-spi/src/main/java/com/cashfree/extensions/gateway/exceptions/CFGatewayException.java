package com.cashfree.extensions.gateway.exceptions;

import com.cashfree.extensions.gateway.domains.internal.ErrorData;
import com.cashfree.extensions.gateway.domains.internal.PGError;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CFGatewayException extends RuntimeException {

  private ErrorData errorData;
  private PGError pgError;

  public CFGatewayException() {
    super();
  }

  public CFGatewayException(ErrorData errorData) {
    super();
    this.errorData = errorData;
  }

  public CFGatewayException(ErrorData errorData, String message) {
    super(message);
    this.errorData = errorData;
  }

  public CFGatewayException(String message) {
    super(message);
  }

  public CFGatewayException(Throwable t) {
    super(t);
  }

  public CFGatewayException(String message, PGError pgError) {
    super(message);
    this.pgError = pgError;
  }

  public CFGatewayException(String message, Throwable cause) {
    super(message, cause);
  }

  public ErrorData getErrorData() {
    return errorData;
  }
}
