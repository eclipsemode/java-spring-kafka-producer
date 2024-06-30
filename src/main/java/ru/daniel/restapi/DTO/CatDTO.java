package ru.daniel.restapi.DTO;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CatDTO {
    String name;
    int age;
    Double weight;
}
