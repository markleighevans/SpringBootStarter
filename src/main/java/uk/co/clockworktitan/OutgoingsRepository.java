package uk.co.clockworktitan;

import org.springframework.data.repository.CrudRepository;
import uk.co.clockworktitan.model.Outgoings;

public interface OutgoingsRepository extends CrudRepository<Outgoings, Integer> {

}