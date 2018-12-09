package uk.co.clockworktitan;

import org.springframework.data.repository.CrudRepository;
import uk.co.clockworktitan.model.Income;

public interface IncomeRepository extends CrudRepository<Income, Integer> {

}