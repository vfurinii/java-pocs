import org.example.Main;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.api.mockito.PowerMockito;

import static org.junit.Assert.assertEquals;


@RunWith(PowerMockRunner.class) // Use PowerMockRunner
@PrepareForTest(Main.class)
public class AssertionsExamplesTest {

    @Test
    public void testPublicMethodAssertions() {
        // Mock the static metho
        PowerMockito.mockStatic(Main.class);

        // Define behavior when calling Main.square(5)
        Mockito.when(Main.square(5)).thenReturn(25);

        // Verify mocked behavior
        assertEquals(25, Main.square(5));

        // Verify that the method was actually called
        PowerMockito.verifyStatic(Main.class, Mockito.times(1));
        Main.square(5);
    }

    //test calling a private method through public method
    @Test
    public void testPrivateMethod() throws Exception {
        // Create a spy instance of the class
        Main spy = PowerMockito.spy(new Main());

        // Mock the private method
        PowerMockito.when(spy, "calculateSecretValue", 5).thenReturn(42);

        // Call the public method, which internally calls the private method
        int result = spy.publicMethod(5);

        assertEquals(42, result);
    }

}
