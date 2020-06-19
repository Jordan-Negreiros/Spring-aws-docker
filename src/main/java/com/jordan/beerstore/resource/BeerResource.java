package com.jordan.beerstore.resource;

import com.jordan.beerstore.model.Beer;
import com.jordan.beerstore.repository.Beers;
import com.jordan.beerstore.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/beers")
public class BeerResource {

    private final Beers beers;
    private final BeerService beerService;

    public BeerResource(@Autowired Beers beers, @Autowired BeerService beerService) {
        this.beers = beers;
        this.beerService = beerService;
    }

    @GetMapping
    public List<Beer> all() {
        return beers.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Beer create(@Valid @RequestBody Beer beer) {
        return beerService.save(beer);
    }

    @PutMapping("/{id}")
    public Beer update(@PathVariable Long id,
            @Valid @RequestBody Beer beer) {

        beer.setId(id);
        return beerService.save(beer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        beerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
