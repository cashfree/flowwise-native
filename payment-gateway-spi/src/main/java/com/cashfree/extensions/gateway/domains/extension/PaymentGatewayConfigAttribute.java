package com.cashfree.extensions.gateway.domains.extension;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentGatewayConfigAttribute {
  private String name;

  @NotNull private ConfigAttributeStorageType storageType;

  @NotNull private ConfigAttributeUIType uiType;

  private String validationRegex;

  private Boolean optional;

  private String displayText;

  private String description;
}
