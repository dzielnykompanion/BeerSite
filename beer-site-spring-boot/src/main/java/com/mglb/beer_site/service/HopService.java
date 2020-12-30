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
        if ( hop.getId() != null )
        {
            Hop existingHop = findById(hop.getId());
        }
        return hopRepo.save(hop);
    }


    public List<Hop> getAll(){
        return hopRepo.findAll();
    }

    public Hop findById(Long id) {
        try {
            Hop hop = hopRepo.findById(id).get();
            return hop;
        } catch (Exception ex) {
            // TODO
            throw new RuntimeException();
        }
    }

    public void deleteHop(Long id) {
        try {
            hopRepo.deleteById(id);
        } catch (Exception Ex) {
            // TODO
            throw new RuntimeException();
        }
    }

}
