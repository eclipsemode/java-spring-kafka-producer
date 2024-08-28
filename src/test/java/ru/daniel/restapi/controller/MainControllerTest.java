package ru.daniel.restapi.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.daniel.restapi.entity.Cat;
import ru.daniel.restapi.repository.CatRepository;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MainControllerTest {

    @Mock
    private CatRepository catRepository;

    @InjectMocks
    private MainController mainController;

    @Test
    void updateCatFailed() {
        int catId = 1;
        Cat cat = new Cat();
        cat.setId(catId);

        when(catRepository.existsById(catId))
                .thenReturn(false);

        assertThrows(NoSuchElementException.class, () -> mainController.updateCat(cat));
    }

    @Test
    void updateCatSuccess() {
        int catId = 1;
        Cat cat = new Cat();
        cat.setId(catId);
        cat.setName("Barsik");

        when(catRepository.existsById(catId))
                .thenReturn(true);
        when(catRepository.save(cat))
                .thenReturn(cat);

        assertEquals(cat, mainController.updateCat(cat));
    }
}
