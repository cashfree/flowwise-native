package com.cashfree.extensions.gateway.domains;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class GatewayPaymentDetailsDTO {

  private String gatewayAuthId;

  private String gatewayPaymentId;

  private String gatewayOrderId;

  private String gatewayUtr;

  private String gatewayName;

  private String gatewayReferenceName;
}
