package com.jiangwensi.msscbrewery.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jiangwensi.msscbrewery.web.model.BeerDto;
import com.jiangwensi.msscbrewery.web.services.BeerService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static com.jiangwensi.msscbrewery.utils.Convertors.asJsonString;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @MockBean
    BeerService beerService;

    @Autowired
    MockMvc mockMvc;

    BeerDto beerDto;

    @BeforeEach
    void setUp() {
        beerDto = BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("beer name")
                .beerStyle("beer style")
                .upc(12345l)
                .build();
    }

    @AfterEach
    void tearDown() {
        reset(beerService);
    }

    @Test
    void getBeer() throws Exception {

        given(beerService.getBeerById(any())).willReturn(beerDto);

        mockMvc
                .perform(get("/api/v1/beer/" + beerDto.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(beerDto.getId().toString())))
                .andExpect(jsonPath("$.beerName", is("beer name")))
                .andExpect(jsonPath("$.beerStyle", is("beer style")))
                .andExpect(jsonPath("$.upc", is(12345)))
                .andReturn();
        verify(beerService, times(1)).getBeerById(beerDto.getId());
    }

    @Test
    void handlePost() throws Exception {
        beerDto.setId(null);
        BeerDto savedBto = BeerDto.builder().id(UUID.randomUUID()).build();
        given(beerService.saveNewBeer(beerDto)).willReturn(savedBto);
        mockMvc.perform(
                post("/api/v1/beer")
                        .content(asJsonString(beerDto))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", "/api/v1/beer/" + savedBto.getId().toString()))
                .andReturn();
        verify(beerService, times(1)).saveNewBeer(beerDto);
    }

    @Test
    void handleUpdate() throws Exception {
        beerDto.setId(null);

        mockMvc.perform(
                put("/api/v1/beer/" + UUID.randomUUID())
                        .content(asJsonString(beerDto))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNoContent())
                .andReturn();
        verify(beerService, times(1)).updateBeer(any(UUID.class), any(BeerDto.class));
    }

    @Test
    void deleteBeer() throws Exception {
        mockMvc.perform(delete("/api/v1/beer/"+beerDto.getId()))
                .andExpect(status().isNoContent())
                .andReturn();
        verify(beerService,times(1)).deleteById(beerDto.getId());
    }
}