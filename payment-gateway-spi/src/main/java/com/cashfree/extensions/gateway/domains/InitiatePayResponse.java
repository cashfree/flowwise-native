package com.cashfree.extensions.gateway.domains;

import lombok.Data;

@Data
public class InitiatePayResponse {
  String processorRef;
  RedirectionType redirectionType;
  RedirectionPayload redirectionPayload;
  String metadata;
  String orderRef;
  String payload;
}
