package com.cashfree.extensions.gateway.utils;

import com.cashfree.extensions.gateway.domains.gateway.PayCard;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CardUtil {

  public static final String CARD_NUMBER = "card_number";
  public static final String CARD_HOLDER = "card_holder_name";
  public static final String CARD_CVV = "card_cvv";
  public static final String CARD_EXPIRY_MONTH = "card_expiry_mm";
  public static final String CARD_EXPIRY_YEAR = "card_expiry_yy";
  public static final String CARD_SCHEME = "card_scheme";
  public static final String CARD_TYPE = "card_type";
  public static final String BANK_NAME = "bankName";
  public static final String PLAIN_CARD_DATA = "PLAIN_CARD";
  public static final String TOKENIZED_CARD_DATA = "TOKENIZED_CARD";
  public static final String TOKEN_CARD_ID = "tokenCardId";
  public static final String TOKEN_CRYPTOGRAM = "tokenCardCryptogram";
  public static final String TOKEN_CRYPTOGRAM_ISSUER = "tokenCardCryptogramIssuer";
  public static final String TOKEN_EXPIRY_MONTH = "tokenCardExpiryMonth";
  public static final String TOKEN_EXPIRY_YEAR = "tokenCardExpiryYear";
  public static final String ISSUER_BANK = "BANK";
  public static final String ISSUER_CRYPTOGRAM_ENABLED = "issuerCryptogramEnabled";
  public static final String CARD_DATA_TYPE = "cardDataType";
  private static final String CARD_SUFFIX = "cardSuffix";
  private static final String TOKEN_CARD_ISSUER_ID = "tokenCardIssuerId";
  public static final String TRUE = "true";
  private static final String IS_SAVE_CARD = "isSaveCard";
  public static final String ALT_ID_CARD = "ALT_ID_CARD";

  public static PayCard getCard(Map<String, Object> data) {
    if (null == data) {
      // throw exception
    }
    if (!data.containsKey(CARD_SCHEME)) {
      // throw exception
    }

    PayCard.PayCardBuilder payCardBuilder = PayCard.builder();
    if (data.containsKey(CARD_DATA_TYPE)
        && (TOKENIZED_CARD_DATA.equals(data.get(CARD_DATA_TYPE))
            || ALT_ID_CARD.equals(data.get(CARD_DATA_TYPE)))
        && data.containsKey(CARD_TYPE)
        && data.containsKey(TOKEN_CARD_ID)
        && data.containsKey(TOKEN_CRYPTOGRAM)
        && data.containsKey(TOKEN_EXPIRY_MONTH)
        && data.containsKey(TOKEN_EXPIRY_YEAR)) {

      // issuerCryptogramEnabled needs to be passed in the data map by the gateway if issuer
      // cryptogram processing is enabled
      if (ISSUER_BANK.equals(data.get(TOKEN_CRYPTOGRAM_ISSUER))
          && !TRUE.equals(data.get(ISSUER_CRYPTOGRAM_ENABLED))) {
        // throw exception
        //        throw new Exception(
        //            "PG is not configured for processing issuer cryptograms");
      }

      payCardBuilder
          .cardDataType(String.valueOf(data.get(CARD_DATA_TYPE)))
          .cardNumber(String.valueOf(data.get(TOKEN_CARD_ID)))
          .tokenCryptogram(String.valueOf(data.get(TOKEN_CRYPTOGRAM)))
          .tokenCryptogramIssuer(String.valueOf(data.get(TOKEN_CRYPTOGRAM_ISSUER)))
          .expiryMonth(String.valueOf(data.get(TOKEN_EXPIRY_MONTH)))
          .expiryYear(String.valueOf(data.get(TOKEN_EXPIRY_YEAR)))
          .cardSuffix(String.valueOf(data.get(CARD_SUFFIX)))
          .tokenCardIssuerId(String.valueOf(data.get(TOKEN_CARD_ISSUER_ID)))
          .cardCvv(String.valueOf(data.get(CARD_CVV)))
          .saveCard(false);
    } else if (data.containsKey(CARD_NUMBER)
        && data.containsKey(CARD_HOLDER)
        && data.containsKey(CARD_TYPE)
        && data.containsKey(CARD_EXPIRY_MONTH)
        && data.containsKey(CARD_EXPIRY_YEAR)) {
      payCardBuilder
          .cardDataType(PLAIN_CARD_DATA)
          .cardNumber(String.valueOf(data.get(CARD_NUMBER)))
          .cardHolder(String.valueOf(data.get(CARD_HOLDER)))
          .cardCvv(String.valueOf(data.getOrDefault(CARD_CVV, "")))
          .expiryMonth(String.valueOf(data.get(CARD_EXPIRY_MONTH)))
          .expiryYear(String.valueOf(data.get(CARD_EXPIRY_YEAR)))
          .saveCard(Boolean.parseBoolean(String.valueOf(data.getOrDefault(IS_SAVE_CARD, "false"))));
    } else {
      // throw exception
    }
    log.info("Card Data Type :: {}", data.get(CARD_DATA_TYPE));
    return payCardBuilder
        .cardType(String.valueOf(data.get(CARD_TYPE)))
        .cardScheme(String.valueOf(data.get(CARD_SCHEME)))
        .bankName(String.valueOf(data.getOrDefault(BANK_NAME, "")))
        .build();
  }

  public static boolean isTokenizedCard(PayCard payCard) {
    return TOKENIZED_CARD_DATA.equals(payCard.getCardDataType());
  }
}
