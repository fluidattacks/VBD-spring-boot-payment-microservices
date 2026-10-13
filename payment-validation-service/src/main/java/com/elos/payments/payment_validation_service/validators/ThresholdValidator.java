package com.elos.payments.payment_validation_service.validators;


import com.elos.payments.payment_validation_service.dto.PaymentRequestDTO;
import com.elos.payments.payment_validation_service.exception.ThresholdExceededException;
import com.elos.payments.payment_validation_service.repository.PaymentAttemptRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component("paymentAttemptThresholdValidator")
public class ThresholdValidator implements Validator {

    @Value("${payment.validation.threshold.hours}")
    private int thresholdHours;
    @Value("${payment.validation.threshold.attempts}")
    private int thresholdAttempts;
    @Autowired
    private PaymentAttemptRepository repository;

    @Override
    public void validate(PaymentRequestDTO paymentRequest) {
        String clientAddress = paymentRequest.getClientAddress();
        if (clientAddress == null || clientAddress.isBlank()) {
            throw new IllegalStateException("Client address missing; cannot apply the attempt threshold.");
        }
        LocalDateTime since = LocalDateTime.now().minusHours(thresholdHours);
        int recentAttempts = repository.countByClientAddressAndCreatedDateAfter(clientAddress, since);

        if (recentAttempts > thresholdAttempts) {
            throw new ThresholdExceededException("Payment attempt limit exceeded.");
        }
    }

    @Override
    public String getRuleName() {
        return "paymentAttemptThresholdValidator";
    }
}