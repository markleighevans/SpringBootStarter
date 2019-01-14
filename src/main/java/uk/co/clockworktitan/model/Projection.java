package uk.co.clockworktitan.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class

public class Projection {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer AffordabilityCaseID;
    private Date ProjectionDate;
    private Double DeafultIncomeAmount;
    private Double Stress1IncomeAmount;
    private Double Stress2IncomeAmount;
    private Double OutgoingsAmount;
    private Double DefaultSurplusAmount;
    private Double Stress1SurplusAmount;
    private Double Stress2SurplusAmount;
    
    public Projection(Integer id,  Integer AffordabilityCaseID, Date ProjectionDate, Double DeafultIncomeAmount, Double Stress1IncomeAmount, Double Stress2IncomeAmount, Double OutgoingsAmount, Double DefaultSurplusAmount, Double Stress1SurplusAmount, Double Stress2SurplusAmount  ) {
        this.id = id;
        this.AffordabilityCaseID = AffordabilityCaseID;
        this.ProjectionDate = ProjectionDate;
        this.DeafultIncomeAmount = DeafultIncomeAmount;
        this.Stress1IncomeAmount = Stress1IncomeAmount;
        this.Stress2IncomeAmount = Stress2IncomeAmount;
        this.OutgoingsAmount = OutgoingsAmount;
        this.DefaultSurplusAmount = DefaultSurplusAmount;
        this.Stress1SurplusAmount = Stress1SurplusAmount;
        this.Stress2SurplusAmount = Stress2SurplusAmount;
        
    }

    public Projection() {

    }

    @Override
    public String toString() {
        return "Project{" +
                "id='" + id + '\'' +
                "AffordabilityCaseID='" + AffordabilityCaseID + '\'' +
        "AffordabilityCaseID ='" + AffordabilityCaseID + '\'' +
        "ProjectionDate ='" + ProjectionDate + '\'' +
        "DeafultIncomeAmount ='" + DeafultIncomeAmount + '\'' +
        "Stress1IncomeAmount ='" + Stress1IncomeAmount + '\'' +
        "Stress2IncomeAmount ='" + Stress2IncomeAmount + '\'' +
        "OutgoingsAmount ='" + OutgoingsAmount + '\'' +
        "DefaultSurplusAmount ='" + DefaultSurplusAmount + '\'' +
        "Stress1SurplusAmount ='" + Stress1SurplusAmount + '\'' +
        "Stress2SurplusAmount ='" + Stress2SurplusAmount + '\'' +
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

    public Date getProjectionDate() {return ProjectionDate;}
    public void setProjectionDate(Date ProjectionDate) { this.ProjectionDate = ProjectionDate;}

    public Double getDeafultIncomeAmount() {return DeafultIncomeAmount;}
    public void  setDeafultIncomeAmount(Double DeafultIncomeAmount) {this.DeafultIncomeAmount = DeafultIncomeAmount;}

    public Double getStress1IncomeAmount() {return Stress1IncomeAmount;}
    public void  setStress1IncomeAmount(Double Stress1IncomeAmount) {this.Stress1IncomeAmount = Stress1IncomeAmount;}

    public Double getStress2IncomeAmount() {return Stress2IncomeAmount;}
    public void  setStress2IncomeAmount(Double Stress2IncomeAmount) {this.Stress2IncomeAmount = Stress2IncomeAmount;}

    public Double getOutgoingsAmount() {return OutgoingsAmount;}
    public void  setOutgoingsAmount(Double OutgoingsAmount) {this.OutgoingsAmount = OutgoingsAmount;}

    public Double getDefaultSurplusAmount() {return DefaultSurplusAmount;}
    public void  setDefaultSurplusAmount(Double DefaultSurplusAmount) {this.DefaultSurplusAmount = DefaultSurplusAmount;}

    public Double getStress1SurplusAmount() {return Stress1SurplusAmount;}
    public void  setStress1SurplusAmount(Double Stress1SurplusAmount) {this.Stress1SurplusAmount = Stress1SurplusAmount;}

    public Double getStress2SurplusAmount() {return Stress2SurplusAmount;}
    public void  setStress2SurplusAmount(Double Stress2SurplusAmount) {this.Stress2SurplusAmount = Stress2SurplusAmount;}


}