package com.cashfree.extensions.gateway.domains.internal;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@ToString
@Getter
public class PGError {

  @JsonProperty(value = "error_code")
  private String pgErrorCode;

  @JsonProperty(value = "error_description")
  private String pgErrorDescription;

  private Boolean updateTransactionData;

  private Map<String, String> transactionData;

  private boolean retryOnFailure = false;
}
