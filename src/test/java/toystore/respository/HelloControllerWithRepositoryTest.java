package toystore.respository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import toystore.domain.Hello;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.initMocks;

public class HelloControllerWithRepositoryTest {

    private HelloControllerWithRepository controllerWithRepository;

    @Mock
    private PersonRepository personRepository;

    @Before
    public void init() {
        initMocks(this);
        controllerWithRepository = new HelloControllerWithRepository(personRepository);
    }

    @Test
    public void shouldReturnHelloEkachart() {
        //Arrange
        Person ekachart = new Person("ekachart", "duangchai");
        given(personRepository.findByFirstName("ekachart"))
                .willReturn(Optional.of(ekachart));

        //Action
        Hello hello = controllerWithRepository.sayHi("ekachart");

        //Assert
        assertEquals("Hello ekachart", hello.getMessage());
    }

}