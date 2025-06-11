package com.child.customer_service.repository;

import com.child.customer_service.modal.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {


     boolean existsByEmail(String email);
}
