package com.jiangwensi.msscbrewery.web.controller;

import com.jiangwensi.msscbrewery.web.model.CustomerDto;
import com.jiangwensi.msscbrewery.web.services.CustomerService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;


@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CustomerService customerService;

    CustomerDto customerDto;

    @BeforeEach
    void setUp() {
        customerDto =
                customerDto
                .builder()
                .id(UUID.randomUUID())
                .name("customer name")
                .build();
    }

    @AfterEach
    void tearDown() {
        reset(customerService);
    }

    @Test
    void getCustomer() throws Exception {
        given(customerService.getCustomerById(customerDto.getId().toString())).willReturn(customerDto);
        mockMvc.perform(get("/api/v1/customer/"+customerDto.getId()))
                .andExpect(jsonPath("$.id",is(customerDto.getId().toString())))
                .andExpect(jsonPath("$.name",is("customer name")))
                .andExpect(status().isOk())
                .andReturn();
        verify(customerService,times(1)).getCustomerById(customerDto.getId().toString());
    }
}