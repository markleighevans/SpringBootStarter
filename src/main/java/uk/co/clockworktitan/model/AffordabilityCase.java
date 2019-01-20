package uk.co.clockworktitan.model;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class

public class AffordabilityCase {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer originatingQuoteID;
    private String name;
    private Integer ApplicantCount;
    private String Applicant1Name;
    private String Applicant2Name;
    private CaseStatus Status;
    private Integer FromYear;
    private Integer ToYear;

    public AffordabilityCase(Integer ID, Integer originatingQuoteID, String name, Integer ApplicantCount, String Applicant1Name, String Applicant2Name, Integer FromYear, Integer ToYear) {
        this.id = ID;
        this.originatingQuoteID = originatingQuoteID;
        this.ApplicantCount = ApplicantCount;
        this.Applicant1Name = Applicant1Name;
        this.Applicant2Name = Applicant2Name;
        this.name =  name;
        this.FromYear = FromYear;
        this.ToYear = ToYear;
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
                ", Applicant1Name='" + Applicant1Name + '\'' +
                ", Applicant2Name='" + Applicant2Name + '\'' +
                ", FromYear='" + FromYear + '\'' +
                ", ToYear='" + ToYear + '\'' +
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

    public String getApplicant1Name() { return Applicant1Name;  }
    public void setApplicant1Name(String Applicant1Name) {
        this.Applicant1Name = Applicant1Name;
    }

    public String getApplicant2Name() { return Applicant2Name;  }
    public void setApplicant2Name(String Applicant1Name) {
        this.Applicant2Name = Applicant1Name;
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





}