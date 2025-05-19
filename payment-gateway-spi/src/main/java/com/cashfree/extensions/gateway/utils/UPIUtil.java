package com.cashfree.extensions.gateway.utils;

import com.cashfree.extensions.gateway.constants.PayConstants;
import com.cashfree.extensions.gateway.constants.PayConstants.Currency;
import com.cashfree.extensions.gateway.domains.InitiatePayRequest;
import com.cashfree.extensions.gateway.domains.gateway.PayUPI;
import com.cashfree.extensions.gateway.domains.internal.UPIPayLink;
import com.cashfree.extensions.gateway.exceptions.InvalidPaymentModeException;
import com.google.common.collect.ImmutableMap;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
public class UPIUtil {

  static final String VPA = "vpa";
  static final String CHANNEL = "channel";
  static final String COLLECT = "collect";
  static final String EXPIRY = "expiry";
  static final String PAY_MODE = "pay_mode";
  static final String EXPIRE_ON = "expireOn";
  private static final String BANK_NAME = "bank";
  static final long DEFAULT_EXPIRY_VALUE = 5L;
  private static final String DEFAULT_REMARKS = "Cashfree Payments";

  public static final String LINK = "LINK";
  public static final String QR_CODE = "QRCODE";
  public static final String UPI_LINK_PREFIX = "upi://pay?";
  static final DateTimeFormatter dateTimeFormatter =
      DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
  public static final String LINK_CREATION_MESSAGE = "Pay link created";

  private static final String MERCHANT_CATEGORY_CODE = "mc";

  public static final String UPI_PAY_PURPOSE = "purpose";
  private static final String NAME = "Cashfree";
  private static final String DEFAULT_MODE = "DEFAULT_MODE";
  //  private static final Map<String, String> providerModeMap =
  //      Map.of(DEFAULT_MODE, "00", INTENT, "04", QR_CODE, "01");
  private static final String VPA_PARAM = "pa";
  private static final String NAME_PARAM = "pn";
  private static final String TXN_PARAM = "tr";
  private static final String CURRENCY_PARAM = "cu";
  private static final String AMOUNT_PARAM = "am";
  private static final String REMARKS_PARAM = "tn";
  private static final String DEFAULT_MCC = "5732";
  private static final String NULL_STRING = "null";

  public static PayUPI getUPI(Map<String, Object> data) {
    return PayUPI.builder()
        .userVPA(String.valueOf(data.get(VPA)))
        .payMode(String.valueOf(data.get(PAY_MODE)))
        .whitelistAccount(
            Optional.ofNullable(
                data.get(PayConstants.TPV_WHITELIST_ACC) != null
                    ? String.valueOf(data.get(PayConstants.TPV_WHITELIST_ACC))
                    : null))
        .whitelistIfsc(
            Optional.ofNullable(
                data.get(PayConstants.TPV_WHITELIST_IFSC) != null
                    ? String.valueOf(data.get(PayConstants.TPV_WHITELIST_IFSC))
                    : null))
        .mcc(
            Optional.ofNullable(
                data.get(MERCHANT_CATEGORY_CODE) != null
                    ? String.valueOf(data.get(MERCHANT_CATEGORY_CODE))
                    : null))
        .purpose(
            Optional.ofNullable(
                data.get(UPI_PAY_PURPOSE) != null
                    ? String.valueOf(data.get(UPI_PAY_PURPOSE))
                    : null))
        .build();
  }

  public static PayConstants.PayUPIType getPayUPIType(Map<String, Object> payData) {
    if (COLLECT.equals(String.valueOf(payData.get(CHANNEL)))) {
      return PayConstants.PayUPIType.COLLECT;
    }
    return PayConstants.PayUPIType.INTENT;
  }

  public static final ImmutableMap<String, String> providerPrefixMap =
      ImmutableMap.<String, String>builder()
          .put(LINK, UPI_LINK_PREFIX)
          .put(QR_CODE, UPI_LINK_PREFIX)
          .build();

  public static String createUpiPayLink(
      InitiatePayRequest initiatePayRequest,
      String transactionId,
      String merchantVpa,
      Optional<String> mccOptional) {

    String upiProvider = String.valueOf(initiatePayRequest.getData().get(CHANNEL)).toUpperCase();
    String merchantOrderNote = initiatePayRequest.getMerchantOrderNote();
    UPIPayLink upiPayLink;
    switch (upiProvider) {
      case LINK:
      case QR_CODE:
        upiPayLink =
            UPIPayLink.builder()
                .upiProvider(upiProvider)
                .merchantVpa(merchantVpa)
                .transactionId(transactionId)
                .amount(initiatePayRequest.getAmount())
                .remarks(getRemarks(merchantOrderNote, initiatePayRequest.getMerchantOrderId()))
                .mcc(mccOptional)
                .merchantName(CommonUtil.getMerchantName(initiatePayRequest.getData(), 50))
                .build();
        return createPayLink(upiPayLink);
      default:
        throw new InvalidPaymentModeException(
            "Invalid type:" + initiatePayRequest.getData().get(CHANNEL));
    }
  }

  public static String createPayLink(UPIPayLink upiPayLink) {

    String linkPrefix =
        providerPrefixMap.getOrDefault(upiPayLink.getUpiProvider().toUpperCase(), UPI_LINK_PREFIX);

    String merchantName = upiPayLink.getMerchantName();
    if (StringUtils.isBlank(merchantName)) {
      merchantName = NAME;
    }

    return UriComponentsBuilder.fromUriString(linkPrefix)
        .queryParam(VPA_PARAM, upiPayLink.getMerchantVpa())
        .queryParam(NAME_PARAM, merchantName)
        .queryParam(TXN_PARAM, upiPayLink.getTransactionId())
        .queryParam(AMOUNT_PARAM, String.valueOf(upiPayLink.getAmount()))
        .queryParam(CURRENCY_PARAM, Currency.INR)
        .queryParam(MERCHANT_CATEGORY_CODE, validateAndDefaultMcc(upiPayLink.getMcc()))
        .queryParam(
            REMARKS_PARAM, getRemarks(upiPayLink.getRemarks(), upiPayLink.getTransactionId()))
        .build()
        .encode()
        .toUriString();
  }

  public static String getRemarks(String expectedRemarks, String merchantOrderId) {
    String remarks = expectedRemarks;
    if (StringUtils.isBlank(remarks) || remarks.equalsIgnoreCase(NULL_STRING)) {
      remarks = merchantOrderId;
    }
    return sanitizeRemarks(remarks);
  }

  public static String validateAndDefaultMcc(Optional<String> mccOptional) {
    if (!mccOptional.isPresent() || mccOptional.get().length() != 4) {
      return DEFAULT_MCC;
    } else {
      return mccOptional.get();
    }
  }

  public static String sanitizeRemarks(String remarks) {
    if (StringUtils.isBlank(remarks)) {
      return DEFAULT_REMARKS;
    }
    remarks = remarks.replaceAll("[^a-zA-Z0-9\\s]", "");
    if (StringUtils.isBlank(remarks)) {
      return DEFAULT_REMARKS;
    }
    if (remarks.length() > 20) {
      return remarks.substring(0, 20);
    }
    return remarks;
  }

  //  public static String getOrDefaultMode(String upiProvider) {
  //    if (providerModeMap.containsKey(upiProvider)) {
  //      return providerModeMap.get(upiProvider);
  //    }
  //    return providerModeMap.get(DEFAULT_MODE);
  //  }
}
