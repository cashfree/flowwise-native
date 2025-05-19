package com.cashfree.extensions.gateway.domains;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GatewayRefundDetailsDTO {

  @JsonProperty(value = "refund_reference_id")
  private String refundRefId;

  @JsonProperty(value = "refund_utr")
  private String refundUtr;
}
