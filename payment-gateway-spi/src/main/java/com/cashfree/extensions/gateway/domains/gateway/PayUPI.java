package com.cashfree.extensions.gateway.domains.gateway;

import java.time.LocalDateTime;
import java.util.Optional;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PayUPI {

  private String userVPA;

  @Deprecated private Long expiry;

  private String payMode;

  private LocalDateTime expireOn;

  private Optional<String> whitelistAccount;

  private Optional<String> whitelistIfsc;

  private Optional<String> mcc;

  private Optional<String> purpose;

  public boolean isTPV() {
    return this.whitelistAccount.isPresent() && this.whitelistIfsc.isPresent();
  }
}
