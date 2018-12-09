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
    private Integer IncomeTypeId;
    private String  IncomeDescription;
    private Date FromDate;
    private Date ToDate;
    private Double Amount;

    public Income(Integer IncomeTypeId,String  IncomeDescription, Date FromDate, Date ToDate, Double Amount) {
        this.IncomeTypeId = IncomeTypeId;
        this.IncomeDescription = IncomeDescription;
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
                ", IncomeTypeId='" + IncomeTypeId + '\'' +
                ", IncomeDescription='" + IncomeDescription + '\'' +
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