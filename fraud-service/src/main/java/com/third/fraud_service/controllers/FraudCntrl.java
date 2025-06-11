package com.third.fraud_service.controllers;


import com.third.fraud_service.modal.FraudCheckResponse;
import com.third.fraud_service.services.FraudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fraud-check")
@Slf4j
public class FraudCntrl {

    @Autowired
    private FraudService fraudService;

    @GetMapping("/cust/{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId){
        boolean isFraudsterCustomer = fraudService.isFradulentCustomer(customerId);
        return  new FraudCheckResponse(isFraudsterCustomer);
    }


}
