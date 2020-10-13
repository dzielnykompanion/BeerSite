package com.mglb.beer_site.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
public class ErrorMapValidationService {

    public ResponseEntity<?> errorMapValidationService(BindingResult result){

        if (result.hasErrors()){

            // To see errors like
            // "field1" : "error message 1",
            // "field2" : "error message 2"

            Map<String, String> errorMap =  new HashMap<>();

            for(FieldError error : result.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }

            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        // in case of no errors
        return null;
    }
}
