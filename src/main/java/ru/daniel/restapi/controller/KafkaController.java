package ru.daniel.restapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.daniel.restapi.entity.Cat;
import ru.daniel.restapi.kafka.KafkaProducer;
import ru.daniel.restapi.repository.CatRepository;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaProducer kafkaProducer;
    private final CatRepository catRepository;

    @GetMapping("/send")
    public String sendMessage(
            @RequestParam int id,
            @RequestParam String topic
    ) {
        Cat cat = catRepository.findById(id).orElseThrow();
        kafkaProducer.sendMessage(topic, cat.toString());
        return "Successfully sent message: " + cat;
    }

}
