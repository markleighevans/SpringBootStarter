package uk.co.clockworktitan;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import uk.co.clockworktitan.model.Income;
import uk.co.clockworktitan.model.Outgoings;

public interface OutgoingsRepository extends CrudRepository<Outgoings, Integer> {


    @Query("SELECT O FROM Outgoings O WHERE O.AffordabilityCaseID=:AffordabilityCaseID)")
    Iterable <Outgoings>  findAllByAffordabilityCaseID (@Param("AffordabilityCaseID") Integer AffordabilityCaseID );


}