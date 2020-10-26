package com.mglb.beer_site.web;

import com.mglb.beer_site.model.Beer;
import com.mglb.beer_site.model.recipe.Recipe;
import com.mglb.beer_site.repository.RecipeRepo;
import com.mglb.beer_site.service.BeerService;
import com.mglb.beer_site.service.ErrorMapValidationService;
import com.mglb.beer_site.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
public class RecipeController {

    private RecipeService recipeService;
    private ErrorMapValidationService errorMapValidationService;


    @Autowired
    public RecipeController(RecipeService recipeService, ErrorMapValidationService errorMapValidationService) {
        this.recipeService = recipeService;
        this.errorMapValidationService = errorMapValidationService;
    }

    @PostMapping("{beerID}")
    public ResponseEntity<?> updateRecipe(@PathVariable Long beerID, @Valid @RequestBody Recipe recipe, BindingResult result){
        ResponseEntity<?> errorMap = errorMapValidationService.errorMapValidationService(result);
        if(errorMap != null) return errorMap;
        recipeService.updateRecipe(beerID, recipe);
        return new ResponseEntity<Recipe>(recipe, HttpStatus.CREATED);
    }

    @PostMapping("/recipe/{beerID}")
    public ResponseEntity<?> resetRecipe (@PathVariable Long beerID) {
        recipeService.resetRecipe(beerID);
        return new ResponseEntity<String>("Recipe reseted", HttpStatus.OK);
    }

    @GetMapping("/recipe/{beerID}")
    public ResponseEntity<?> getRecipe (@PathVariable Long beerID){
        Recipe recipe = recipeService.getRecipe(beerID);
        return new ResponseEntity<Recipe>(recipe, HttpStatus.OK);
    }

}
