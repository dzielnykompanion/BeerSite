package com.mglb.beer_site.model.recipe.yeast;

public class Yeast {

    private String name;
    private YeastTypeEnum type;
    private YeastFormEnum form;
    private int amount;
    private String comments;

    public Yeast() {
    }

    public Yeast(String name, YeastTypeEnum type, YeastFormEnum form, int amount, String comments) {
        this.name = name;
        this.type = type;
        this.form = form;
        this.amount = amount;
        this.comments = comments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public YeastTypeEnum getType() {
        return type;
    }

    public void setType(YeastTypeEnum type) {
        this.type = type;
    }

    public YeastFormEnum getForm() {
        return form;
    }

    public void setForm(YeastFormEnum form) {
        this.form = form;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
