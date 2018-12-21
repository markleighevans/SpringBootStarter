package uk.co.clockworktitan.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class

public class Income {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer AffordabilityCaseID;
    private Integer IncomeTypeId;
    private String  IncomeDescription;
    private Integer StressOutcome;
    private Date FromDate;
    private Date ToDate;
    private Double Amount;

    public Income(Integer IncomeTypeId, Integer AffordabilityCaseID, String  IncomeDescription, Integer StressOutcome,  Date FromDate, Date ToDate, Double Amount) {
        this.IncomeTypeId = IncomeTypeId;
        this.AffordabilityCaseID = AffordabilityCaseID;
        this.IncomeDescription = IncomeDescription;
        this.StressOutcome = StressOutcome;
        this.FromDate = FromDate;
        this.ToDate = ToDate;
        this.Amount = Amount;
    }

    public Income() {

    }

    @Override
    public String toString() {
        return "Income{" +
                "id='" + id + '\'' +
                "AffordabilityCaseID='" + AffordabilityCaseID + '\'' +
                ", IncomeTypeId='" + IncomeTypeId + '\'' +
                ", IncomeDescription='" + IncomeDescription + '\'' +
                ", StressOutcome='" + StressOutcome + '\'' +
                ", FromDate='" + FromDate + '\'' +
                ", ToDate='" + ToDate + '\'' +
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


    public Date getFromDate() {
        return FromDate;
    }
    public void setFromDate(Date FromDate) {
        this.FromDate = FromDate;
    }

    public Date getToDate() {
        return ToDate;
    }
    public void setToDate(Date ToDate) {
        this.ToDate = ToDate;
    }

    public Double getAmount() {return Amount;}
    public void  setAmount(Double Amount) {this.Amount = Amount;}

}