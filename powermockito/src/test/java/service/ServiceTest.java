package service;

import org.example.service.Service;
import org.example.utils.Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Utils.class)
public class ServiceTest {

    @Test
    public void testProcess_with_MockedStaticMethod() {
        //given
        PowerMockito.mockStatic(Utils.class);
        PowerMockito.when(Utils.getTimestamp()).thenReturn("1234567890");

        Service service = new Service();

        //when
        String result = service.process();

        //then
        assertEquals("processed when 1234567890", result);
    }
}
