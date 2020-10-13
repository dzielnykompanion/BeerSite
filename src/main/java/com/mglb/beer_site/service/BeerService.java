package com.mglb.beer_site.service;

import com.mglb.beer_site.model.Beer;
import com.mglb.beer_site.model.BeerStyleEnum;
import com.mglb.beer_site.repository.BeerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeerService {

    @Autowired
    private BeerRepo beerRepo;

    public Beer addOrUpdateBeer(Beer beer){
        return beerRepo.save(beer);
    }

    public List<Beer> getAll(){
        return beerRepo.findAll();
    }

    public Beer findById(Long id){
        Beer beer = beerRepo.findById(id).get();
        return beerRepo.findById(id).get();
    }

    public void deleteBeer(Long id){
        beerRepo.deleteById(id);
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
