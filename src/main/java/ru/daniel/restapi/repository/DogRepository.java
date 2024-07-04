package ru.daniel.restapi.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.daniel.restapi.entity.Dog;

import java.util.UUID;

@Repository
public interface DogRepository extends MongoRepository<Dog, UUID> {
    Dog findByName(String name);
}
