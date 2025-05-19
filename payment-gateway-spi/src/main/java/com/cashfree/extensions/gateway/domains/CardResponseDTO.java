package com.cashfree.extensions.gateway.domains;

import lombok.Data;

@Data
public class CardResponseDTO {
  private String type;
  private String method;
  private String action;
  private Object headers;
  private String body;
  private String pathParams;
  private String queryParams;
  private DirectiveDTO directive;
}
