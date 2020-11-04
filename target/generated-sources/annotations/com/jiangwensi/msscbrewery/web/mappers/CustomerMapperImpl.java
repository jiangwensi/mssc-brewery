package com.jiangwensi.msscbrewery.web.mappers;

import com.jiangwensi.msscbrewery.domain.Customer;
import com.jiangwensi.msscbrewery.web.model.CustomerDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-04T20:35:35+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDto mapCustomerToCustomerDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        return customerDto;
    }

    @Override
    public Customer mapCustomerDtoToCustomer(CustomerDto dto) {
        if ( dto == null ) {
            return null;
        }

        Customer customer = new Customer();

        return customer;
    }
}
