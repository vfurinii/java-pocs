package com.vitorfurini.converter;

import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.vitorfurini.junit.calculator.Person;

public class PersonConverter extends SimpleArgumentConverter {
    @Override
    protected Object convert(Object source, Class<?> targetType) {
        if (!(source instanceof String) || targetType != Person.class) {
            throw new IllegalArgumentException("Conversion error: Expected a semicolon-separated string");
        }

        String[] parts = ((String) source).split(";");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid format: Expected 'name;age'");
        }

        String name = parts[0].trim();
        int age = Integer.parseInt(parts[1].trim());
        return new Person(name, age);
    }
}
