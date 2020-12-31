package com.mglb.beer_site.exceptions.recipe;

public class YeastIdExceptionResponse {

    private String YeastID;

    public YeastIdExceptionResponse(String yeastID) {
        YeastID = yeastID;
    }

    public String getYeastID() {
        return YeastID;
    }

    public void setYeastID(String yeastID) {
        YeastID = yeastID;
    }
}
