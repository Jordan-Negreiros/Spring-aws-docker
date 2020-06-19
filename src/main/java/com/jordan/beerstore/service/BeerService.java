package com.jordan.beerstore.service;

import com.jordan.beerstore.model.Beer;
import com.jordan.beerstore.service.exception.BeerAlreadyExistException;

public class BeerService {

    public void save(Beer beer) {
        throw new BeerAlreadyExistException();
    }
}
