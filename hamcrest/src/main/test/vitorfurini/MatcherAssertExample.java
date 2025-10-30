package vitorfurini;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MatcherAssertExample {

    @Test
    public void example() {
        String name = "Vitor";

        assertThat(name, is("Vitor"));

        assertThat(name, is("João")); //should fail
    }
}
