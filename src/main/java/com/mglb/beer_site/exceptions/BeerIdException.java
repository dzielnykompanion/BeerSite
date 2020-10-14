package com.mglb.beer_site.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BeerIdException extends RuntimeException{

    public BeerIdException(String message) {
        super(message);
    }
}
