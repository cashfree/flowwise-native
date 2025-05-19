package com.cashfree.extensions.gateway.domains.internal;

import lombok.Data;

@Data
public class Address {
  private String address1;
  private String address2;
  private State state;
  private String city;
  private String zipcode;
  private Country country;

  @Data
  public static class Country {
    private String name;
    private String isoCode2;
  }

  @Data
  public static class State {
    private String name;
    private String isoCode2;
  }
}
