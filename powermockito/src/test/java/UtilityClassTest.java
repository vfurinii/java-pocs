import org.example.UtilityClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UtilityClass.class)
public class UtilityClassTest {

    @Test
    public void testStaticMethodWithPowerMockito() {
        PowerMockito.mockStatic(UtilityClass.class);
        // given
        when(UtilityClass.getGreeting("João")).thenReturn("Mocked Hello");

        // when
        String result = UtilityClass.getGreeting("João");

        // then
        assertEquals("Mocked Hello", result);
        PowerMockito.verifyStatic(UtilityClass.class);
        UtilityClass.getGreeting("João");
    }
}


