package ru.daniel.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.daniel.restapi.entity.Cat;

@Repository
public interface CatRepository extends JpaRepository<Cat, Integer> {
}
