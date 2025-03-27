import org.example.OrderProcessor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;

@RunWith(PowerMockRunner.class)
@PrepareForTest(OrderProcessor.class)
public class OrderProcessorTest {

    private OrderProcessor orderProcessor;

    @Before
    public void setup() {
        orderProcessor = PowerMockito.spy(new OrderProcessor());
    }

    @Test
    public void testProcessOrderWithMockedDiscount() throws Exception {
        // Mock
        PowerMockito.doReturn(5.0).when(orderProcessor, "calculateDiscout", 50.0);

        // under test
        double result = orderProcessor.processOrder(50.0);

        assertEquals(45.0, result, 0.01);
        PowerMockito.verifyPrivate(orderProcessor).invoke("calculateDiscout", 50.0);
    }
}
