package uk.co.clockworktitan;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import uk.co.clockworktitan.model.DefaultOutgoings;

public interface DefaultOutgoingsRepository extends CrudRepository<DefaultOutgoings, Integer> {




}