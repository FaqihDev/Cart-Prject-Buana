package com.cart.spring.project.Service.impl;


import com.cart.spring.project.Entity.Customer;
import com.cart.spring.project.Repository.CustomerRepository;
import com.cart.spring.project.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;


@Service
public class CustomerServiceImpl implements CustomerService {

   @Autowired
   private CustomerRepository customerRepository;

    @Override
    public void addCustomer(Customer customer) {
        customer.setCreatedBy("Admin");
        Date today = Date.from(Instant.now());
        customer.setCreatedDate(today);
        customer.setIsDeleted(0);

        customerRepository.save(customer);
    }
}
