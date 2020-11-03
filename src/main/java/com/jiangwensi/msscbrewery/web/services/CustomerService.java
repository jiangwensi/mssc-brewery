package com.jiangwensi.msscbrewery.web.services;

import com.jiangwensi.msscbrewery.web.model.CustomerDto;

public interface CustomerService {
    CustomerDto getCustomerById(String customerId);
}
