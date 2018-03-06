package toystore.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class HelloTest {

    @Test
    public void shouldReturnEkachart() {
        Hello hello = new Hello("Ekachart");
        assertEquals("Ekachart", hello.getMessage());
    }

}