package com.mglb.beer_site.service;

import com.mglb.beer_site.exceptions.BeerIdException;
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
    private RecipeRepo recipeRepo;

    public Beer addOrUpdateBeer(Beer beer){

        // if beer with given ID doesn't exist
        if (beer.getId() != null) {
            Beer existingBeer = findById(beer.getId());
            }
        else {
        // when we create beer we create also recipe
            Recipe recipe = new Recipe();
            beer.setRecipe(recipe);
            recipeRepo.save(recipe);
        }
        return beerRepo.save(beer);
    }

    public List<Beer> getAll(){
        return beerRepo.findAll();
    }

    public Beer findById(Long id){
        try {
            Beer beer = beerRepo.findById(id).get();
        } catch (Exception ex){
            throw new BeerIdException("Beer with ID " + id + " doesn't exist!");
        }
        return beerRepo.findById(id).get();
    }

    public void deleteBeer(Long id){
        try {
        beerRepo.deleteById(id);
        } catch (Exception ex){
            throw new BeerIdException("Beer with ID " + id + " doesn't exist!");
        }
    }




    @EventListener(ApplicationReadyEvent.class)
    public void fillDb() {
        Beer beer1 = new Beer();
        beer1.setName("GOLABEK PILSNER");
        beer1.setMainStyle(BeerStyleEnum.LAGER);
        beer1.setComments("Bardzo dobre piwko");

        Beer beer2 = new Beer();
        beer2.setName("GOLABEK APA");
        beer2.setMainStyle(BeerStyleEnum.ALE);
        beer2.setComments("Ajajaj, ale dobre");

        beerRepo.save(beer1);
        beerRepo.save(beer2);
    }
}
