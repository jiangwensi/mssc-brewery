package com.jiangwensi.msscbrewery.web.services;

import com.jiangwensi.msscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by Jiang Wensi on 3/11/2020
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(String customerId) {
        return new CustomerDto().builder()
                .id(UUID.randomUUID())
                .name("Joe Buck")
                .build();
    }
}
