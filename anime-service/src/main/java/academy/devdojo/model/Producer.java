package academy.devdojo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Producer {
    private Long id;
    @JsonProperty("full_name")
    private String name;
    private static List<Producer> producers = new ArrayList<Producer>();

    static {
        var mappa = new Producer(1L, "Mappa");
        var kyotoAnimation = new Producer(1L, "kyoto Animation");
        var madhouse = new Producer(1L, "Madhouse");
        producers.addAll(List.of(mappa, kyotoAnimation, madhouse));
    }

    public Producer() {}

    public Producer(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<Producer> getProducers() {
        return producers;
    }
}
