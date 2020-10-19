package com.mglb.beer_site.repository;

import com.mglb.beer_site.model.recipe.yeast.Yeast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YeastRepo extends JpaRepository<Yeast, Long> {

}
