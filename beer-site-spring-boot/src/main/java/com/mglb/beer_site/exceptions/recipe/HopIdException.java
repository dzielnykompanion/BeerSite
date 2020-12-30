package com.mglb.beer_site.exceptions.recipe;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class HopIdException extends RuntimeException{

    public HopIdException(String message) { super(message); }

}
