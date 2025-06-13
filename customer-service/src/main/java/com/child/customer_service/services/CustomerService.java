package com.child.customer_service.services;

import com.child.customer_service.ExceptionHandlers.EmailAlreadyExistsException;
import com.child.customer_service.dto.CustomerRequestDTO;
import com.child.customer_service.modal.Customer;
import com.child.customer_service.modal.FraudCheckResponse;
import com.child.customer_service.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private RestTemplate restTemplate;

    //save  customer
    public void addNewCustomer(CustomerRequestDTO requestDTO){
        //mapping customedto to customer
        if(!isCustomerExists(requestDTO.getEmail())){
            Customer customer = Customer.builder().firstName(requestDTO.getFirstName()).lastName(requestDTO.getLastName()).email(requestDTO.getEmail()).build();
        customerRepo.saveAndFlush(customer);

        //check if the customer is fraud or not
        FraudCheckResponse fraudResponse = restTemplate.getForObject(
                "http://fraud-service/fraud-check/cust/{customerId}",
                FraudCheckResponse.class,
                customer.getId());

            if(fraudResponse != null && fraudResponse.isFraudster()){
                throw new IllegalStateException("fraudster");
            }
        }else{
            throw new EmailAlreadyExistsException("THE email address "+requestDTO.getEmail()+" is already in-use");
        }
    }

    public boolean isCustomerExists(String email){
        if(customerRepo.existsByEmail(email)){
            return  true;
        }
        return  false;
    }
}
