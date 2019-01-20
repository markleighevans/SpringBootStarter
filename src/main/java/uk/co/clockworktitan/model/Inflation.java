package uk.co.clockworktitan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class

public class Inflation {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer inflationYear;
    private Double inflation;


    public Inflation(Integer ID, Integer inflationYear, Double inflation) {
        this.id = ID;
        this.inflationYear = inflationYear;
        this.inflation = inflation;
    }

    public Inflation() {

    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                "inflationYear='" + inflationYear + '\'' +
                ", inflation='" + inflation + '\'' +
                '}';
    }


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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


}