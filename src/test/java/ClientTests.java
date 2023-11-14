import com.fasterxml.jackson.databind.ObjectMapper;
import com.fityogimom.Application;
import com.fityogimom.dao.ClientDao;
import com.fityogimom.entities.Client;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Application.class)
@AutoConfigureMockMvc
public class ClientTests {

    @Value(value="${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ClientDao clientDao;

    private Client testClient;


    @BeforeEach
    public void setupTestData() {

        testClient = new Client();
        testClient.setName("John TestClient");
        testClient.setEmail("john@testEmail.com");
        clientDao.createClient(testClient);
    }

    @AfterEach
    public void cleanUpTestData(){
        if(testClient != null) {
            clientDao.deleteClient(testClient.getId());
        }
    }

    @Test
    public void testCreateClient() throws Exception {
        Client client = Client.builder()
                .name("John TestClient")
                .email("test@test.com")
                .phone("1234567890")
                .clientNote("This client was made as a test, it should be deleted!")
                .build();

        mockMvc.perform(MockMvcRequestBuilders.post("/client/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(client)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }


    @Test
    public void testGetClient() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/client/get")
                        .param("name", "John TestClient")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("John TestClient"))
                .andReturn();

    }

    @Test
    public void testGetAllClients() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/client")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").exists())
                .andReturn();

    }

    @Test
    public void testGetMultipleClients() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/client/list")
                        .param("name", "John TestClient")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").exists())
                .andReturn();
    }
    @Test
    public void testGetAllVideos() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/video")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").exists())
                .andReturn();

    }
    @Test
    public void testGetAllPrompts() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/prompt")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").exists())
                .andReturn();

    }
}


