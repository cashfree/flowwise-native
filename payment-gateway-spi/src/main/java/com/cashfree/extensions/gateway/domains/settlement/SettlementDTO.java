package com.cashfree.extensions.gateway.domains.settlement;

import com.cashfree.extensions.gateway.constants.PayConstants;
import com.cashfree.extensions.gateway.domains.enums.ReconEntityType;
import com.cashfree.extensions.gateway.domains.enums.SettlementSaleType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SettlementDTO {
  private String transferId;

  private String eventId;

  private ReconEntityType event;

  private BigDecimal eventAmount;

  private PayConstants.PaymentMode paymentMode;

  private BigDecimal serviceCharge;

  private BigDecimal serviceTax;

  private String settlementId;

  private BigDecimal settlementAmount;

  private BigDecimal settlementCharge;

  private BigDecimal settlementTax;

  private BigDecimal adjustmentCharge;

  private BigDecimal adjustmentTax;

  private Status status;

  LocalDateTime eventTime;

  private SettlementSaleType saleType;

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime settlementTime;

  private String utr;

  private String currency;

  private String pg;

  private Long extensionConfigId;

  private String settlementResponse;
}
