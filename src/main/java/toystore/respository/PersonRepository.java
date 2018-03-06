package toystore.respository;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, String>{

    Optional<Person> findByFirstName(String name);
}
