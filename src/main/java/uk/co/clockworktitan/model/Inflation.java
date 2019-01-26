package uk.co.clockworktitan.model;
import org.springframework.beans.factory.annotation.Autowired;
import uk.co.clockworktitan.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity // This tells Hibernate to make a table out of this class
@Table(uniqueConstraints={
        @UniqueConstraint(columnNames = {"inflationYear"})
})

public class Inflation {
    @Autowired
    private static InflationRepository _InflationRepository;
    //@GeneratedValue(strategy=GenerationType.AUTO)
    //private Integer id;
    @Id
    private Integer inflationYear;
    private Double inflation;
    //private List <Inflation> _InflationList;

    public Inflation( Integer inflationYear, Double inflation) {
        //this.id = ID;
        this.inflationYear = inflationYear;
        this.inflation = inflation;
    }

    public Inflation() {

    }

    @Override
    public String toString() {
        return "Inflation{" +
                "inflationYear='" + inflationYear + '\'' +
                ", inflation='" + inflation + '\'' +
                '}';
    }

    public Integer getinflationYear() {
        return inflationYear;
    }
    public void setinflationYear(Integer inflationYear) {
        this.inflationYear = inflationYear;
    }

    public Double getinflation() { return inflation;  }
    public void setinflation(Double inflation) {
        this.inflation = inflation;
    }

    public  Double getInflationBetweenYears (Integer  StartYear, Integer EndYear)
    {
        Integer YearIterator = StartYear;
        Double YearAmount = 0.0;
        Double TotalAmount = 1.0;
        while (YearIterator <= EndYear )
        {
            ////////////////////////////////////////////////////////
            Iterable <Inflation> _Inflation  = _InflationRepository.findAllByInflationYear( YearIterator);
            Iterator<Inflation> _InflationIterator = _Inflation.iterator();
            YearAmount = 0.0;
            while (_InflationIterator.hasNext())
            {
                Inflation InflationRecord = _InflationIterator.next();
                YearAmount = YearAmount + InflationRecord.getinflation();
                //TODO - this will return the wrong value in the event of duplicate records (need to set constraints on table)

            }
            System.out.println("Year: "+ YearIterator + " YearAmount: " + YearAmount);

            TotalAmount = TotalAmount+ ((YearAmount/100) * TotalAmount);
            ///////////////////////////////////////////////////////
            YearIterator++;
        }
        System.out.println("Total Inflation Between Years"+ StartYear + " - " + EndYear + "=" + TotalAmount);

        return TotalAmount;
    }



}

