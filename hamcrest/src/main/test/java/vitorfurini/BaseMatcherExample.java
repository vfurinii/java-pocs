package java.vitorfurini;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.sameInstance;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;

public class BaseMatcherExample {

    @Test
    public void testEqualTo() {
        String name = "Vitor";

        assertThat(name, equalTo("Vitor"));
        assertThat(10, equalTo(10));
        assertThat(5.0, equalTo(5.0));
    }

    @Test
    public void testIs() {
        String name = "Vitor";

        assertThat(name, is("Vitor"));
        assertThat(5 + 5, is(10));
        assertThat(true, is(true));
    }

    @Test
    public void testNot() {
        assertThat("Java", not(equalTo("Python")));
        assertThat(42, not(0));
        assertThat(false, not(true));
    }

    @Test
    public void testNullMatchers() {
        String name = "Vitor";

        assertThat(null, nullValue());
        assertThat(name, notNullValue());
    }

    @Test
    public void testSameInstance() {
        String a = "Hello";
        String b = a;
        String c = new String("Hello");

        assertThat(a, sameInstance(b));
        //assertThat(a, sameInstance(c)); //fail (same content but, different instance)
    }

    @Test
    public void testAnyOf() {
        int number = 5;

        assertThat(number, anyOf(is(3), is(4), is(5)));
    }

    @Test
    public void testAllOf() {
        String text = "Hamcrest Matchers";

        assertThat(text, allOf(startsWith("Ham"), containsString("Match")));
    }
}
