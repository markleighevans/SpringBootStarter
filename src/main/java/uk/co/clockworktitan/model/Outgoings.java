package uk.co.clockworktitan.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class

public class Outgoings {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer OutgoingsTypeId;
    private String  OutgoingsDescription;
    private Date FromDate;
    private Date ToDate;
    private Double Amount;

    public Outgoings(Integer OutgoingsTypeId, String  OutgoingsDescription, Date FromDate, Date ToDate, Double Amount) {
        this.OutgoingsTypeId = OutgoingsTypeId;
        this.OutgoingsDescription = OutgoingsDescription;
        this.FromDate = FromDate;
        this.ToDate = ToDate;
        this.Amount = Amount;
    }

    public Outgoings() {

    }

    @Override
    public String toString() {
        return "Outgoings{" +
                "id='" + id + '\'' +
                ", OutgoingsTypeId='" + OutgoingsTypeId + '\'' +
                ", OutgoingsDescription='" + OutgoingsDescription + '\'' +
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

    public Integer getOutgoingsTypeId() {
        return OutgoingsTypeId;
    }
    public void setOutgoingsTypeId(Integer OutgoingsTypeId ) {
        this.OutgoingsTypeId = OutgoingsTypeId;
    }

    public String getOutgoingsDescription() {
        return OutgoingsDescription;
    }
    public void setOutgoingsDescription(String OutgoingsDescription) {
        this.OutgoingsDescription = OutgoingsDescription;
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