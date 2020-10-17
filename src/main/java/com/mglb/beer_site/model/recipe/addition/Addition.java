package com.mglb.beer_site.model.recipe.addition;

public class Addition {

    private String name;
    private AdditionType type;
    private int amount;
    private String time; // 1 day, 5 min etc.

    public Addition() {
    }

    public Addition(String name, AdditionType type, int amount, String time) {
        this.name = name;
        this.type = type;
        this.amount = amount;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AdditionType getType() {
        return type;
    }

    public void setType(AdditionType type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
