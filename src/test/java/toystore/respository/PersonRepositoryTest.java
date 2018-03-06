package toystore.respository;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonRepositoryTest {

    @Autowired
    private  PersonRepository personRepository;

    @After
    public void clearData() {
        personRepository.deleteAll();
    }

    @Test
    public void shouldSaveAndGetData() throws Exception {
        Person ekachart = new Person("ekachart", "duangchai");
        personRepository.save(ekachart);

        Optional<Person> shouldEkachart = personRepository.findByFirstName("ekachart");

        assertEquals("ekachart",  shouldEkachart.get().getFirstName());
        assertEquals("duangchai", shouldEkachart.get().getLastName());
    }
}


