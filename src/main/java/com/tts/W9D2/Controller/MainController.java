package com.tts.W9D2.Controller;


import com.tts.W9D2.Model.Customer;
import com.tts.W9D2.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class MainController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/random")
    public Integer getRandomInteger() {
        Random random = new Random();
        return random.nextInt(1000);
    }

    @GetMapping("/customer/all")
    public List<Customer>  getAllCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable Long id){
        return customerRepository.findById(id).orElseThrow();
    }
}
