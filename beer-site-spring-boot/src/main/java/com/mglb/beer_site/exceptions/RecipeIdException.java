package com.mglb.beer_site.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RecipeIdException extends RuntimeException {

    public RecipeIdException(String message) { super(message); }
}
