package com.mglb.beer_site.model.recipe.hop;

public class Hop {

    private String name;
    private int amount;
    private int time;
    private HopApplicationEnum application;
    private String comments;

    public Hop() {
    }

    public Hop(String name, int amount, int time, HopApplicationEnum application, String comments) {
        this.name = name;
        this.amount = amount;
        this.time = time;
        this.application = application;
        this.comments = comments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public HopApplicationEnum getApplication() {
        return application;
    }

    public void setApplication(HopApplicationEnum application) {
        this.application = application;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
