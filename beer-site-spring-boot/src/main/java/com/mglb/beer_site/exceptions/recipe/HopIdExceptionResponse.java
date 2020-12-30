package com.mglb.beer_site.exceptions.recipe;

public class HopIdExceptionResponse {

    private String HopID;

    public HopIdExceptionResponse(String hopID) {
        HopID = hopID;
    }

    public String getHopID() {
        return HopID;
    }

    public void setHopID(String hopID) {
        HopID = hopID;
    }
}
