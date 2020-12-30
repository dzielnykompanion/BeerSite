package com.mglb.beer_site.service;

import com.mglb.beer_site.model.recipe.hop.Hop;
import com.mglb.beer_site.repository.HopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HopService {

    @Autowired
    private HopRepo hopRepo;

    public Hop addOrUpdateHop (Hop hop) {
        // TODO
        return hop;
    }

    public List<Hop> getAll(){
        return hopRepo.findAll();
    }

    public Hop findById(Long id) {
        // TODO
        return null;
    }

    public void deleteHop(Long id) {
        // TODO
    }

}
