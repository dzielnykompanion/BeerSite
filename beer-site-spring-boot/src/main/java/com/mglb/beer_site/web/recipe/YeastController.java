package com.mglb.beer_site.web.recipe;

import com.mglb.beer_site.model.recipe.yeast.Yeast;
import com.mglb.beer_site.service.ErrorMapValidationService;
import com.mglb.beer_site.service.recipe.YeastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("yeast")
public class YeastController {

    @Autowired
    private YeastService yeastService;

    @Autowired
    private ErrorMapValidationService errorMapValidationService;

    @PostMapping("/addYeast")
    public ResponseEntity<?> addOrUpdateYeast (@Valid @RequestBody Yeast yeast, BindingResult result) {

        ResponseEntity<?> errorMap = errorMapValidationService.errorMapValidationService(result);
        if(errorMap != null) return errorMap;

        yeastService.addOrUpdateYeast(yeast);
        return new ResponseEntity<Yeast>(yeast, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        List<Yeast> yeast = yeastService.getAll();
        return new ResponseEntity<List<Yeast>>(yeast, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Yeast yeast = yeastService.findById(id);
        return new ResponseEntity<Yeast>(yeast, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteYeast(@PathVariable Long id) {
        yeastService.deleteYeast(id);
        return new ResponseEntity<String>("Yeast with ID " + id + " has been deleted.", HttpStatus.OK);
    }

}
