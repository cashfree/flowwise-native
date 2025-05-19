package com.cashfree.extensions.gateway.domains;

import lombok.Data;

@Data
public class RedirectionPayload {

  private Object data;
  private String url;
  private String type;
  private String method;
  private String encType;
}
