package com.mglb.beer_site.service;

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

        recipeRepo.save(recipe);

        return recipe;
    }

    public Recipe saveRecipe (Recipe recipe){
        recipeRepo.save(recipe);
        return recipe;
    }


}
