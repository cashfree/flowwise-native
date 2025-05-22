package com.cashfree.extensions.gateway.constants.error;

import com.cashfree.extensions.gateway.domains.internal.PGError;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;

public class ErrorCodeConstant {
  private static final String BAD_REQUEST_CODE = "CN400";
  public static final PGError BAD_REQUEST_ERROR =
      PGError.builder()
          .pgErrorCode(BAD_REQUEST_CODE)
          .pgErrorDescription(HttpStatus.BAD_REQUEST.getReasonPhrase())
          .build();
  private static final String NOT_FOUND_CODE = "CN404";
  public static final PGError NOT_FOUND_ERROR =
      PGError.builder()
          .pgErrorCode(NOT_FOUND_CODE)
          .pgErrorDescription(HttpStatus.NOT_FOUND.getReasonPhrase())
          .build();
  private static final String SERVICE_FORBIDDEN_CODE = "CN403";
  public static final PGError SERVICE_FORBIDDEN_ERROR =
      PGError.builder()
          .pgErrorCode(SERVICE_FORBIDDEN_CODE)
          .pgErrorDescription("Service forbidden")
          .build();
  private static final String BAD_GATEWAY_CODE = "CN502";
  public static final PGError BAD_GATEWAY =
      PGError.builder()
          .pgErrorCode(BAD_GATEWAY_CODE)
          .pgErrorDescription(HttpStatus.BAD_GATEWAY.getReasonPhrase())
          .build();
  private static final String SERVICE_UNAVAILABLE_CODE = "CN503";
  public static final PGError SERVICE_UNAVAILABLE_ERROR =
      PGError.builder()
          .pgErrorCode(SERVICE_UNAVAILABLE_CODE)
          .pgErrorDescription("Service not available")
          .build();
  private static final String UNAUTHORIZED_ERROR_CODE = "CN401";
  public static final PGError UNAUTHORIZED_ERROR =
      PGError.builder()
          .pgErrorCode(UNAUTHORIZED_ERROR_CODE)
          .pgErrorDescription(HttpStatus.UNAUTHORIZED.getReasonPhrase())
          .build();
  public static final String METHOD_NOT_ALLOWED_CODE = "CN405";
  public static final PGError METHOD_NOT_ALLOWED_ERROR =
      PGError.builder()
          .pgErrorCode(METHOD_NOT_ALLOWED_CODE)
          .pgErrorDescription(HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase())
          .build();
  public static final String REQUEST_TIMEOUT_CODE = "CN408";
  public static final PGError REQUEST_TIMEOUT_ERROR =
      PGError.builder()
          .pgErrorCode(REQUEST_TIMEOUT_CODE)
          .pgErrorDescription(HttpStatus.REQUEST_TIMEOUT.getReasonPhrase())
          .build();
  public static final String CONFLICT_CODE = "CN409";
  public static final PGError CONFLICT_ERROR =
      PGError.builder()
          .pgErrorCode(CONFLICT_CODE)
          .pgErrorDescription(HttpStatus.CONFLICT.getReasonPhrase())
          .build();
  public static final String CONTENT_TOO_LARGE_CODE = "CN413";
  public static final PGError CONTENT_TOO_LARGE_ERROR =
      PGError.builder()
          .pgErrorCode(CONTENT_TOO_LARGE_CODE)
          .pgErrorDescription(HttpStatus.URI_TOO_LONG.getReasonPhrase())
          .build();
  public static final String Unsupported_Media_CODE = "CN415";
  public static final PGError Unsupported_Media_Type_ERROR =
      PGError.builder()
          .pgErrorCode(Unsupported_Media_CODE)
          .pgErrorDescription(HttpStatus.UNSUPPORTED_MEDIA_TYPE.getReasonPhrase())
          .build();
  public static final String UNPROCESSABLE_ENTITY_CODE = "CN422";
  public static final PGError UNPROCESSABLE_ENTITY_ERROR =
      PGError.builder()
          .pgErrorCode(UNPROCESSABLE_ENTITY_CODE)
          .pgErrorDescription(HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase())
          .build();
  public static final String TOO_MANY_REQUESTS_CODE = "CN429";
  public static final PGError TOO_MANY_REQUESTS_ERROR =
      PGError.builder()
          .pgErrorCode(TOO_MANY_REQUESTS_CODE)
          .pgErrorDescription(HttpStatus.TOO_MANY_REQUESTS.getReasonPhrase())
          .build();
  public static final String INTERNAL_SERVER_CODE = "CN500";
  public static final PGError INTERNAL_SERVER_ERROR =
      PGError.builder()
          .pgErrorCode(INTERNAL_SERVER_CODE)
          .pgErrorDescription(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
          .build();
  public static final String GATEWAY_TIMEOUT_CODE = "CN504";
  public static final PGError GATEWAY_TIMEOUT_ERROR =
      PGError.builder()
          .pgErrorCode(GATEWAY_TIMEOUT_CODE)
          .pgErrorDescription(HttpStatus.GATEWAY_TIMEOUT.getReasonPhrase())
          .build();
  private static final String PG_INVALID_RESPONSE_CODE = "CN21";
  public static final PGError PG_INVALID_RESPONSE_ERROR =
      PGError.builder()
          .pgErrorCode(PG_INVALID_RESPONSE_CODE)
          .pgErrorDescription("Invalid PG response")
          .build();
  public static final Map<Integer, PGError> httpCodeCFCodeMap;

  static {
    httpCodeCFCodeMap = new HashMap<Integer, PGError>();
    httpCodeCFCodeMap.put(400, BAD_REQUEST_ERROR);
    httpCodeCFCodeMap.put(401, UNAUTHORIZED_ERROR);
    httpCodeCFCodeMap.put(403, SERVICE_FORBIDDEN_ERROR);
    httpCodeCFCodeMap.put(404, NOT_FOUND_ERROR);
    httpCodeCFCodeMap.put(405, METHOD_NOT_ALLOWED_ERROR);
    httpCodeCFCodeMap.put(408, REQUEST_TIMEOUT_ERROR);
    httpCodeCFCodeMap.put(409, CONFLICT_ERROR);
    httpCodeCFCodeMap.put(413, CONTENT_TOO_LARGE_ERROR);
    httpCodeCFCodeMap.put(415, Unsupported_Media_Type_ERROR);
    httpCodeCFCodeMap.put(422, UNPROCESSABLE_ENTITY_ERROR);
    httpCodeCFCodeMap.put(429, TOO_MANY_REQUESTS_ERROR);
    httpCodeCFCodeMap.put(500, INTERNAL_SERVER_ERROR);
    httpCodeCFCodeMap.put(502, BAD_GATEWAY);
    httpCodeCFCodeMap.put(503, SERVICE_UNAVAILABLE_ERROR);
    httpCodeCFCodeMap.put(504, GATEWAY_TIMEOUT_ERROR);
  }
}
