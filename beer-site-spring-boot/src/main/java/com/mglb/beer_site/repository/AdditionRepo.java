package com.mglb.beer_site.repository;

import com.mglb.beer_site.model.recipe.addition.Addition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionRepo extends JpaRepository<Addition, Long> {

}
