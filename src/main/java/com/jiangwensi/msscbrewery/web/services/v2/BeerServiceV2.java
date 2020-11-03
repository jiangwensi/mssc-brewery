package com.jiangwensi.msscbrewery.web.services.v2;

import com.jiangwensi.msscbrewery.web.model.v2.BeerDtoV2;

import java.util.UUID;

/**
 * Created by Jiang Wensi on 3/11/2020
 */
public interface BeerServiceV2 {
    BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto);

    void updateBeer(UUID beerId, BeerDtoV2 beerDto);

    void deleteById(UUID beerId);

    BeerDtoV2 getBeerById(UUID beerId);
}
