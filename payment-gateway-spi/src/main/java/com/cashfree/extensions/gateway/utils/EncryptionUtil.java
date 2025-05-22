package com.cashfree.extensions.gateway.utils;

import com.cashfree.extensions.gateway.exceptions.EncryptionException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;
import java.util.Objects;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;

@Slf4j
public class EncryptionUtil {

  private EncryptionUtil() {}

  private static final String AES_GCM_NO_PADDING = "AES/GCM/NoPadding";
  private static final String AES_ALGORITHM = "AES";
  private static final int GCM_IV_LENGTH = 12;

  public static String encryptUrl(String plaintext, String associatedData, String key) {
    if (plaintext == null || plaintext.isBlank()) {
      return plaintext;
    }

    SecretKey secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), AES_ALGORITHM);
    SecureRandom secureRandom = new SecureRandom();
    byte[] iv = new byte[GCM_IV_LENGTH]; // NEVER REUSE THIS IV WITH SAME KEY
    secureRandom.nextBytes(iv);

    try {
      final Cipher cipher = Cipher.getInstance(AES_GCM_NO_PADDING);
      GCMParameterSpec parameterSpec = new GCMParameterSpec(128, iv); // 128 bit auth tag length
      cipher.init(Cipher.ENCRYPT_MODE, secretKey, parameterSpec);

      if (associatedData != null) {
        cipher.updateAAD(associatedData.getBytes(StandardCharsets.UTF_8));
      }

      byte[] cipherText = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));

      ByteBuffer byteBuffer = ByteBuffer.allocate(iv.length + cipherText.length);
      byteBuffer.put(iv);
      byteBuffer.put(cipherText);
      return Base64.getEncoder().encodeToString(byteBuffer.array());
    } catch (Exception e) {
      log.error("Exception occurred while encryption.", e);
      throw new EncryptionException("Unable to encrypt.");
    }
  }

  public static String decryptUrl(String cipherString, String associatedData, String key) {
    if (Objects.isNull(cipherString) || cipherString.isBlank()) {
      return cipherString;
    }

    byte[] cipherMessage = Base64.getDecoder().decode(cipherString);
    SecretKey secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), AES_ALGORITHM);

    try {
      final Cipher cipher = Cipher.getInstance(AES_GCM_NO_PADDING);
      // use first 12 bytes for iv
      AlgorithmParameterSpec gcmIv = new GCMParameterSpec(128, cipherMessage, 0, GCM_IV_LENGTH);
      cipher.init(Cipher.DECRYPT_MODE, secretKey, gcmIv);

      if (associatedData != null) {
        cipher.updateAAD(associatedData.getBytes(StandardCharsets.UTF_8));
      }
      byte[] plainText =
          cipher.doFinal(cipherMessage, GCM_IV_LENGTH, cipherMessage.length - GCM_IV_LENGTH);

      return new String(plainText, StandardCharsets.UTF_8);
    } catch (Exception e) {
      log.error("Exception occurred while decryption.", e);
      throw new EncryptionException("Unable to decrypt.");
    }
  }

  // Method to encrypt a string
  public static String encryptUrl(String data, String secretKey) {
    try {
      SecretKeySpec key = new SecretKeySpec(secretKey.getBytes(), AES_ALGORITHM);
      Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
      cipher.init(Cipher.ENCRYPT_MODE, key);
      byte[] encryptedBytes = cipher.doFinal(data.getBytes());
      return Base64.getUrlEncoder().encodeToString(encryptedBytes);
    } catch (Exception e) {
      log.error("Exception occurred while encryption.", e);
      throw new EncryptionException("Unable to encrypt.");
    }
  }

  // Method to decrypt a string
  public static String decryptUrl(String encryptedData, String secretKey) {
    try {
      SecretKeySpec key = new SecretKeySpec(secretKey.getBytes(), AES_ALGORITHM);
      Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
      cipher.init(Cipher.DECRYPT_MODE, key);
      byte[] decodedBytes = Base64.getUrlDecoder().decode(encryptedData);
      byte[] decryptedBytes = cipher.doFinal(decodedBytes);
      return new String(decryptedBytes);
    } catch (Exception e) {
      log.error("Exception occurred while decryption.", e);
      throw new EncryptionException("Unable to decrypt.");
    }
  }

  public static String generateRandomSecret(int length, String prefix) {
    SecureRandom secureRandom = new SecureRandom();

    byte[] secretBytes = new byte[length];
    secureRandom.nextBytes(secretBytes);

    String secret = Base64.getUrlEncoder().withoutPadding().encodeToString(secretBytes);
    if (Strings.isBlank(prefix)) {
      return secret;
    }
    return prefix + Base64.getUrlEncoder().withoutPadding().encodeToString(secretBytes);
  }
}
