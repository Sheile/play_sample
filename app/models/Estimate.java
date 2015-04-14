package models;

import java.util.Date;
 
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
 
import play.db.ebean.Model;
import play.data.validation.*;
 
import com.avaje.ebean.annotation.CreatedTimestamp;
 
@Entity
public class Estimate extends Model {
  @Id
  public Long id;
 
  @Constraints.Required
  public Long estimateNumber;

  @Constraints.Required
  public String customerName;

  @Constraints.Required
  public String subject;
 
  @CreatedTimestamp
  public Date createDate;
 
  @Version
  public Date updateDate;
 
  public String toString() {
    return "Parent [id=" + id + ", estimateNumber=" + estimateNumber +
      ", customerName=" + customerName + ", subject=" + subject + "]";
  }

  public static Finder<Long, Estimate> find = new Finder<Long, Estimate>(Long.class, Estimate.class);
}
