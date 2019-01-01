package uk.co.clockworktitan.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class

public class DefaultOutgoings {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer outgoingsTypeID;
    String  Description;
    private Double amount;

    public DefaultOutgoings(Integer id, Integer outgoingsTypeID, String  Description , Double amount) {
        this.id = id;
        this.outgoingsTypeID = outgoingsTypeID;
        this.Description = Description;
        this.amount = amount;
    }

    public DefaultOutgoings() {

    }

    @Override
    public String toString() {
        return "DefaultOutgoings{" +
                "outgoingsTypeID='" + outgoingsTypeID + '\'' +
                "Description='" + Description + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }

    public void setAmount(Double Amount ) {this.amount = amount;}
    public Double getAmount()  {return amount;}

    public void setOutgoingsTypeID(Integer outgoingsTypeID ) {this.outgoingsTypeID = outgoingsTypeID;}
    public Integer getOutgoingsTypeID()  {return outgoingsTypeID;}

    public void setDescription(String Description ) {this.Description = Description;}
    public String getDescription()  {return Description;}



}