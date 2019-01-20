package uk.co.clockworktitan;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import uk.co.clockworktitan.model.Income;


public interface IncomeRepository extends CrudRepository<Income, Integer> {


    @Query("SELECT I FROM Income I WHERE I.AffordabilityCaseID=:AffordabilityCaseID)")
    Iterable <Income>  findAllByAffordabilityCaseID ( @Param("AffordabilityCaseID") Integer AffordabilityCaseID );

    @Query("SELECT I FROM Income I WHERE I.AffordabilityCaseID=:AffordabilityCaseID and :ProjectionYear >= I.FromYear and  :ProjectionYear <= I.ToYear )")
    Iterable <Income>  findAllByAffordabilityCaseIDandYear ( @Param("AffordabilityCaseID") Integer AffordabilityCaseID, @Param("ProjectionYear") Integer ProjectionYear );

}