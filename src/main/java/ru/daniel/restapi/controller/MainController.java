package ru.daniel.restapi.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.daniel.restapi.entity.Cat;
import ru.daniel.restapi.repository.CatRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MainController {

    private final CatRepository catRepository;

    @PostMapping("/add")
    public Cat addCat(@RequestBody Cat cat) {
        log.info("New row: " + catRepository.save(cat));
        return cat;
    }

    @GetMapping("/all")
    public List<Cat> getAllCats() {
        return catRepository.findAll();
    }

    @GetMapping
    public Cat getCatById(@RequestParam int id) {
        return catRepository.findById(id).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void deleteCat(@PathVariable int id) {
        catRepository.deleteById(id);
    }

    @PutMapping
    public Cat updateCat(@RequestBody Cat cat) {
        if (catRepository.existsById(cat.getId())) {
            log.info("Updating row: " + catRepository.save(cat));
            return cat;
        }

        throw new NoSuchElementException();
    }
}
