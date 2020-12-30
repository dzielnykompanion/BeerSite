package com.mglb.beer_site.web.recipe;

import com.mglb.beer_site.model.recipe.hop.Hop;
import com.mglb.beer_site.service.HopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hop")
public class HopController {

    @Autowired
    private HopService hopService;

    @PostMapping("/addHop")
    public ResponseEntity<?> addOrUpdateHop (@RequestBody Hop hop) {
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
