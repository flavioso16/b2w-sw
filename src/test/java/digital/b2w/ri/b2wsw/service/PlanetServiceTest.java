package digital.b2w.ri.b2wsw.service;

import digital.b2w.ri.b2wsw.model.Planet;
import digital.b2w.ri.b2wsw.repository.PlanetRepository;
import org.junit.Before;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlanetServiceTest {

    private PlanetService planetService;
    private PlanetRepository planetRepository;

    @Before
    public void setUp() {
        planetRepository = mock(PlanetRepository.class);
        planetService = new PlanetService(planetRepository);
    }

    @Test
    public void findAll() {
        when(planetRepository.findAll()).thenReturn(Flux.just(
                new Planet("Alderaan", "temperate", "grasslands, mountains", 2),
                new Planet("Yavin IV", "temperate, tropical", "jungle, rainforests", 1)
        ));
        Flux<Planet> planets = planetService.findAll();

        assertEquals(new Long(2), planets.count().block());
    }

    @Test
    public void findById() {
        Planet planetMock = new Planet("Alderaan", "temperate", "grasslands, mountains", 2);
        planetMock.setId("ID_MOCK");
        when(planetRepository.findById(anyString())).thenReturn(Mono.just(planetMock));

        Mono<Planet> planet = planetService.findById("ID_MOCK");

        assertEquals("ID_MOCK", planet.block().getId());
    }

    @Test
    public void findByName() {
        Planet planetMock = new Planet("Alderaan", "temperate", "grasslands, mountains", 2);
        planetMock.setId("ID_MOCK");
        when(planetRepository.findById(anyString())).thenReturn(Mono.just(planetMock));

        Mono<Planet> planet = planetService.findById("ID_MOCK");

        assertEquals("ID_MOCK", planet.block().getId());
    }

    @Test
    public void save() {
        planetService.save(new Planet("Alderaan", "temperate", "grasslands, mountains", 2));
    }

    @Test
    public void delete() {
        planetService.delete("ID_MOCK");
    }

    @Test
    public void getPlanetsInSwApi() {
        Flux<List<Planet>> planets = planetService.getPlanetsInSwApi();

        assertEquals(10, planets.blockFirst().size());
    }
}