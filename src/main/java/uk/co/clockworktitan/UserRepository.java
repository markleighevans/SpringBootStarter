package uk.co.clockworktitan;
import org.springframework.data.repository.CrudRepository;
import uk.co.clockworktitan.model.*;

public interface UserRepository extends CrudRepository<User, Integer> {

}