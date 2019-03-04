package digital.b2w.ri.b2wsw.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanetsResponse {

    private Integer count;
    private String next;
    private List<Planet> results;

    public PlanetsResponse() {
    }

    public PlanetsResponse(Integer count, String next, List<Planet> results) {
        this.count = count;
        this.next = next;
        this.results = results;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public List<Planet> getResults() {
        return results;
    }

    public void setResults(List<Planet> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PlanetsResponse{");
        sb.append("count=").append(count);
        sb.append(", next='").append(next).append('\'');
        sb.append(", results=").append(results);
        sb.append('}');
        return sb.toString();
    }
}
