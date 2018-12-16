package uk.co.clockworktitan.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class

public class OutgoingsType {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String OutgoingsTypeName;
    private Boolean IndexLinked;

    public OutgoingsType(String OutgoingsTypeName, Boolean IndexLinked) {
        this.OutgoingsTypeName = OutgoingsTypeName;
        this.IndexLinked = IndexLinked;
    }

    public OutgoingsType() {

    }

    @Override
    public String toString() {
        return "OutgoingsType{" +
                "name='" + OutgoingsTypeName + '\'' +
                ", IndexLinked='" + IndexLinked + '\'' +
                '}';
    }


    public String getOutgoingsTypeName() {
        return OutgoingsTypeName;
    }

    public void setOutgoingsTypeName(String OutgoingsTypeName) {
        this.OutgoingsTypeName = OutgoingsTypeName;
    }


    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }

    public void setIndexLinked(Boolean IndexLinked ) {this.IndexLinked = IndexLinked;}
    public Boolean getIndexLinked()  {return IndexLinked;}


}