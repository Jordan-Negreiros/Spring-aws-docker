package com.jordan.beerstore.repository;

import com.jordan.beerstore.model.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Beers extends JpaRepository<Beer, Long> {
}
