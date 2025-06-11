package com.third.fraud_service.services;

import com.third.fraud_service.modal.FraudCheckHistory;
import com.third.fraud_service.repo.FraudCheckRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FraudService {

    @Autowired
    private FraudCheckRepo fraudCheckRepo;

    public boolean isFradulentCustomer(Integer customerId) {

        fraudCheckRepo.save(FraudCheckHistory.builder()
                .customerId(customerId)
                .isFraudester(false)
                .createdAt(LocalDateTime.now())
                .build());

        return false;
    }
}
