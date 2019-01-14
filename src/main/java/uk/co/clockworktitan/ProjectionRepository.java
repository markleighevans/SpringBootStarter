package uk.co.clockworktitan;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import uk.co.clockworktitan.model.Projection;

public interface ProjectionRepository extends CrudRepository<Projection, Integer> {


    @Query("SELECT P FROM Projection P WHERE P.AffordabilityCaseID=:AffordabilityCaseID)")
    Iterable <Projection>  findAllByAffordabilityCaseID ( @Param("AffordabilityCaseID") Integer AffordabilityCaseID );


}