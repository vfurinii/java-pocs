import org.java.Main;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
public class IntegrationControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void sayHello_ReturnsGreeting() throws Exception {
        mockMvc.perform(get("/api/integration/John"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, John!"));
    }
}
