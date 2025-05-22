package com.cashfree.extensions.gateway.domains;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import lombok.Data;

@Data
public class CredsDTO {

  private String mid;

  @JsonProperty(value = "access_code")
  private String accessCode;

  @JsonProperty(value = "secret_key")
  private String secretKey;

  private String param1;

  private Map<String, Object> metadata;
}
