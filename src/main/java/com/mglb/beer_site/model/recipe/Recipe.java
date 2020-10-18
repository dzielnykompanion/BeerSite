package com.mglb.beer_site.model.recipe;

import com.mglb.beer_site.model.recipe.addition.Addition;
import com.mglb.beer_site.model.recipe.hop.Hop;
import com.mglb.beer_site.model.recipe.malt.Malt;
import com.mglb.beer_site.model.recipe.steps.Step;
import com.mglb.beer_site.model.recipe.yeast.Yeast;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private ArrayList<Hop> hops;
    private ArrayList<Malt> malts;
    private ArrayList<Addition> additions;
    private ArrayList<Step> steps;
    private Yeast yeast;
    private String comments;

    // one to one with Beer

    public Recipe() {
    }

    public Recipe(ArrayList<Hop> hops, ArrayList<Malt> malts, ArrayList<Addition> additions, ArrayList<Step> steps, Yeast yeast, String comments) {
        this.hops = hops;
        this.malts = malts;
        this.additions = additions;
        this.steps = steps;
        this.yeast = yeast;
        this.comments = comments;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public ArrayList<Hop> getHops() {
        return hops;
    }

    public void setHops(ArrayList<Hop> hops) {
        this.hops = hops;
    }

    public ArrayList<Malt> getMalts() {
        return malts;
    }

    public void setMalts(ArrayList<Malt> malts) {
        this.malts = malts;
    }

    public ArrayList<Addition> getAdditions() {
        return additions;
    }

    public void setAdditions(ArrayList<Addition> additions) {
        this.additions = additions;
    }

    public ArrayList<Step> getSteps() {
        return steps;
    }

    public void setSteps(ArrayList<Step> steps) {
        this.steps = steps;
    }

    public Yeast getYeast() {
        return yeast;
    }

    public void setYeast(Yeast yeast) {
        this.yeast = yeast;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "Id=" + Id +
                ", hops=" + hops +
                ", malts=" + malts +
                ", additions=" + additions +
                ", steps=" + steps +
                ", yeast=" + yeast +
                ", comments='" + comments + '\'' +
                '}';
    }
}
