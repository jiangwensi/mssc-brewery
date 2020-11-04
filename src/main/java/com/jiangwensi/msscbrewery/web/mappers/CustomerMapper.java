package com.jiangwensi.msscbrewery.web.mappers;

import com.jiangwensi.msscbrewery.domain.Customer;
import com.jiangwensi.msscbrewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    CustomerDto mapCustomerToCustomerDto(Customer customer);
    Customer mapCustomerDtoToCustomer(CustomerDto dto);
}
