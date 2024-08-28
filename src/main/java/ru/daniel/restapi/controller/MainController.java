package ru.daniel.restapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.daniel.restapi.DTO.CatDTO;
import ru.daniel.restapi.entity.Cat;
import ru.daniel.restapi.repository.CatRepository;
import ru.daniel.restapi.service.MailSenderService;

import java.util.List;
import java.util.NoSuchElementException;

@Tag(name = "Main")
@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MainController {

    private final CatRepository catRepository;
    private final MailSenderService mailSenderService;

    @Operation(
            summary = "Add cat to database",
            description = "Get cat DTO and save entity to database with builder",
            method = "POST"
    )
    @PostMapping("/add")
    public Cat addCat(@RequestBody @Valid CatDTO catDTO) {
        Cat newCat = Cat.builder()
                .name(catDTO.getName())
                .age(catDTO.getAge())
                .weight(catDTO.getWeight())
                .build();

        log.info("New row: {}", catRepository.save(newCat));

        return newCat;
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
            log.info("Updating row: {}", catRepository.save(cat));
            return cat;
        }

        throw new NoSuchElementException();
    }

    @GetMapping("/hello")
    public void sayHelloFromCat(@RequestParam int id) {
        var cat = catRepository.findById(id).orElseThrow();

        mailSenderService.sendMail(
                "eclipsemod-post@yandex.ru",
                "Hello from Cats",
                "Hello, my name is " + cat.getName() + "."
        );
    }
}
