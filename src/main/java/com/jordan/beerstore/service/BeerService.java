package com.jordan.beerstore.service;

import com.jordan.beerstore.model.Beer;
import com.jordan.beerstore.repository.Beers;
import com.jordan.beerstore.service.exception.BeerAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BeerService {

    @Autowired
    private Beers beers;

    public Beer save(final Beer beer) {

        Optional<Beer> beerByNameAndType = beers.findByNameAndType(beer.getName(), beer.getType());

        if (beerByNameAndType.isPresent()) {
            throw new BeerAlreadyExistException();
        }

        return beers.save(beer);
    }
}
