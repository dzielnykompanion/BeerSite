package com.mglb.beer_site.exceptions;

public class RecipeIdExceptionResponse {

    private String RecipeID;

    public RecipeIdExceptionResponse(String recipeID) {
        RecipeID = recipeID;
    }

    public String getRecipeID() {
        return RecipeID;
    }

    public void setRecipeID(String recipeID) {
        RecipeID = recipeID;
    }
}
