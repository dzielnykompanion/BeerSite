package com.mglb.beer_site.model.recipe.steps;

public class Step {

    private int time;
    private int temperature;

    public Step() {
    }

    public Step(int time, int temperature) {
        this.time = time;
        this.temperature = temperature;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}
