package ru.daniel.restapi.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cat {
    @NonNull private String name;
    private int age;
    private double weight;
}
