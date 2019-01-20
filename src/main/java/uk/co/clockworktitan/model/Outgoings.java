package uk.co.clockworktitan.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class

public class Outgoings {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer AffordabilityCaseID;
    private Integer OutgoingsTypeId;
    private String  OutgoingsDescription;
    private Integer FromYear;
    private Integer ToYear;
    private Double Amount;

    public Outgoings(Integer OutgoingsTypeId, Integer AffordabilityCaseID, String  OutgoingsDescription, Integer FromYear, Integer ToYear, Double Amount) {
        this.OutgoingsTypeId = OutgoingsTypeId;
        this.AffordabilityCaseID = AffordabilityCaseID;
        this.OutgoingsDescription = OutgoingsDescription;
        this.FromYear = FromYear;
        this.ToYear = ToYear;
        this.Amount = Amount;
    }

    public Outgoings() {

    }

    @Override
    public String toString() {
        return "Outgoings{" +
                "id='" + id + '\'' +
                ", OutgoingsTypeId='" + OutgoingsTypeId + '\'' +
                ", AffordabilityCaseID='" + AffordabilityCaseID + '\'' +
                ", OutgoingsDescription='" + OutgoingsDescription + '\'' +
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

    public Integer getOutgoingsTypeId() {
        return OutgoingsTypeId;
    }
    public void setOutgoingsTypeId(Integer OutgoingsTypeId ) {
        this.OutgoingsTypeId = OutgoingsTypeId;
    }

    public Integer getAffordabilityCaseID() {
        return AffordabilityCaseID;
    }
    public void setAffordabilityCaseID(Integer AffordabilityCaseID ) {
        this.AffordabilityCaseID = AffordabilityCaseID;
    }


    public String getOutgoingsDescription() {
        return OutgoingsDescription;
    }
    public void setOutgoingsDescription(String OutgoingsDescription) {
        this.OutgoingsDescription = OutgoingsDescription;
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