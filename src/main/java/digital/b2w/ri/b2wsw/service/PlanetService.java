package digital.b2w.ri.b2wsw.service;

import digital.b2w.ri.b2wsw.model.Planet;
import digital.b2w.ri.b2wsw.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@Service
public class PlanetService {

    @Autowired
    PlanetRepository planetRepository;

    public void initializePlanets(List<Planet> planets) {
        Flux<Planet> savedEmployees = planetRepository.saveAll(planets);
        savedEmployees.subscribe();
    }

    public Flux<Planet> getAllPlanets() {
        Flux<Planet> planets =  planetRepository.findAll();
        return planets;
    }

    public Mono<Planet> getPlanetById(String id) {
        return planetRepository.findById(id);
    }
}