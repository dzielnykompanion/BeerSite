package com.mglb.beer_site.repository;

import com.mglb.beer_site.model.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeerRepo extends JpaRepository<Beer, Long> {
}
