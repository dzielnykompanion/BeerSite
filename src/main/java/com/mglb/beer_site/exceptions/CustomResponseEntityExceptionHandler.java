package com.mglb.beer_site.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleBeerIdException(BeerIdException ex, WebRequest request){

        BeerIdExceptionResponse beerIdExceptionResponse = new BeerIdExceptionResponse(ex.getMessage());

        return new ResponseEntity<>(beerIdExceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleRecipeIdException(RecipeIdException ex, WebRequest request){

        RecipeIdExceptionResponse recipeIdExceptionResponse = new RecipeIdExceptionResponse(ex.getMessage());

        return new ResponseEntity<>(recipeIdExceptionResponse, HttpStatus.BAD_REQUEST);
    }


}
