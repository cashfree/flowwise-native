package com.cashfree.extensions.gateway.domains.gateway;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PayCard {

  private String cardDataType;

  private String cardNumber;

  private String cardHolder;

  private String cardCvv = "";

  private String expiryMonth;

  private String expiryYear;

  private String cardType;

  private String cardScheme;

  private String bankName;

  // Card token related fields below

  private String tokenCryptogram;

  private String tokenCryptogramIssuer;

  private String cardSuffix;

  private String tokenCardIssuerId;

  private boolean saveCard;
}
