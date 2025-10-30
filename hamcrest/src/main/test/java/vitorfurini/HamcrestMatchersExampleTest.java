package java.vitorfurini;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.number.OrderingComparison.*;
public class HamcrestMatchersExampleTest {


    @Test
    public void testCoreMatchers() {
        String name = "Vitor Furini";

        assertThat(name, is("Vitor Furini"));
        assertThat(name, not("Yudi Tamashiro"));
        assertThat(name, containsString("Furini"));
        assertThat(name, startsWith("Vitor"));
        assertThat(name, endsWith("Furini"));
        assertThat(name, anyOf(containsString("Vitor"), containsString("Garcia")));
    }

    @Test
    public void testCollectionMatchers() {
        List<String> fruits = Arrays.asList("apple", "banana", "orange");

        assertThat(fruits, hasSize(3));
        assertThat(fruits, hasItem("banana"));
        assertThat(fruits, containsInAnyOrder("orange", "apple", "banana"));
        assertThat(fruits, everyItem(not(isEmptyOrNullString())));
    }

    @Test
    public void testNumberMatchers() {
        int age = 30;

        assertThat(age, greaterThan(18));
        assertThat(age, lessThan(40));
        assertThat(age, greaterThanOrEqualTo(30));
    }
}
