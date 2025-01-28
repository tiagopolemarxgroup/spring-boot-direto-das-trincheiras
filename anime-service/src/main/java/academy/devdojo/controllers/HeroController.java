package academy.devdojo.controllers;

import academy.devdojo.model.Anime;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/heroes")
public class HeroController {
    private static final List<String> HEROES = List.of("Guts", "Zoro", "Kakashi", "Goku");

    Anime anime = new Anime();

    @GetMapping
    public List<String> getHeroes() {
        return HEROES;
    }

    @GetMapping("filter")
    public List<Anime> getHeroesFilter(@RequestParam(defaultValue = "") String name) {
        return Anime.getAnimes();
    }

    @GetMapping("list")
    public List<String> getHeroesFilterList(@RequestParam List<String> names) {
        return HEROES.stream().filter(names::contains).toList();
    }

    @GetMapping("{name}")
    public String getHeroesFilterByName(@PathVariable String name) {
        return HEROES.stream()
                .filter(hero -> hero.equalsIgnoreCase(name))
                .findFirst().orElse("");
    }

//    @GetMapping("/{id}")
//    public Anime findById(@PathVariable Long id) {
//        HEROES.stream().filter(x -> x.equalsIgnoreCase(id)).findFirst();
//        return
//    }

}

