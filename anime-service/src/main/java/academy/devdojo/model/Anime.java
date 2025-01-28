package academy.devdojo.model;
import lombok.Data;

import java.util.List;


@Data

public class Anime {
    private Long id;
    private String name;

    public Anime() {}

    public Anime(Long id, String name) {
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

    public static List<Anime> getAnimes(){
        var pok = new Anime(1L, "Pokemon");
        var kaiju = new Anime(1L, "kaiju");
        var digi = new Anime(1L, "kaiju");
        return List.of(pok, kaiju, digi);
    }
}
