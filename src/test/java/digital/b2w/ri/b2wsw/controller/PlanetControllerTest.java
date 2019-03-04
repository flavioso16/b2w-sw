package digital.b2w.ri.b2wsw.controller;

import digital.b2w.ri.b2wsw.model.Planet;
import digital.b2w.ri.b2wsw.service.PlanetService;
import org.junit.Before;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlanetControllerTest {

    private PlanetController planetController;
    private PlanetService planetService;

    @Before
    public void setUp() {
        planetService = mock(PlanetService.class);
        planetController = new PlanetController(planetService);
    }

    @Test
    public void findAll() {
        when(planetService.findAll()).thenReturn(Flux.just(
                new Planet("Alderaan", "temperate", "grasslands, mountains", 2),
                new Planet("Yavin IV", "temperate, tropical", "jungle, rainforests", 1)
        ));
        Flux<Planet> planets = planetController.findAll();

        assertEquals(new Long(2), planets.count().block());
    }

    @Test
    public void save() {
        planetController.save(new Planet("Alderaan", "temperate", "grasslands, mountains", 2));
    }

    @Test
    public void findById() {
        Planet planetMock = new Planet("Alderaan", "temperate", "grasslands, mountains", 2);
        planetMock.setId("ID_MOCK");
        when(planetService.findById(anyString())).thenReturn(Mono.just(planetMock));

        Mono<Planet> planet = planetController.findById("ID_MOCK");

        assertEquals("ID_MOCK", planet.block().getId());
    }

    @Test
    public void findByName() {
        Planet planetMock = new Planet("Alderaan", "temperate", "grasslands, mountains", 2);
        planetMock.setId("ID_MOCK");
        when(planetService.findById(anyString())).thenReturn(Mono.just(planetMock));

        Mono<Planet> planet = planetController.findById("ID_MOCK");

        assertEquals("ID_MOCK", planet.block().getId());
    }

    @Test
    public void delete() {
        planetController.delete("ID_MOCK");
    }

    @Test
    public void getFromSwApi() {
        Flux<List<Planet>> planetsMock = Flux.just(
                Arrays.asList(
                        new Planet("Alderaan", "temperate", "grasslands, mountains", 2),
                        new Planet("Yavin IV", "temperate, tropical", "jungle, rainforests", 1)
                )
        );
        when(planetService.getPlanetsInSwApi()).thenReturn(planetsMock);

        Flux<List<Planet>> planets = planetController.getFromSwApi();

        assertEquals(2, planets.blockFirst().size());
    }
}