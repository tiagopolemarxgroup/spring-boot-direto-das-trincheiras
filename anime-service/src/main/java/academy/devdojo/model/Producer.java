package academy.devdojo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Builder
@Getter
@Setter
public class Producer {
    private Long id;
    @JsonProperty("full_name")
    private String name;
    private LocalDateTime createdAt;
    private static List<Producer> producers = new ArrayList<Producer>();

    static {
        var mappa = Producer.builder().id(1L).name("Mappa").createdAt(LocalDateTime.now()).build();
        var kyotoAnimation = Producer.builder().id(2L).name("kyoto Animation").createdAt(LocalDateTime.now()).build();
        var madhouse = Producer.builder().id(3L).name("Madhouse").createdAt(LocalDateTime.now()).build();
        producers.addAll(List.of(mappa, kyotoAnimation, madhouse));
    }

    public Producer() {
    }

    public Producer(Long id, String name, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
    }

    public static List<Producer> getProducers() {
        return producers;
    }

        public String toString() {
            return "Producer.ProducerBuilder(id=" + this.id + ", name=" + this.name + ", createdAt=" + this.createdAt + ")";
        }

}
