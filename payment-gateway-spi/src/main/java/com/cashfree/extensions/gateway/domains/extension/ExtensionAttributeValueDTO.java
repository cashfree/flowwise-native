package com.cashfree.extensions.gateway.domains.extension;

import com.cashfree.extensions.gateway.domains.enums.ExtensionConfigAttributesStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@Data
public class ExtensionAttributeValueDTO {

  private String name;

  @JsonProperty("storage_type")
  private ConfigAttributeStorageType storageType;

  @JsonProperty("ui_type")
  private ConfigAttributeUIType uiType;

  @JsonProperty("display_text")
  private String displayText;

  private String description;

  private String value;

  private ExtensionConfigAttributesStatus status;

  private List<DropdownOptions> options;
}
