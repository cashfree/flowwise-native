package com.cashfree.extensions.gateway.utils;

import static java.math.BigDecimal.TEN;

import com.cashfree.extensions.gateway.constants.CommonConstants;
import com.cashfree.extensions.gateway.constants.PayConstants;
import com.cashfree.extensions.gateway.constants.PayConstants.PaymentMode;
import com.cashfree.extensions.gateway.domains.InitiatePayRequest;
import com.cashfree.extensions.gateway.domains.internal.PGError;
import com.cashfree.extensions.gateway.exceptions.InvalidPaymentModeException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.util.CollectionUtils;

@Slf4j
public class CommonUtil {

  protected static final BigDecimal INR_MULTIPLY_FACTOR = new BigDecimal(100);
  private static final String IP_ADDRESS = "ip_address";
  private static final String DEFAULT_IPADDRESS = "";
  public static final String DEFAULT_MERCHANT_NAME = "Cashfree Payments";

  private static final String MERCHANT_NAME = "merchant_name";
  private static final String CARD_METHOD = "card";
  private static final String BANK_ACCOUNT = "bank_account";
  private static final String NET_BANKING_METHOD = "netbanking";
  private static final String UPI_METHOD = "upi";
  private static final String WALLET_METHOD = "wallet";

  public static final Map<String, PaymentMode> eligiblePaymentModeMap =
      Map.of(
          "upi",
          PaymentMode.UPI,
          "netbanking",
          PaymentMode.NET_BANKING,
          "card",
          PaymentMode.CARD,
          "wallet",
          PaymentMode.WALLET);

  public static final Map<String, PayConstants.PayUPIType> eligibleUpiChannel =
      Map.of(
          "collect",
          PayConstants.PayUPIType.COLLECT,
          "intent",
          PayConstants.PayUPIType.INTENT,
          "qrcode",
          PayConstants.PayUPIType.QR_CODE);

  public static BigDecimal convertAmountToSubUnit(
      BigDecimal amount, PayConstants.Currency currency) {
    return amount.multiply(getCurrencyMultiplier(currency)).setScale(0, RoundingMode.FLOOR);
  }

  public static String cleanPhone(String phoneNumber) {
    if (phoneNumber == null || phoneNumber.isBlank()) {
      return "";
    }
    phoneNumber = phoneNumber.replace("+91", "");
    phoneNumber = StringUtils.stripStart(phoneNumber, "0");
    return phoneNumber;
  }

  public static BigDecimal getCurrencyMultiplier(PayConstants.Currency cfCurrency) {
    BigDecimal multiplier = INR_MULTIPLY_FACTOR;
    java.util.Currency currency = java.util.Currency.getInstance(cfCurrency.name());
    if (currency.getDefaultFractionDigits() != 2) {
      multiplier = TEN.pow(currency.getDefaultFractionDigits());
    }
    return multiplier;
  }

  public static BigDecimal convertAmountFromSubUnit(
      BigDecimal amount, PayConstants.Currency cfCurrency) {
    java.util.Currency currency = java.util.Currency.getInstance(cfCurrency.name());
    return amount
        .divide(getCurrencyMultiplier(cfCurrency))
        .setScale(currency.getDefaultFractionDigits(), RoundingMode.FLOOR);
  }

  public static PaymentMode getPaymentModeEnum(String mode) {
    PaymentMode modeEnum;
    try {
      if (mode.equalsIgnoreCase("netbanking")) {
        modeEnum = PaymentMode.NET_BANKING;
      } else {
        modeEnum = PaymentMode.valueOf(mode.toUpperCase());
      }
    } catch (IllegalArgumentException exception) {
      modeEnum = PaymentMode.WALLET;
    }
    return modeEnum;
  }

  public static boolean isMetadataURL(String metadata) {
    return Objects.nonNull(metadata) && metadata.startsWith("http");
  }

  public static boolean checkForMandatoryFields(Map responseMap, Set<String> mandatoryFields) {
    boolean isContains =
        mandatoryFields.stream()
            .allMatch(
                key ->
                    responseMap.containsKey(key)
                        && StringUtils.isNotBlank(String.valueOf(responseMap.get(key))));
    if (!isContains) {
      log.error(
          "Error Log :: Mandatory Fields missing :: Data {} :: Fields {} ",
          responseMap,
          mandatoryFields);
    }
    return isContains;
  }

  public static String camelToSnakeCase(String str) {
    StringBuilder sb = new StringBuilder();
    if (!org.springframework.util.StringUtils.hasText(str)) {
      return sb.toString();
    }
    sb.append(Character.toLowerCase(str.charAt(0)));
    for (int i = 1; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (Character.isUpperCase(ch)) {
        sb.append(CommonConstants.UNDERSCORE);
        sb.append(Character.toLowerCase(ch));
      } else {
        sb.append(ch);
      }
    }
    return sb.toString();
  }

  public static String getFirstName(String customerName) {
    String name = StringUtils.isBlank(customerName) ? "CASHFREE" : customerName;
    name = name.trim();
    int index = name.indexOf(' ');
    String firstName = name;
    if (index != -1) {
      firstName = name.substring(0, index);
    }
    return firstName.replaceAll("[^a-zA-Z0-9]", "");
  }

  public static String getLastName(String customerName) {
    String name = StringUtils.isBlank(customerName) ? "CF" : customerName;
    name = name.trim();
    int index = name.indexOf(' ');
    String lastName;
    if (index == -1) {
      lastName = "Payments";
    } else {
      lastName = name.substring(index + 1);
    }
    return lastName.replaceAll("[^a-zA-Z0-9]", "");
  }

  public static String getIpAddress(Map<String, Object> data) {

    if (!CollectionUtils.isEmpty(data)
        && data.containsKey(IP_ADDRESS)
        && StringUtils.isNotBlank(String.valueOf(data.get(IP_ADDRESS)))) {
      return String.valueOf(data.get(IP_ADDRESS));
    }
    return DEFAULT_IPADDRESS;
  }

  public static String getMerchantName(Map<String, Object> payData, Integer maxLength) {
    String merchantName = DEFAULT_MERCHANT_NAME;
    if (!CollectionUtils.isEmpty(payData)
        && StringUtils.isNotBlank(String.valueOf(payData.get(MERCHANT_NAME)))) {
      merchantName =
          StringUtils.truncate(
              String.valueOf(payData.get(MERCHANT_NAME)).replaceAll("[^a-zA-Z0-9\\s]", ""),
              maxLength);
    }
    return StringUtils.isNotBlank(merchantName) ? merchantName : DEFAULT_MERCHANT_NAME;
  }

  public static String getPaymentMethod(InitiatePayRequest initiatePayRequest) {
    String mode = initiatePayRequest.getMode();
    PaymentMode paymentMode = CommonUtil.eligiblePaymentModeMap.get(mode);
    switch (paymentMode) {
      case CREDIT_CARD:
      case DEBIT_CARD:
      case PREPAID_CARD:
      case CORPORATE_CREDIT_CARD:
      case CARD:
        return CARD_METHOD;
      case NET_BANKING:
        return NET_BANKING_METHOD;
      case UPI:
        return UPI_METHOD;
      case WALLET:
        return WALLET_METHOD;
      default:
        throw new InvalidPaymentModeException("Invalid Payment Mode " + paymentMode);
    }
  }

  public static BigDecimal convertAmountToRupee(BigDecimal amount) {
    BigDecimal rupee = amount.divide(new BigDecimal(100));
    return rupee;
  }

  public static BigDecimal convertAmountToPaise(BigDecimal amount) {
    BigDecimal paise = amount.multiply(INR_MULTIPLY_FACTOR).setScale(0, RoundingMode.FLOOR);
    log.info("convertAmountToPaise :: amount {} :: paise  {}", amount, paise);
    return paise;
  }

  public static LocalDateTime convertUnixTimestampToISTLocalDateTime(String unixTimestamp) {
    Instant instant = Instant.ofEpochSecond(Long.parseLong(unixTimestamp));
    return LocalDateTime.ofInstant(instant, ZoneId.of("Asia/Kolkata"));
  }

  public static long convertLocalDateTimeToUnixTimestamp(LocalDateTime localDateTime) {
    ZoneId zoneId = ZoneId.of("Asia/Kolkata");
    Instant instant = localDateTime.atZone(zoneId).toInstant();
    return instant.getEpochSecond();
  }

  public static PGError getRetryablePGError(PGError pgError) {
    if (pgError == null) {
      return PGError.builder().retryOnFailure(true).build();
    }
    return PGError.builder()
        .pgErrorCode(pgError.getPgErrorCode())
        .pgErrorDescription(pgError.getPgErrorDescription())
        .retryOnFailure(true)
        .build();
  }

  public static <T> BigDecimal getNumericOrDefaultValue(T val) {
    if (val == null) {
      return BigDecimal.ZERO;
    }

    String value = String.valueOf(val);
    return NumberUtils.isParsable(value) ? new BigDecimal(value) : BigDecimal.ZERO;
  }

  // TODO: revisit this
  public static String decodeUnicodeEscapes(String input) {
    Pattern unicodePattern = Pattern.compile("\\\\u([0-9a-fA-F]{4})");
    Matcher matcher = unicodePattern.matcher(input);
    StringBuffer sb = new StringBuffer();

    while (matcher.find()) {
      String code = matcher.group(1);
      char unicodeChar = (char) Integer.parseInt(code, 16);
      matcher.appendReplacement(sb, Character.toString(unicodeChar));
    }

    matcher.appendTail(sb);
    return sb.toString();
  }
}
