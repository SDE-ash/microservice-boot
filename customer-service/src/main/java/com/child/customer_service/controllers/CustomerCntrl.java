package com.child.customer_service.controllers;


import com.child.customer_service.dto.CustomerRequestDTO;
import com.child.customer_service.services.CustomerService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerCntrl {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<String> registerCustomer(@Valid @RequestBody CustomerRequestDTO customerRequest){

            customerService.addNewCustomer(customerRequest);
            log.info("customer added successfully!");
            return new ResponseEntity<>("user added successfully", HttpStatus.CREATED);

    }
}
