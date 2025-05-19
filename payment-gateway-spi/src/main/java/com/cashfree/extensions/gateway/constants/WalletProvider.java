package com.cashfree.extensions.gateway.constants;

import lombok.Getter;

@Getter
public enum WalletProvider {
  GPAY("wallet_gpay", "wallet_gpay"),
  PHONEPE("wallet_phonepe", "wallet_phonepe"),
  OLA("wallet_ola", "wallet_ola"),
  PAYTM("wallet_paytm", "wallet_paytm"),
  AMAZON_PAY("wallet_amazonpay", "wallet_amazonpay"),
  AIRTEL("wallet_airtel", "wallet_airtel"),
  FREECHARGE("wallet_freecharge", "wallet_freecharge"),
  MOBIKWIK("wallet_mobikwik", "wallet_mobikwik"),
  JIO("wallet_jio", "wallet_jio");

  private final String providerName;
  private final String paymentModeId;

  WalletProvider(String providerName, String paymentModeId) {
    this.providerName = providerName;
    this.paymentModeId = paymentModeId;
  }

  public static WalletProvider fromProviderName(String providerName) {
    for (WalletProvider provider : WalletProvider.values()) {
      if (provider.getProviderName().equalsIgnoreCase(providerName)) {
        return provider;
      }
    }
    throw new IllegalArgumentException("No enum constant with provider name " + providerName);
  }
}
