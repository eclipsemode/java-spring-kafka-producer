package ru.daniel.restapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.daniel.restapi.entity.Dog;
import ru.daniel.restapi.repository.DogRepository;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/dogs")
@RequiredArgsConstructor
public class DogController {
    private final DogRepository dogRepository;

    @GetMapping("all")
    public List<Dog> getAll() {
        return dogRepository.findAll();
    }

    @GetMapping("/{name}")
    public ResponseEntity<Dog> getDog(@PathVariable String name) {
        Dog dog = dogRepository.findByName(name);
        if (dog == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(dog);
    }

    @PostMapping
    public Dog addDog(@RequestBody Dog dog) {
        dog.setId(UUID.randomUUID());
        return dogRepository.save(dog);
    }

    @DeleteMapping("/{id}")
    public void deleteDog(@PathVariable UUID id) {
        dogRepository.deleteById(id);
    }

}
