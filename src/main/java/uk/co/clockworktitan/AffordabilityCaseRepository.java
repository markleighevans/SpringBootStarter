package uk.co.clockworktitan;

import org.springframework.data.repository.CrudRepository;
import uk.co.clockworktitan.model.AffordabilityCase;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AffordabilityCaseRepository extends CrudRepository<AffordabilityCase, Integer> {

    @Query("SELECT A FROM AffordabilityCase A WHERE A.originatingQuoteID=:originatingQuoteID)")
    AffordabilityCase findOneByoriginatingQuoteID ( @Param("originatingQuoteID") Integer originatingQuoteID );


}