package com.jiangwensi.msscbrewery.web.mappers;

import com.jiangwensi.msscbrewery.domain.Beer;
import com.jiangwensi.msscbrewery.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDto dto);
}
