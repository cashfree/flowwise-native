package com.cashfree.extensions.gateway.domains.gateway;

import java.util.Optional;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
@Builder
public class PayNB {

  private String bankId;

  private Optional<String> whitelistAccount;

  private Optional<String> whitelistIfsc;

  private String bankName;

  public boolean isTPV() {
    return this.whitelistAccount.isPresent()
        && this.whitelistIfsc.isPresent()
        && StringUtils.isNoneBlank(this.whitelistAccount.get(), this.whitelistIfsc.get());
  }
}
