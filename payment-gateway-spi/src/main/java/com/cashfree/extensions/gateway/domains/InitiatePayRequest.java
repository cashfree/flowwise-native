package com.cashfree.extensions.gateway.domains;

import com.cashfree.extensions.gateway.domains.enums.IntegrationType;
import com.cashfree.extensions.gateway.domains.internal.CustomerDetails;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class InitiatePayRequest {

  @NotNull private String transactionId;

  @NotNull private BigDecimal amount;

  @NotNull private Long merchantId;

  private String mode;

  @NotNull @NotEmpty private String merchantOrderId;

  private String merchantOrderNote;

  @NotNull @NotEmpty private String currency;

  private Long credId;

  @NotNull @NotEmpty private String pg;

  @ToString.Exclude private String customerName;
  @ToString.Exclude private String customerId;

  @ToString.Exclude private String customerPhone;

  @ToString.Exclude private String customerEmail;

  private CustomerDetails customerDetails;

  @NotNull @NotEmpty private String returnUrl;

  private String notifyUrl;

  private String cancelUrl;

  @NotEmpty @NotNull private String deviceType;

  @ToString.Exclude private Map<String, Object> data;

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime transactionTime;

  private Boolean isNativeOTPEnabled;
  private Boolean saveInstrument;
  //  This flag will be used to identify whether the payment will be capture and transfer to
  // merchant account or
  //  Just perform the authorization and merchant will manually make the capture request.
  private Boolean capturePayment;

  private Integer emiTenure = null;

  private String modeCode;

  private String orderId;

  private String pollingUrl;

  private String verifyOtpUrl;

  private IntegrationType integrationType = IntegrationType.S2S;
}
