package com.mglb.beer_site.service;

import com.mglb.beer_site.exceptions.BeerIdException;
import com.mglb.beer_site.model.Beer;
import com.mglb.beer_site.model.recipe.Recipe;
import com.mglb.beer_site.repository.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {

    BeerService beerService;
    RecipeRepo recipeRepo;

    @Autowired
    public RecipeService(BeerService beerService, RecipeRepo recipeRepo) {
        this.beerService = beerService;
        this.recipeRepo = recipeRepo;
    }

    public Recipe updateRecipe (Long beerID, Recipe recipe) {

        // if beer doesnt exist, findById method will throw exception
        Beer existingBeer = beerService.findById(beerID);

        recipe.setId(existingBeer.getRecipe().getId());

        return recipeRepo.save(recipe);
    }

    public Recipe saveRecipe (Recipe recipe){

        return recipeRepo.save(recipe);
    }

    // we dont want to delete Recipe, only to reset it
    public void resetRecipe(Long beerID){
        Recipe newRecipe = new Recipe();
        Beer existingBeer = beerService.findById(beerID);

        newRecipe.setId(existingBeer.getRecipe().getId());

        saveRecipe(newRecipe);
    }


}
