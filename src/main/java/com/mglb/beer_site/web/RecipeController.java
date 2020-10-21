package com.mglb.beer_site.web;

import com.mglb.beer_site.model.Beer;
import com.mglb.beer_site.model.recipe.Recipe;
import com.mglb.beer_site.repository.RecipeRepo;
import com.mglb.beer_site.service.BeerService;
import com.mglb.beer_site.service.ErrorMapValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
public class RecipeController {

    private BeerService beerService;
    private RecipeRepo recipeRepo;
    private ErrorMapValidationService errorMapValidationService;

    @Autowired
    public RecipeController(BeerService beerService, RecipeRepo recipeRepo, ErrorMapValidationService errorMapValidationService) {
        this.beerService = beerService;
        this.recipeRepo = recipeRepo;
        this.errorMapValidationService = errorMapValidationService;
    }


    @PostMapping("/{beerID}")
    public ResponseEntity<?> addRecipeToBeer(@PathVariable Long beerID, @Valid @RequestBody Recipe recipe, BindingResult result){

        ResponseEntity<?> errorMap = errorMapValidationService.errorMapValidationService(result);
        if(errorMap != null) return errorMap;

        Beer beer = beerService.findById(beerID);
        if (beer.getRecipe() != null) {
            return new ResponseEntity<String>("beer already has recipe", HttpStatus.BAD_REQUEST);
        }

        beer.setRecipe(recipe);

        recipeRepo.save(recipe);
        beerService.addOrUpdateBeer(beer);


        return new ResponseEntity<Beer>(beer, HttpStatus.CREATED);
    }
}
