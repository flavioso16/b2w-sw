package digital.b2w.ri.b2wsw.repository;

import digital.b2w.ri.b2wsw.model.Planet;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface PlanetRepository extends ReactiveCassandraRepository<Planet, String> {

    @AllowFiltering
    Flux<Planet> findByName(String name);

}