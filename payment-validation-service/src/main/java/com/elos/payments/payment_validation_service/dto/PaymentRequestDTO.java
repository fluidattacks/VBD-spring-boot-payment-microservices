package com.elos.payments.payment_validation_service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class PaymentRequestDTO {
    private String merchantTransactionId;
    private UserDTO user;
    private double amount;  
    private String currency;
    @JsonIgnore
    private String clientAddress;
}