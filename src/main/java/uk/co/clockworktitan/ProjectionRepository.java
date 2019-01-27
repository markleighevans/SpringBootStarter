package uk.co.clockworktitan;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uk.co.clockworktitan.model.Projection;

public interface ProjectionRepository extends CrudRepository<Projection, Integer> {


    @Query("SELECT P FROM Projection P WHERE P.AffordabilityCaseID=:AffordabilityCaseID)")
    Iterable <Projection>  findAllByAffordabilityCaseID ( @Param("AffordabilityCaseID") Integer AffordabilityCaseID );

    @Transactional
    @Modifying
    @Query("DELETE  FROM Projection P WHERE P.AffordabilityCaseID=:AffordabilityCaseID)")
    void  deleteByAffordabilityCaseID ( @Param("AffordabilityCaseID") Integer AffordabilityCaseID );



}