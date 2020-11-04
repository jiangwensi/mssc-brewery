package com.jiangwensi.msscbrewery.web.mappers;

import com.jiangwensi.msscbrewery.domain.Beer;
import com.jiangwensi.msscbrewery.web.model.BeerDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-04T20:35:35+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
@Component
public class BeerMapperImpl implements BeerMapper {

    @Override
    public BeerDto beerToBeerDto(Beer beer) {
        if ( beer == null ) {
            return null;
        }

        BeerDto beerDto = new BeerDto();

        return beerDto;
    }

    @Override
    public Beer beerDtoToBeer(BeerDto dto) {
        if ( dto == null ) {
            return null;
        }

        Beer beer = new Beer();

        return beer;
    }
}
