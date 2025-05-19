package com.cashfree.extensions.gateway.utils;

import static com.cashfree.extensions.gateway.constants.CommonConstants.EMPTY_STRING;

import com.cashfree.extensions.gateway.constants.PayConstants;
import com.cashfree.extensions.gateway.domains.gateway.PayNB;
import java.util.Map;
import java.util.Optional;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@NoArgsConstructor
public class NetBankingUtil {

  public static final String BANK_CODE = "netbanking_bank_code";
  public static final String BANK_NAME = "netbanking_bank_name";

  public static PayNB getPGNB(Map<String, Object> data) {
    if (null != data && data.containsKey(BANK_CODE)) {
      return PayNB.builder()
          .bankId(String.valueOf(data.get(BANK_CODE)))
          .whitelistAccount(
              Optional.ofNullable(String.valueOf(data.get(PayConstants.TPV_WHITELIST_ACC))))
          .whitelistIfsc(
              Optional.ofNullable(String.valueOf(data.get(PayConstants.TPV_WHITELIST_IFSC))))
          .bankName(String.valueOf(data.getOrDefault(BANK_NAME, EMPTY_STRING)))
          .build();
    } else {
      // throw exception
      return null;
    }
  }
}
