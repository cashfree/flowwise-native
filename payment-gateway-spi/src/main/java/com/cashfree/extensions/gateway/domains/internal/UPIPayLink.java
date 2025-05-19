package com.cashfree.extensions.gateway.domains.internal;

import java.math.BigDecimal;
import java.util.Optional;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UPIPayLink {
  private String upiProvider;
  private String merchantVpa;
  private String merchantName;
  private String transactionId;
  private BigDecimal amount;
  private String remarks;
  private Optional<String> mcc;
}
