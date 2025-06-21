import org.example.Utility;
import org.example.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Utility.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Before
    public void setup() {
        PowerMockito.mockStatic(Utility.class);  // Mock static methods
    }

    @Test
    public void testCreateUser() {
        // given
        PowerMockito.when(Utility.generateId()).thenReturn("MOCK_ID");

        //under test
        String result = userService.createUser();

        assertEquals("USER_MOCK_ID", result);
        PowerMockito.verifyStatic(Utility.class, times(1));
        Utility.generateId();
    }

    @Test
    public void testProcess_withMockedStaticMethod() {
        // Arrange
        PowerMockito.mockStatic(Utility.class);
        PowerMockito.when(Utility.getMessage()).thenReturn("Mocked Message");

        UserService service = new UserService();

        // Act
        String result = service.process();

        // Assert
        assertEquals("Mocked Message", result);
    }
}
