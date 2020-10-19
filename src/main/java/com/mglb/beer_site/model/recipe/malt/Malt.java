package com.mglb.beer_site.model.recipe.malt;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Malt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private int amount;
    private MaltTypeEnum type;
    private int EBC;

    public Malt() {
    }

    public Malt(String name, int amount, MaltTypeEnum type, int EBC) {
        this.name = name;
        this.amount = amount;
        this.type = type;
        this.EBC = EBC;
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

    public MaltTypeEnum getType() {
        return type;
    }

    public void setType(MaltTypeEnum type) {
        this.type = type;
    }

    public int getEBC() {
        return EBC;
    }

    public void setEBC(int EBC) {
        this.EBC = EBC;
    }
}
