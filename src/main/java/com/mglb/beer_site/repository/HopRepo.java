package com.mglb.beer_site.repository;

import com.mglb.beer_site.model.recipe.hop.Hop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HopRepo extends JpaRepository<Hop, Long> {

}
