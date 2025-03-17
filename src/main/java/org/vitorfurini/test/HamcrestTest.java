package org.vitorfurini.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.startsWith;

import org.testng.annotations.Test;
import org.vitorfurini.main.Person;

public class HamcrestTest {

    @Test
    public void testBasicMatchers() {
        // Testando valores numéricos
        assertThat(5, is(5)); // Verify if 5 is equal to 5
        assertThat(10, is(not(5))); // Verify if 10 not equal to 5
        assertThat(5, greaterThan(3)); // Verify if 5 is bigger than 3
        assertThat(3, lessThan(10)); // Verify if 3 is lower than 10
    }

    @Test
    public void testStringMatchers() {
        // Testando strings
        String str = "Hello Hamcrest";
        assertThat(str, containsString("Hamcrest")); // Verify if a string has "Hamcrest"
        assertThat(str, startsWith("Hello")); // Verify if string starts with "Hello"
        assertThat(str, endsWith("Hamcrest")); // Verify if string ends with "Hamcrest"
        assertThat(str, is(not(emptyString()))); // Verify if string not empty
    }

    @Test
    public void testCollectionMatchers() {
        // Testando listas
        assertThat(java.util.Arrays.asList(1, 2, 3), hasSize(3)); // Verify the  list size
        assertThat(java.util.Arrays.asList(1, 2, 3), hasItem(2)); // Verify if the list contains the item "2"
        assertThat(java.util.Arrays.asList(1, 2, 3), containsInAnyOrder(3, 1, 2)); // Verify if contains all items, in any order sequence
    }

    @Test
    public void testObjectMatchers() {
        // Testando objetos
        Person person = new Person("John", 30);
        assertThat(person.getName(), is("John")); // Verify object name
        assertThat(person.getAge(), greaterThan(20)); // Verify object age
    }
}
