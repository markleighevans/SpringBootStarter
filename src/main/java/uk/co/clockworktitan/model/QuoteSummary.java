package uk.co.clockworktitan.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class

public class QuoteSummary {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String ProductDescription;
    private Integer ApplicantCount;
    private String  Applicant1Name;
    private String Applicant2Name;
    private Date FromDate;
    private Date ToDate;
    private Double Amount;
    private Boolean proceededWith;

    public QuoteSummary(Integer id, String ProductDescription, Integer ApplicantCount, String  Applicant1Name, String  Applicant2Name, Date FromDate, Date ToDate, Double Amount, Boolean proceededWith)
    {
        this.id = id;
        this.ProductDescription = ProductDescription;
        this.ApplicantCount = ApplicantCount;
        this.Applicant1Name = Applicant1Name;
        this.Applicant2Name = Applicant2Name;
        this.FromDate = FromDate;
        this.ToDate = ToDate;
        this.Amount = Amount;
        this.proceededWith = proceededWith;

    }

    public QuoteSummary() {

    }

    @Override
    public String toString() {
        return "Income{" +
                "id='" + id + '\'' +
                "ProductDescription='" + ProductDescription + '\'' +
                ", ApplicantCount='" + ApplicantCount + '\'' +
                ", Applicant1Name='" + Applicant1Name + '\'' +
                ", Applicant2Name='" + Applicant2Name + '\'' +
                ", FromDate='" + FromDate + '\'' +
                ", ToDate='" + ToDate + '\'' +
                ", Amount='" + Amount + '\'' +
                ", proceededWith='" + proceededWith + '\'' +
                '}';
    }


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductDescription() {
        return ProductDescription;
    }
    public void setProductDescription(String ProductDescription ) {
        this.ProductDescription = ProductDescription;
    }

    public Integer getApplicantCount() {
        return ApplicantCount;
    }
    public void setApplicantCount(Integer ApplicantCount ) {
        this.ApplicantCount = ApplicantCount;
    }

    public String getApplicant1Name() {
        return Applicant1Name;
    }
    public void setApplicant1Name(String Applicant1Name) {
        this.Applicant1Name = Applicant1Name;
    }

    public String getApplicant2Name() {
        return Applicant2Name;
    }
    public void setApplicant2Name(String Applicant2Name) {
        this.Applicant2Name = Applicant2Name;
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

    public Double getAmount() { return Amount; }
    public void setAmount(Double Amount)
    {
        this.Amount = Amount;
    }

    public Boolean getProceededWith() {return proceededWith;}
    public void setProceededWith(Boolean proceededWith) {this.proceededWith = proceededWith;}
}