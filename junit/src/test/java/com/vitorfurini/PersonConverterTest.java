package com.vitorfurini;

import com.vitorfurini.converter.PersonConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import org.vitorfurini.junit.calculator.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonConverterTest {

    /*O uso de conversor no jUnit5 pode ser aplicado em varios contextos, principalemente quando precisamos converter
    dados recebidos em uma API para objetos do sistema */

    @ParameterizedTest
    @CsvSource({
            "Vitor;29, Vitor, 29",
            "Gabriela;28, Gabriela, 28",
            "Bernardo;11, Bernardo, 11",
            "Vicenzo;9, Vicenzo, 9"
    })
    void testPersonConversion(@ConvertWith(PersonConverter.class) Person person, String expectedName, int expectedAge) {
        assertEquals(expectedName, person.getName());
        assertEquals(expectedAge, person.getAge());
    }
}
