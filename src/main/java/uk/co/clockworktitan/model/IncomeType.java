package uk.co.clockworktitan.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class

public class IncomeType {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String IncomeTypeName;
    private Integer IncomeTypeWeighting;
    private Integer StressOutcome;
    private Boolean IndexLinked;

    public IncomeType(String IncomeTypeName, Integer IncomeTypeWeighting, Integer StressOutcome, Boolean IndexLinked) {
        this.IncomeTypeName = IncomeTypeName;
        this.IncomeTypeWeighting = IncomeTypeWeighting;
        this.StressOutcome = StressOutcome;
        this.IndexLinked = IndexLinked;
    }

    public IncomeType() {

    }

    @Override
    public String toString() {
        return "IncomeType{" +
                "name='" + IncomeTypeName + '\'' +
                ", Weighting='" + IncomeTypeWeighting + '\'' +
                ", StressOutcome='" + StressOutcome + '\'' +
                ", IndexLinked='" + IndexLinked + '\'' +
                '}';
    }


    public String getIncomeTypeName() {
        return IncomeTypeName;
    }

    public void setIncomeTypeName(String IncomeTypeName) {
        this.IncomeTypeName = IncomeTypeName;
    }


    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }

    public void setIndexLinked(Boolean IndexLinked ) {this.IndexLinked = IndexLinked;}
    public Boolean getIndexLinked()  {return IndexLinked;}



    public Integer getIncomeTypeWeighting() {
        return IncomeTypeWeighting;
    }

    public void setIncomeTypeWeighting(Integer IncomeTypeWeighting) {
        this.IncomeTypeWeighting = IncomeTypeWeighting;
    }

    public Integer getStressOutcome() {
        return StressOutcome;
    }

    public void setStressOutcome(Integer StressOutcome) {
        this.StressOutcome = StressOutcome;
    }


}