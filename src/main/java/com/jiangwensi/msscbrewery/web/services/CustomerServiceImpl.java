package com.jiangwensi.msscbrewery.web.services;

import com.jiangwensi.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by Jiang Wensi on 3/11/2020
 */
@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(String customerId) {
        return new CustomerDto().builder()
                .id(UUID.randomUUID())
                .name("Joe Buck")
                .build();
    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {
        return new CustomerDto().builder().id(UUID.randomUUID()).build();
    }

    @Override
    public void updateCustomer(String customerId, CustomerDto customerDto) {
        //todo impl - would add a real impl to update beer
    }

    @Override
    public void deleteCustomer(String customerId) {
        log.debug("Deleting a customer");
    }
}
