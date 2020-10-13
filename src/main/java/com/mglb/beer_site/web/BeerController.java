package com.mglb.beer_site.web;

import com.mglb.beer_site.model.Beer;
import com.mglb.beer_site.repository.BeerRepo;
import com.mglb.beer_site.service.BeerService;
import com.mglb.beer_site.service.ErrorMapValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin
public class BeerController {


    private BeerRepo beerRepo;
    private BeerService beerService;
    private ErrorMapValidationService errorMapValidationService;

    @Autowired
    public BeerController(BeerRepo beerRepo, BeerService beerService, ErrorMapValidationService errorMapValidationService) {
        this.beerRepo = beerRepo;
        this.beerService = beerService;
        this.errorMapValidationService = errorMapValidationService;
    }



    @PostMapping("/addBeer")
    public ResponseEntity<?> addOrUpdateBeer(@Valid @RequestBody Beer beer, BindingResult result) {

        ResponseEntity<?> errorMap = errorMapValidationService.errorMapValidationService(result);
        if(errorMap != null) return errorMap;

        beerService.addOrUpdateBeer(beer);
        return new ResponseEntity<Beer>(beer, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        List<Beer> beers = beerRepo.findAll();
        return new ResponseEntity<List<Beer>>(beers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Beer beer = beerService.findById(id);
        return new ResponseEntity<Beer>(beer, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBeer(@PathVariable Long id) {
        beerService.deleteBeer(id);
        return new ResponseEntity<String>("Beer with id " + id + " has been deleted.", HttpStatus.OK);
    }
}
