package academy.devdojo.controllers;

import academy.devdojo.model.Anime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1/animes")
public class AnimeController {

    @PostMapping
    public ResponseEntity<Anime> create(@RequestBody Anime anime) {
        anime.setId(ThreadLocalRandom.current().nextLong(100_000));
        Anime.getAnimes().add(anime);
        return ResponseEntity.status(HttpStatus.CREATED).body(anime);

    }

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

