package digital.b2w.ri.b2wsw.service;

import digital.b2w.ri.b2wsw.model.Planet;
import digital.b2w.ri.b2wsw.model.PlanetsResponse;
import digital.b2w.ri.b2wsw.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class PlanetService {

    PlanetRepository planetRepository;

    @Autowired
    public PlanetService(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public void initializePlanets(List<Planet> planets) {
        Flux<Planet> savedPlanetFlux = planetRepository.saveAll(planets);
        savedPlanetFlux.subscribe();
    }

    public Flux<Planet> findAll() {
        Flux<Planet> planets =  planetRepository.findAll();
        return planets;
    }

    public Mono<Planet> findById(String id) {
        return planetRepository.findById(id);
    }

    public Flux<Planet> findByName(String name) {
        return planetRepository.findByName(name);
    }

    public void save(Planet planet) {
        Mono<Planet> planetMono = planetRepository.save(planet);
        planetMono.subscribe();
    }

    public void delete(String id) {
        Mono<Void> planetMono = planetRepository.deleteById(id);
        planetMono.subscribe();
    }

    public Flux<List<Planet>> getPlanetsInSwApi() {
        String baseUri = "https://swapi.co/api/planets/";
        Flux<List<Planet>> planetFlux = Flux.create(fluxSink -> swApiCaller(fluxSink, baseUri));
        return planetFlux;
    }

    private void swApiCaller(FluxSink<List<Planet>> fluxSink, String uri) {
        WebClient client = WebClient.create();
        Mono<ClientResponse> result = client.get().uri(uri)
                .accept(MediaType.APPLICATION_JSON)
                .exchange();

        PlanetsResponse response = result.flatMap(res -> res.bodyToMono(PlanetsResponse.class)).block();
        fluxSink.next(response.getResults());

        if (response.getNext() != null) {
            swApiCaller(fluxSink, response.getNext());
        } else {
            fluxSink.complete();
        }
    }
}