package academy.devdojo.controllers;

import academy.devdojo.model.Producer;
import academy.devdojo.request.ProducerPostRequest;
import academy.devdojo.response.ProducerGetResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.fasterxml.jackson.databind.util.ClassUtil.name;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1/producers")
public class ProducerController {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, headers = "x-api-key=123")
    public ResponseEntity<ProducerGetResponse> create(@RequestBody ProducerPostRequest request, @RequestHeader HttpHeaders headers) {
        log.info("{}", headers);
        var producer = Producer.builder().id(ThreadLocalRandom.current().nextLong(100_000)).name(request.getName()).createdAt(LocalDateTime.now()).build();
        Producer.getProducers().add(producer);

        var res = ProducerGetResponse.builder().id(ThreadLocalRandom.current().nextLong(100_000))
                .name(request.getName())
                .createdAt(LocalDateTime.now()).build();

        return ResponseEntity.status(HttpStatus.CREATED).body(res);

    }

    @GetMapping
    public ResponseEntity<List<Producer>> listAll(@RequestParam(required = false) String name){
        var producers = Producer.getProducers();
        if (name == null) return ResponseEntity.ok(producers);
        var res = producers.stream().filter(producer -> producer.getName().equalsIgnoreCase(name)).findFirst().stream().toList();
        return ResponseEntity.ok(res);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producer> findById(@PathVariable Long id){
        Producer producerById = Producer.getProducers()
                .stream()
                .filter(producer -> producer.getId().equals(id))
                .findFirst().orElse(null);
        return ResponseEntity.ok(producerById);
    }
}

