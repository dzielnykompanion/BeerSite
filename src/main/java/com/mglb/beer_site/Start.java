package com.mglb.beer_site;

import com.mglb.beer_site.model.Beer;
import com.mglb.beer_site.model.BeerStyleEnum;
import com.mglb.beer_site.repository.BeerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Start {

    BeerRepo beerRepo;

    public Start() {
    }

    @Autowired
    public Start(BeerRepo beerRepo) {
        this.beerRepo = beerRepo;

        Beer beer1 = new Beer();
        beer1.setName("GOLABEK PILSNER");
        beer1.setMainStyle(BeerStyleEnum.LAGER);
        beer1.setComments("Bardzo dobre piwko");

        Beer beer2 = new Beer();
        beer2.setName("GOLABEK APA");
        beer2.setMainStyle(BeerStyleEnum.ALE);
        beer2.setComments("Rownie dobre piwko, nawet lepsze");

        beerRepo.save(beer1);
        beerRepo.save(beer2);
    }


}
