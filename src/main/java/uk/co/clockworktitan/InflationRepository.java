package uk.co.clockworktitan;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import uk.co.clockworktitan.model.Income;
import uk.co.clockworktitan.model.Inflation;


public interface InflationRepository extends CrudRepository<Inflation, Integer> {



    @Query("SELECT I FROM Inflation I WHERE :ProjectionYear = I.inflationYear )")
    Iterable <Inflation>  findAllByInflationYear(@Param("ProjectionYear") Integer ProjectionYear);

}