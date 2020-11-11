package com.mglb.beer_site.service;

import com.mglb.beer_site.exceptions.BeerIdException;
import com.mglb.beer_site.exceptions.RecipeIdException;
import com.mglb.beer_site.model.Beer;
import com.mglb.beer_site.model.BeerStyleEnum;
import com.mglb.beer_site.model.recipe.Recipe;
import com.mglb.beer_site.repository.BeerRepo;
import com.mglb.beer_site.repository.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BeerService {

    @Autowired
    private BeerRepo beerRepo;

    @Autowired
    private RecipeService recipeService;

    public Beer addOrUpdateBeer(Beer beer){
        // UPDATE BEER
        // if beer with given ID exist
        if (beer.getId() != null) {
            Beer existingBeer = findById(beer.getId());

            // dont let save different recipe to our beer
            if (    beer.getRecipe() != null &&
                    beer.getRecipe().getId() != null &&
                    !beer.getRecipe().getId().equals(existingBeer.getRecipe().getId())){
                throw new RecipeIdException("Recipe with given ID doesn't belong to this beer.");
                 }

            // if we pass JSON beer with already recipe inside, no matters with or without ID
            if (beer.getRecipe() != null ) {
                Recipe newRecipe = beer.getRecipe();
                newRecipe.setId(existingBeer.getRecipe().getId());
                recipeService.saveRecipe(newRecipe);
                }
            }

        // SAVE BEER
        else {
            // when we create new beer without recipe, create new recipe
            if (beer.getRecipe() == null) {
                Recipe recipe = new Recipe();
                beer.setRecipe(recipe);
                recipeService.saveRecipe(recipe);
            }
            // when we create beer with recipe
            else {
                Recipe recipe2 = beer.getRecipe();
                // in that case create recipe with new ID
                recipe2.setId(null);
                beer.setRecipe(recipe2);
                recipeService.saveRecipe(recipe2);
            }
        }

        return beerRepo.save(beer);
    }

    public List<Beer> getAll(){
        return beerRepo.findAll();
    }

    public Beer findById(Long id){
        try {
            Beer beer = beerRepo.findById(id).get();
            return beer;
        } catch (Exception ex){
            throw new BeerIdException("Beer with ID " + id + " doesn't exist!");
        }
    }

    public void deleteBeer(Long id){
        try {
        beerRepo.deleteById(id);
        } catch (Exception ex){
            throw new BeerIdException("Beer with ID " + id + " doesn't exist!");
        }
    }


}
