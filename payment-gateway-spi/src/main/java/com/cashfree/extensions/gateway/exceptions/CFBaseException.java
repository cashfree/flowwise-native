package com.cashfree.extensions.gateway.exceptions;

import com.cashfree.extensions.gateway.domains.internal.ErrorData;
import com.cashfree.extensions.gateway.domains.internal.PGError;
import lombok.Getter;

@Getter
public class CFBaseException extends RuntimeException {

  @Getter private ErrorData errorData;
  private PGError pgError;

  public CFBaseException() {
    super();
  }

  public CFBaseException(ErrorData errorData) {
    super(errorData.getMessage());
    this.errorData = errorData;
  }

  public CFBaseException(ErrorData errorData, String message) {
    super(message);
    this.errorData = errorData;
  }

  public CFBaseException(String message) {
    super(message);
  }

  public CFBaseException(String message, PGError pgError) {
    super(message);
    this.pgError = pgError;
  }

  public CFBaseException(Throwable t) {
    super(t);
  }

  public CFBaseException(String message, Throwable cause) {
    super(message, cause);
  }
}
