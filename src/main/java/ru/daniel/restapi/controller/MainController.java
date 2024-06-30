package ru.daniel.restapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.daniel.restapi.entity.Cat;

@RestController
@RequestMapping("/api/v1")
public class MainController {

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping
    public String getHello() {
        return "Hello World";
    }

    @GetMapping("/cat")
    public String giveCat() {
        Cat cat = new Cat("Barsik", 5, 3.9);
        String jsonData = null;
        try {
            jsonData = objectMapper.writeValueAsString(cat);
        } catch (JsonProcessingException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return jsonData;
    }

    @PostMapping("/special")
    public String giveSpecialCat(@RequestParam String name) {
        Cat cat = new Cat(name, 5, 3.9);
        String jsonData = null;
        try {
            jsonData = objectMapper.writeValueAsString(cat);
        } catch (JsonProcessingException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return jsonData;
    }
}
