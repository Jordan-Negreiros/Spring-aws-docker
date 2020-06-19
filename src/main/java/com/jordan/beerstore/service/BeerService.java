package com.jordan.beerstore.service;

import com.jordan.beerstore.model.Beer;
import com.jordan.beerstore.repository.Beers;
import com.jordan.beerstore.service.exception.BeerAlreadyExistException;
import com.jordan.beerstore.service.exception.BeerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BeerService {

    private final Beers beers;

    public BeerService(@Autowired Beers beers) {
        this.beers = beers;
    }

    public Beer save(final Beer beer) {
        verifyIfBeerExists(beer);
        return beers.save(beer);
    }

    public void delete(final Long id) {
        final Optional<Beer> beer = beers.findById(id);

        if (!beer.isPresent()) {
            throw new BeerNotFoundException();
        }

        beers.delete(beer.get());
    }

    private void verifyIfBeerExists(final Beer beer) {

        Optional<Beer> beerByNameAndType = beers.findByNameAndType(beer.getName(), beer.getType());

        if (beerByNameAndType.isPresent() && (beer.isNew() ||
                isUpdatingToDifferentBeer(beer, beerByNameAndType))) {
            throw new BeerAlreadyExistException();
        }
    }

    private boolean isUpdatingToDifferentBeer(Beer beer, Optional<Beer> beerByNameAndType) {

        return beer.alreadyExist() && !beerByNameAndType.get().equals(beer);
    }

}
