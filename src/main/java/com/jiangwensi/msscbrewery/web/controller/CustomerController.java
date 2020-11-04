package com.jiangwensi.msscbrewery.web.controller;

import com.jiangwensi.msscbrewery.web.model.CustomerDto;
import com.jiangwensi.msscbrewery.web.services.CustomerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jiang Wensi on 3/11/2020
 */
@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"/{customerId}"})
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") String customerId){
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createCustomer(@Valid @RequestBody CustomerDto customerDto){
        CustomerDto savedCustomer = customerService.saveNewCustomer(customerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/customer/"+savedCustomer.getId());
        return new ResponseEntity(headers,HttpStatus.CREATED);
    }

    @PutMapping({"/{customerId}"})
    public ResponseEntity updateCustomer(@PathVariable String customerId,@Valid  @RequestBody CustomerDto customerDto){
        customerService.updateCustomer(customerId,customerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    @DeleteMapping({"/{customerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable String customerId){
        customerService.deleteCustomer(customerId);
    }
}
