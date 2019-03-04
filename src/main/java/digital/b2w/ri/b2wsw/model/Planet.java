package digital.b2w.ri.b2wsw.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
@Table
public class Planet {

    @PrimaryKey
    private String id;

    @NotNull
    private String name;

    @NotNull
    private String climate;

    @NotNull
    private String terrain;

    @NotNull
    private Integer amountMovies;

    public Planet() {
    }

    public Planet(String name, String climate, String terrain, Integer amountMovies) {
        this.name = name;
        this.climate = climate;
        this.terrain = terrain;
        this.amountMovies = amountMovies;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Planet{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", climate='").append(climate).append('\'');
        sb.append(", terrain='").append(terrain).append('\'');
        sb.append(", amountMovies=").append(amountMovies);
        sb.append('}');
        return sb.toString();
    }
}
