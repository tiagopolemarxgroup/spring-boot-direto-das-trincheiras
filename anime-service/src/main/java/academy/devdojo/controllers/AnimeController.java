package academy.devdojo.controllers;

import academy.devdojo.model.Anime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1/animes")
public class AnimeController {

    @GetMapping
    public List<Anime> listAll(@RequestParam(required = false) String name){
        var animes = Anime.getAnimes();
        if (name == null) return animes;

       return animes.stream().filter(anime -> anime.getName().equalsIgnoreCase(name)).findFirst().stream().toList();

    }

    @GetMapping("/{id}")
    public Anime findById(@PathVariable Long id){
        Anime animeById = Anime.getAnimes()
                .stream()
                .filter(anime -> anime.getId().equals(id))
                .findFirst().orElse(null);
        return animeById;
    }
}

