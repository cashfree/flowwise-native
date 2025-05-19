package com.cashfree.extensions.gateway.utils;

import com.cashfree.extensions.gateway.constants.ExceptionConstants;
import com.cashfree.extensions.gateway.domains.internal.PGError;
import com.cashfree.extensions.gateway.exceptions.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RouterUtil {
  public static final String ROUTER_GATEWAY_PREFIX = "pa_";
  public static final String ROUTER_GATEWAY_SUFFIX = "pg";

  public enum ApiCallType {
    CREATE_UPI_TXN,
    CREATE_NON_UPI_TXN,
    REFUND_TXN,
    RECON_REFUND
  }

  public static CFGatewayException fetchException(ApiCallType apiCall, PGError pgError) {
    return switch (apiCall) {
      case CREATE_UPI_TXN, CREATE_NON_UPI_TXN -> new PayInitiateException(
          ExceptionConstants.PG_INVALID_RESPONSE, pgError);
      case REFUND_TXN -> new RefundPGInvalidResponseException(
          ExceptionConstants.PG_INVALID_RESPONSE, pgError);
      case RECON_REFUND -> new ReconRefundPGInvalidResponseException(
          ExceptionConstants.PG_INVALID_RESPONSE, pgError);
      default -> {
        log.error("API Error Not Mapped: {}", apiCall);
        yield new CFGatewayException(ExceptionConstants.PG_INVALID_RESPONSE, pgError);
      }
    };
  }
}
