package com.mglb.beer_site.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mglb.beer_site.model.recipe.Recipe;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Beer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank( message = "Name of your beer cannot be blank")
    @Size(max = 50, message = "Please use max 50 characters")
    private String name;

    @NotNull
    private BeerStyleEnum mainStyle;
    private String detailedStyle;
    private int batchVolume;
    private double alcohol;
    private int biterness;
    private String description;
    private String comments;

    // one to one with recipe
    private Recipe recipe;




    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(updatable = false)
    private Date created_At;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date updated_At;


    public Beer() {
    }

    public Beer(@NotBlank(message = "Name of your beer cannot be blank") @Size(max = 50, message = "Please use max 50 characters") String name, @NotNull BeerStyleEnum mainStyle, String detailedStyle, int batchVolume, double alcohol, int biterness, Recipe recipe, String description, String comments, Date created_At, Date updated_At) {
        this.name = name;
        this.mainStyle = mainStyle;
        this.detailedStyle = detailedStyle;
        this.batchVolume = batchVolume;
        this.alcohol = alcohol;
        this.biterness = biterness;
        this.recipe = recipe;
        this.description = description;
        this.comments = comments;
        this.created_At = created_At;
        this.updated_At = updated_At;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BeerStyleEnum getMainStyle() {
        return mainStyle;
    }

    public void setMainStyle(BeerStyleEnum mainStyle) {
        this.mainStyle = mainStyle;
    }

    public String getDetailedStyle() {
        return detailedStyle;
    }

    public void setDetailedStyle(String detailedStyle) {
        this.detailedStyle = detailedStyle;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getCreated_At() {
        return created_At;
    }

    public void setCreated_At(Date created_At) {
        this.created_At = created_At;
    }

    public Date getUpdated_At() {
        return updated_At;
    }

    public void setUpdated_At(Date updated_At) {
        this.updated_At = updated_At;
    }

    public int getBatchVolume() {
        return batchVolume;
    }

    public void setBatchVolume(int batchVolume) {
        this.batchVolume = batchVolume;
    }

    public double getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(double alcohol) {
        this.alcohol = alcohol;
    }

    public int getBiterness() {
        return biterness;
    }

    public void setBiterness(int biterness) {
        this.biterness = biterness;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mainStyle=" + mainStyle +
                ", detailedStyle='" + detailedStyle + '\'' +
                ", batchVolume=" + batchVolume +
                ", alcohol=" + alcohol +
                ", biterness=" + biterness +
                ", description='" + description + '\'' +
                ", comments='" + comments + '\'' +
                ", recipe=" + recipe +
                ", created_At=" + created_At +
                ", updated_At=" + updated_At +
                '}';
    }

    @PrePersist
    protected void onCreate(){
        this.created_At = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updated_At = new Date();
    }
}
