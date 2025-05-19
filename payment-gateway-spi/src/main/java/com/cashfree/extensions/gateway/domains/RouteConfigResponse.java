package com.cashfree.extensions.gateway.domains;

import lombok.Data;

@Data
public class RouteConfigResponse {

  private String processor;

  private CredsDTO creds;

  private String environment;

  private Long configId;
}
