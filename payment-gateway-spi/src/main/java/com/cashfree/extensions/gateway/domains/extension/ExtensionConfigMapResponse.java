package com.cashfree.extensions.gateway.domains.extension;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import lombok.Data;

@Data
public class ExtensionConfigMapResponse {
  private String extension;

  @JsonProperty(value = "attributes_to_values_map")
  private Map<String, ExtensionAttributeValueDTO> attributesToValuesMap;

  private Environment environment;

  private String status;
}
