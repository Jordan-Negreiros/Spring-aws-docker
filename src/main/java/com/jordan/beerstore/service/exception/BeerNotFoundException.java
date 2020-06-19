package com.jordan.beerstore.service.exception;

import org.springframework.http.HttpStatus;

public class BeerNotFoundException extends BusinessException{

    public BeerNotFoundException() {
        super("beers-6",HttpStatus.NO_CONTENT);
    }
}
