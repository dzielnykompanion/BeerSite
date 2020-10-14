package com.mglb.beer_site.exceptions;

public class BeerIdExceptionResponse {

    private String BeerID;

    public BeerIdExceptionResponse(String BeerID) {
        this.BeerID = BeerID;
    }

    public String getBeerID() {
        return BeerID;
    }

    public void setBeerID(String beerID) {
        BeerID = beerID;
    }
}
