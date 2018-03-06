package toystore.respository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloControllerWithRepository.class)
public class HelloControllerWithRepositoryIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonRepository personRepository;

    @Test
    public void shouldReturnHelloEkachart() throws Exception {
        //Arrange
        Person ekachart = new Person("ekachart", "duangchai");
        given(personRepository.findByFirstName("ekachart"))
                .willReturn(Optional.of(ekachart));

        mockMvc.perform(get("/hello/data/ekachart"))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.message").value("Hello ekachart"));
    }

}