package academy.devdojo.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ThreadLocalRandom;
@Slf4j
@RestController
@RequestMapping(value = "v1/greetings")
public class HelloController {
    @GetMapping(value = "/hi")
    public String hi(){
        return "Hi Anime";
    }
    @PostMapping
    public Long save(@RequestBody String name){
        log.info("Saving {}", name);
        return ThreadLocalRandom.current().nextLong(1, 1000);
    }
}
