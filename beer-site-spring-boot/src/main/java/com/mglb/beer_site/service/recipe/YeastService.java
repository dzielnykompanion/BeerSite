package com.mglb.beer_site.service.recipe;

import com.mglb.beer_site.exceptions.recipe.HopIdException;
import com.mglb.beer_site.model.recipe.hop.Hop;
import com.mglb.beer_site.model.recipe.yeast.Yeast;
import com.mglb.beer_site.repository.HopRepo;
import com.mglb.beer_site.repository.YeastRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YeastService {

    @Autowired
    private YeastRepo yeastRepo;

    public Yeast addOrUpdateYeast (Yeast yeast) {
        if ( yeast.getId() != null )
        {
            Yeast existingYeast = findById(yeast.getId());
        }
        return yeastRepo.save(yeast);
    }


    public List<Yeast> getAll(){
        return yeastRepo.findAll();
    }

    public Yeast findById(Long id) {
        try {
            Yeast yeast = yeastRepo.findById(id).get();
            return yeast;
        } catch (Exception ex) {
            throw new HopIdException("Yeast with ID " + id + " doesn't exist");
        }
    }

    public void deleteYeast(Long id) {
        try {
            yeastRepo.deleteById(id);
        } catch (Exception Ex) {
            throw new HopIdException("Yeast with ID " + id + " doesn't exist");
        }
    }

}
