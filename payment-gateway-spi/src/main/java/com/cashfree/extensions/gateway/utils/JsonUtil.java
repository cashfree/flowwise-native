package com.cashfree.extensions.gateway.utils;

import com.cashfree.extensions.gateway.exceptions.JsonConversionException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.util.Map;
import java.util.Objects;

public class JsonUtil {

  private static final ObjectMapper objectMapper = new ObjectMapper();
  private static final ObjectMapper defaultObjectMapperWithDate =
      new ObjectMapper()
          .registerModule(new JavaTimeModule())
          .enable(SerializationFeature.INDENT_OUTPUT);

  public static String toJson(Object object) {
    try {
      return objectMapper.writeValueAsString(object);
    } catch (JsonProcessingException e) {
      throw new JsonConversionException("Failed to convert object to JSON", e);
    }
  }

  public static String toJsonUsingDateMapper(Object object) {
    try {
      return defaultObjectMapperWithDate.writeValueAsString(object);
    } catch (JsonProcessingException e) {
      throw new JsonConversionException("Failed to convert object to JSON", e);
    }
  }

  public static <T> T fromJson(String json, Class<T> clazz) {
    try {
      return objectMapper.readValue(json, clazz);
    } catch (JsonProcessingException e) {
      throw new JsonConversionException("Failed to convert JSON to object", e);
    }
  }

  public static String prettyPrint(Object obj, boolean throwException) {
    try {
      return defaultObjectMapperWithDate.writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      if (throwException) {
        throw new JsonConversionException("Unable to deserialize", e);
      }
      return "Error is deserializing";
    }
  }

  public static Map<String, Object> convertToMap(Object source) {
    if (Objects.isNull(source)) {
      return null;
    }
    try {
      return objectMapper.convertValue(source, new TypeReference<>() {});
    } catch (Exception e) {
      throw new JsonConversionException("Failed to convert to Map", e);
    }
  }

  public static <T> T deserialize(Object json, Class<T> clazz) {
    try {
      return objectMapper.convertValue(json, clazz);
    } catch (Exception e) {
      throw new JsonConversionException("Failed to deserialize", e);
    }
  }
}
