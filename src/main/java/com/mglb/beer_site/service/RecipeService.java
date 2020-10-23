package com.mglb.beer_site.service;

import com.mglb.beer_site.model.Beer;
import com.mglb.beer_site.model.recipe.Recipe;
import com.mglb.beer_site.repository.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {

    @Autowired
    BeerService beerService;

    @Autowired
    RecipeRepo recipeRepo;

    public Recipe updateRecipe (Long beerID, Recipe recipe) {

        // if beer doesnt exist, findById method will throw exception
        Beer existingBeer = beerService.findById(beerID);

        recipe.setId(existingBeer.getRecipe().getId());

        recipeRepo.save(recipe);

        return recipe;
    }


}
