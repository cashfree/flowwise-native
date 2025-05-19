package com.cashfree.extensions.gateway.domains.extension;

import lombok.Data;

@Data
public class DropdownOptions {
  private String value;
  private String displayName;

  public DropdownOptions(String value, String displayName) {
    this.value = value;
    this.displayName = displayName;
  }
}
