package com.cashfree.extensions.gateway.domains;

import lombok.Data;

@Data
public class CardInitiatePayResponse {
  String orderRef;
  CardResponseDTO responseBody;
}
