package com.third.fraud_service.repo;

import com.third.fraud_service.modal.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudCheckRepo extends JpaRepository<FraudCheckHistory, Integer> {
}
