package digital.b2w.ri.b2wsw.controller;

import digital.b2w.ri.b2wsw.model.Planet;
import digital.b2w.ri.b2wsw.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("planet")
public class PlanetController {

    PlanetService planetService;

    @Autowired
    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @GetMapping()
    public Flux<Planet> findAll() {
        return planetService.findAll();
    }

    @PostMapping()
    public void save(@RequestBody @Validated Planet planet) {
        planet.setId(UUID.randomUUID().toString());
        planetService.save(planet);
    }

    @GetMapping("/{id}")
    public Mono<Planet> findById(@PathVariable String id) {
        return planetService.findById(id);
    }

    @GetMapping("/byName/{name}")
    public Flux<Planet> findByName(@PathVariable String name) {
        return planetService.findByName(name);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        planetService.delete(id);
    }

    @GetMapping("/swapi")
    public Flux<List<Planet>> getFromSwApi() {
        return planetService.getPlanetsInSwApi();
    }


}
