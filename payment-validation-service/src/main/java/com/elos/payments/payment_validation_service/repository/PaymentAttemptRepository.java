package com.elos.payments.payment_validation_service.repository;


import com.elos.payments.payment_validation_service.entity.PaymentAttempt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface PaymentAttemptRepository extends JpaRepository<PaymentAttempt, Long> {

    int countByClientAddressAndCreatedDateAfter(String clientAddress, LocalDateTime after);
}