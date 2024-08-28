package ru.daniel.restapi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class RestapiApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void concatTests() {
        String stringOne = "Hello ";
        String stringTwo = "World";

        String result = stringOne + stringTwo;

        assertEquals(result, stringOne.concat(stringTwo));
    }

}
