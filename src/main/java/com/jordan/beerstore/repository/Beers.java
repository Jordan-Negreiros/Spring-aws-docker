package com.jordan.beerstore.repository;

import com.jordan.beerstore.model.Beer;
import com.jordan.beerstore.model.BeerType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Beers extends JpaRepository<Beer, Long> {

    Optional<Beer> findByNameAndType(String name, BeerType type);
}
