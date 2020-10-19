package com.mglb.beer_site.model.recipe;

import com.mglb.beer_site.model.Beer;
import com.mglb.beer_site.model.recipe.addition.Addition;
import com.mglb.beer_site.model.recipe.hop.Hop;
import com.mglb.beer_site.model.recipe.malt.Malt;
import com.mglb.beer_site.model.recipe.steps.Step;
import com.mglb.beer_site.model.recipe.yeast.Yeast;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @OneToMany(cascade = CascadeType.ALL)
    @ElementCollection
    private List<Hop> hops = new ArrayList();

    @OneToMany(cascade = CascadeType.ALL)
    @ElementCollection
    private List<Malt> malts = new ArrayList();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="ADDITION_ID")
    private List<Addition> additions;

    @OneToMany(cascade = CascadeType.ALL)
    @ElementCollection
    private List<Step> steps = new ArrayList();

    @OneToOne(cascade = CascadeType.ALL)
    private Yeast yeast;

    private String comments;

    public Recipe() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public List<Hop> getHops() {
        return hops;
    }

    public void setHops(List<Hop> hops) {
        this.hops = hops;
    }

    public List<Malt> getMalts() {
        return malts;
    }

    public void setMalts(List<Malt> malts) {
        this.malts = malts;
    }

    public List<Addition> getAdditions() {
        return additions;
    }

    public void setAdditions(List<Addition> additions) {
        this.additions = additions;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
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
