package digital.b2w.ri.b2wsw.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table
public class Planet {

    @PrimaryKey
    private String id = UUID.randomUUID().toString();

    private String name;

    private String climate;

    private String terrain;

    private Integer amountMovies;

    public Planet() { }

    public Planet(String name, String climate, String terrain, Integer amountMovies) {
        this.name = name;
        this.climate = climate;
        this.terrain = terrain;
        this.amountMovies = amountMovies;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getClimate() {
        return climate;
    }

    public String getTerrain() {
        return terrain;
    }

    public Integer getAmountMovies() {
        return amountMovies;
    }
}
