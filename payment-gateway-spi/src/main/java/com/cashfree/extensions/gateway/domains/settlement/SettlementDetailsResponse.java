package com.cashfree.extensions.gateway.domains.settlement;

import java.util.List;
import java.util.Map;
import lombok.Data;

@Data
public class SettlementDetailsResponse {
  List<SettlementDTO> data;
  private Map<String, Object> paginationAttributes;
  private String gatewayResponse;
  private boolean isLastPage = true;
}
