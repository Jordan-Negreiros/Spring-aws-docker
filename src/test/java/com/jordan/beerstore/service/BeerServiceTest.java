package com.jordan.beerstore.service;


import com.jordan.beerstore.model.Beer;
import com.jordan.beerstore.model.BeerType;
import com.jordan.beerstore.service.exception.BeerAlreadyExistException;
import org.junit.Test;

import java.math.BigDecimal;

public class BeerServiceTest {

    private BeerService beerService;

    @Test(expected = BeerAlreadyExistException.class)
    public void should_deny_creation_of_beer_that_exists() {

        BeerService beerService = new BeerService();

        Beer newBeer = new Beer();
        newBeer.setName("Heineken");
        newBeer.setType(BeerType.LAGER);
        newBeer.setVolume(new BigDecimal("355"));

        beerService.save(newBeer);
    }
}
