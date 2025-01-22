package academy.devdojo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/heroes")
public class HeroController {
    private static final List<String> HEROES = List.of("Guts", "Zoro", "Kakashi", "Goku");

    @GetMapping
    public List<String> getHeroes() {
        return HEROES;
    }

    @GetMapping("filter")
    public List<String> getHeroesFilter(@RequestParam(defaultValue = "") String name) {
        return HEROES.stream().filter(hero -> hero.equalsIgnoreCase(name)).toList();
    }

    @GetMapping("list")
    public List<String> getHeroesFilterList(@RequestParam List<String> names) {
        return HEROES.stream().filter(names::contains).toList();
    }

}

