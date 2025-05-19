package com.cashfree.extensions.gateway.domains.internal;

import lombok.Data;

@Data
public class CustomerDetails {
  private String customerReferenceId;
  private Address customerAddress;
}
