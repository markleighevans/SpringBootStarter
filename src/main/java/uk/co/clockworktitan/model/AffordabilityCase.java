package uk.co.clockworktitan.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class

public class AffordabilityCase {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer originatingQuoteID;
    private String name;
    private Integer ApplicantCount;
    private CaseStatus Status;
    private Date FromDate;
    private Date ToDate;

    public AffordabilityCase(Integer ID, Integer originatingQuoteID, String name, Integer ApplicantCount, Date FromDate, Date ToDate) {
        this.id = ID;
        this.originatingQuoteID = originatingQuoteID;
        this.ApplicantCount = ApplicantCount;
        this.name =  name;
        this.FromDate = FromDate;
        this.ToDate = ToDate;
        this.Status = CaseStatus.PENDING;
    }

    public AffordabilityCase() {

    }

    @Override
    public String toString() {
        return "User{" +
                "originatingQuoteID='" + originatingQuoteID + '\'' +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", ApplicantCount='" + ApplicantCount + '\'' +
                ", FromDate='" + FromDate + '\'' +
                ", ToDate='" + ToDate + '\'' +
                ", CaseStatus ='" + Status + '\'' +
                '}';
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getoriginatingQuoteID() {
        return originatingQuoteID;
    }

    public void setoriginatingQuoteID(Integer originatingQuoteID) {
        this.originatingQuoteID = originatingQuoteID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getApplicantCount() {
        return ApplicantCount;
    }

    public void setApplicantCount(Integer ApplicantCount) {
        this.ApplicantCount = ApplicantCount;
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



}