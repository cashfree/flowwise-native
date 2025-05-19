package com.cashfree.extensions.gateway.domains;

import com.cashfree.extensions.gateway.constants.PayConstants.PaymentRefundType;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class PaymentRefundDetailsDTO {

  private PaymentDetailsDTO paymentDetails;

  private String refundId;

  private String refundRefId;

  private BigDecimal refundAmount;

  private PaymentRefundType refundType;

  private String refundNote;
}
