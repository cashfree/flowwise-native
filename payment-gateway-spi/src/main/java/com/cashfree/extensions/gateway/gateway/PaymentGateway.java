package com.cashfree.extensions.gateway.gateway;

import com.cashfree.extensions.commonlib.domain.extension.ConfigAttribute;
import com.cashfree.extensions.gateway.domains.AuthorizePayRequest;
import com.cashfree.extensions.gateway.domains.CardInitiatePayResponse;
import com.cashfree.extensions.gateway.domains.InitiatePayRequest;
import com.cashfree.extensions.gateway.domains.InitiatePayResponse;
import com.cashfree.extensions.gateway.domains.PaymentDetailsDTO;
import com.cashfree.extensions.gateway.domains.PaymentRefundDetailsDTO;
import com.cashfree.extensions.gateway.domains.PaymentRefundResponse;
import com.cashfree.extensions.gateway.domains.PaymentStatusResponse;
import com.cashfree.extensions.gateway.domains.RouteConfigResponse;
import com.cashfree.extensions.gateway.domains.VerifyOTPRequest;
import com.cashfree.extensions.gateway.domains.settlement.SettlementDetailRequest;
import com.cashfree.extensions.gateway.domains.settlement.SettlementDetailsResponse;
import java.util.List;
import java.util.Map;

public interface PaymentGateway {

  String getProcessor();

  default List<ConfigAttribute> getDefaultExtensionAttributes() {
    return List.of();
  }

  default boolean isGatewayCustomImplemented() {
    return false;
  }

  InitiatePayResponse initiateGatewayPay(
      InitiatePayRequest initiatePayRequest, RouteConfigResponse routeConfigResponse);

  CardInitiatePayResponse initiateCardGatewayRequest(
      InitiatePayRequest initiatePayRequest, RouteConfigResponse routeConfigResponse);

  PaymentStatusResponse fetchPaymentStatus(
      PaymentDetailsDTO paymentDetailsDTO, RouteConfigResponse routeConfigResponse);

  PaymentRefundResponse refundPayment(
      PaymentRefundDetailsDTO paymentRefundDetails, RouteConfigResponse routeConfigResponse);

  PaymentRefundResponse reconRefundPayment(
      PaymentRefundDetailsDTO paymentRefundDetails, RouteConfigResponse routeConfigResponse);

  PaymentStatusResponse verifyOTP(
      VerifyOTPRequest verifyOTPRequest, RouteConfigResponse routeConfigResponse);

  String processorFromWebhook(Map<String, Object> gatewayWebhook);

  String obtainProcessorRef(Map<String, Object> gatewayWebhook);

  SettlementDetailsResponse getSettlementData(
      SettlementDetailRequest settlementDetailRequest, RouteConfigResponse routeConfig);

  PaymentStatusResponse authorizePayment(
      AuthorizePayRequest authorizePayRequest, RouteConfigResponse routeConfigResponse);

  List<String> getSupportedPaymentModes(String currencyCode);
}
