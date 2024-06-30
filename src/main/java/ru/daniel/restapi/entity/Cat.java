package ru.daniel.restapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "cats")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    @Column(unique = true)
    private String name;

    private int age;

    @Column(name = "mass", nullable = false)
    private double weight;

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}
