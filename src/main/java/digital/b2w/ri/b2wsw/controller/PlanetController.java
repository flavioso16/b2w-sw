package digital.b2w.ri.b2wsw.controller;

import digital.b2w.ri.b2wsw.model.Planet;
import digital.b2w.ri.b2wsw.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("planet")
public class PlanetController {

    @Autowired
    PlanetService planetService;

    @PostConstruct
    public void salvar() {
        List<Planet> planets = new ArrayList<>();
        planets.add(new Planet("Alderaan", "temperate", "grasslands, mountains", 2));
        planets.add(new Planet("Yavin IV", "temperate, tropical", "jungle, rainforests", 1));
        planetService.initializePlanets(planets);
    }

    @GetMapping("/list")
    public Flux<Planet> getAllPlanets() {
        Flux<Planet> planets = planetService.getAllPlanets();
        return planets;
    }

    @GetMapping("/{id}")
    public Mono<Planet> getPlanetById(@PathVariable String id) {
        return planetService.getPlanetById(id);
    }

//    @GetMapping("/filterByAge/{age}")
//    public Flux<Employee> getEmployeesFilterByAge(@PathVariable int age) {
//        return employeeService.getEmployeesFilterByAge(age);
//    }

    @GetMapping("/teste")
    public String teste() {
        return "ok";
    }
}