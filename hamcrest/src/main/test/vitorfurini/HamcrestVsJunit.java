package vitorfurini;

import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;
import org.vitorfurini.hamcrest.StartsWithVowel;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
//Junit
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.AllOf.allOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HamcrestVsJunit {

    List<String> names = List.of("Alice", "Bob", "Charlie");

    @Test
    void testListSize() {
        assertEquals(3, names.size());
        assertTrue(names.contains("Bob"));
    }

    @Test
    void testListSizeWithHamcrest() {
        assertThat(names, hasSize(3));
        assertThat(names, hasItem("Bob"));

        assertThat(names, allOf((Matcher<? super List<String>>) hasSize(3), hasItem("Alice")));
        Integer result = 5;
        assertThat(result, anyOf(is(5), greaterThan(10)));
    }

    @Test
    void testListSizeWithHamcrestAndVowel() {
        assertThat(names, hasSize(3));
        assertThat(names, hasItem("Bob"));

        assertThat(names, allOf((Matcher<? super List<String>>) hasSize(3), hasItem("Alice")));
        Integer result = 5;
        assertThat(result, anyOf(is(5), greaterThan(10)));
        assertThat("Alice", new StartsWithVowel());
    }
}
