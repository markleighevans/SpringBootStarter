package uk.co.clockworktitan.model;
import org.springframework.beans.factory.annotation.Autowired;
import uk.co.clockworktitan.IncomeRepository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity // This tells Hibernate to make a table out of this class

// us

public class Income {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer AffordabilityCaseID;
    private Integer ApplicantNumber;
    private Integer IncomeTypeId;
    private String  IncomeDescription;
    private Integer StressOutcome;
    private Boolean IndexLinked;
    private Integer FromYear;
    private Integer ToYear;
    private Double Amount;

    public Income(Integer IncomeTypeId, Integer AffordabilityCaseID, Integer ApplicantNumber, String  IncomeDescription, Integer StressOutcome, Boolean IndexLinked,  Integer FromYear, Integer ToYear, Double Amount) {
        this.IncomeTypeId = IncomeTypeId;
        this.AffordabilityCaseID = AffordabilityCaseID;
        this.ApplicantNumber = ApplicantNumber;
        this.IncomeDescription = IncomeDescription;
        this.StressOutcome = StressOutcome;
        this.IndexLinked = IndexLinked;
        this.FromYear = FromYear;
        this.ToYear = ToYear;
        this.Amount = Amount;
    }

    public Income() {

    }

    @Override
    public String toString() {
        return "Income{" +
                "id='" + id + '\'' +
                "AffordabilityCaseID='" + AffordabilityCaseID + '\'' +
                "ApplicantNumber='" + ApplicantNumber + '\'' +
                ", IncomeTypeId='" + IncomeTypeId + '\'' +
                ", IncomeDescription='" + IncomeDescription + '\'' +
                ", StressOutcome='" + StressOutcome + '\'' +
                ", IndexLinked='" + IndexLinked + '\'' +
                ", FromYear='" + FromYear + '\'' +
                ", ToYear='" + ToYear + '\'' +
                ", Amount='" + Amount + '\'' +

                '}';
    }


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAffordabilityCaseID() {
        return AffordabilityCaseID;
    }
    public void setAffordabilityCaseID(Integer AffordabilityCaseID ) {
        this.AffordabilityCaseID = AffordabilityCaseID;
    }


    public Integer getApplicantNumber() {
        return ApplicantNumber;
    }
    public void setApplicantNumber(Integer ApplicantNumber ) {
        this.ApplicantNumber = ApplicantNumber;
    }


    public Integer getIncomeTypeId() {
        return IncomeTypeId;
    }
    public void setIncomeTypeId(Integer IncomeTypeId ) {
        this.IncomeTypeId = IncomeTypeId;
    }

    public String getIncomeDescription() {
        return IncomeDescription;
    }
    public void setIncomeDescription(String IncomeDescription) {
        this.IncomeDescription = IncomeDescription;
    }

    public Integer getStressOutcome() {
        return StressOutcome;
    }
    public void setStressOutcome(Integer StressOutcome ) {
        this.StressOutcome = StressOutcome;
    }


    public Boolean getIndexLinked() {
        return IndexLinked;
    }
    public void setIndexLinked(Boolean IndexLinked) {
        this.IndexLinked = IndexLinked;
    }

    public Integer getFromYear() {
        return FromYear;
    }
    public void setFromYear(Integer FromYear) {
        this.FromYear = FromYear;
    }

    public Integer getToYear() {
        return ToYear;
    }
    public void setToYear(Integer ToYear) {
        this.ToYear = ToYear;
    }

    public Double getAmount() {return Amount;}
    public void  setAmount(Double Amount) {this.Amount = Amount;}


}