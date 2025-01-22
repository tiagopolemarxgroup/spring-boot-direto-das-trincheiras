package academy.devdojo.controllers;

import academy.devdojo.model.Anime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/animes")
public class AnimeController {

    @GetMapping
    public List<Anime> listAll(){
        Anime a1 = new Anime(1L, "Pokemon");
        Anime a2 = new Anime(2L, "Digimon");
        Anime a3 = new Anime(3L, "Pokemon");
        Anime a4 = new Anime(4L, "Pokemon");
        return Arrays.asList(a1, a2, a3, a4);
    }
}
