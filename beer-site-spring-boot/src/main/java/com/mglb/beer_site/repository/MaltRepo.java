package com.mglb.beer_site.repository;

import com.mglb.beer_site.model.recipe.malt.Malt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaltRepo extends JpaRepository <Malt, Long> {

}
