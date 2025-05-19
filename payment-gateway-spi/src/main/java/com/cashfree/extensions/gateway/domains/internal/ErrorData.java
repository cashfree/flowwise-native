package com.cashfree.extensions.gateway.domains.internal;

import static com.cashfree.extensions.gateway.constants.CommonConstants.COLON_WITH_SPACE;
import static com.cashfree.extensions.gateway.constants.CommonConstants.UNDERSCORE;

import com.cashfree.extensions.gateway.constants.error.ErrorCode;
import com.cashfree.extensions.gateway.constants.error.ErrorMessage;
import com.cashfree.extensions.gateway.constants.error.ErrorType;
import com.cashfree.extensions.gateway.utils.CommonUtil;
import java.io.Serializable;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@Builder
@ToString
public class ErrorData implements Serializable {

  @NonNull private String message;

  @NonNull private String code;

  @NonNull private ErrorType type;

  public static ErrorData buildFromUnsupportedField(String field) {
    field = CommonUtil.camelToSnakeCase(field);
    return ErrorData.builder()
        .type(ErrorType.VALIDATION_ERROR)
        .code(field, ErrorCode.UNSUPPORTED)
        .message(field + ErrorMessage.UNSUPPORTED_OPERATION)
        .build();
  }

  public static ErrorData buildFromInvalidField(String field) {
    field = CommonUtil.camelToSnakeCase(field);
    return ErrorData.builder()
        .type(ErrorType.VALIDATION_ERROR)
        .code(field, ErrorCode.VALUE_INVALID)
        .message(field + COLON_WITH_SPACE + ErrorMessage.INVALID_VALUE)
        .build();
  }

  public static ErrorData buildFromMissingField(String field) {
    field = CommonUtil.camelToSnakeCase(field);
    return ErrorData.builder()
        .type(ErrorType.VALIDATION_ERROR)
        .code(field, ErrorCode.MISSING)
        .message(field + COLON_WITH_SPACE + ErrorMessage.PARAMETER_MISSING)
        .build();
  }

  public static class ErrorDataBuilder {

    public ErrorDataBuilder code(String prefix, ErrorCode code) {
      this.code = prefix + UNDERSCORE + code.getDescription();
      return this;
    }

    public ErrorDataBuilder code(ErrorCode code) {
      this.code = code.getDescription();
      return this;
    }
  }
}
