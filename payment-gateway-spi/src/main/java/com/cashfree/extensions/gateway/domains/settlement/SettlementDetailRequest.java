package com.cashfree.extensions.gateway.domains.settlement;

import java.time.LocalDateTime;
import java.util.Map;
import lombok.Data;

@Data
public class SettlementDetailRequest {
  private Map<String, Object> paginationAttributes;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private Integer pageSize;
  private Integer pageNumber;
  private Long extensionConfigId;
  private Long gatewaySettlementEntryId;
}
