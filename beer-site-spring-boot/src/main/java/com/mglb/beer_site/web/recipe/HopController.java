package com.mglb.beer_site.web.recipe;

import com.mglb.beer_site.model.recipe.hop.Hop;
import com.mglb.beer_site.service.ErrorMapValidationService;
import com.mglb.beer_site.service.recipe.HopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("hop")
public class HopController {

    @Autowired
    private HopService hopService;

    @Autowired
    private ErrorMapValidationService errorMapValidationService;

    @PostMapping("/addHop")
    public ResponseEntity<?> addOrUpdateHop (@Valid @RequestBody Hop hop, BindingResult result) {

        ResponseEntity<?> errorMap = errorMapValidationService.errorMapValidationService(result);
        if(errorMap != null) return errorMap;

        hopService.addOrUpdateHop(hop);
        return new ResponseEntity<Hop>(hop, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        List<Hop> hops = hopService.getAll();
        return new ResponseEntity<List<Hop>>(hops, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Hop hop = hopService.findById(id);
        return new ResponseEntity<Hop>(hop, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHop(@PathVariable Long id) {
        hopService.deleteHop(id);
        return new ResponseEntity<String>("Hop with ID " + id + " has been deleted.", HttpStatus.OK);
    }

}
