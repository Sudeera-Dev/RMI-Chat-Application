package app.pojos;
// Generated May 25, 2022 9:50:17 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Groups generated by hbm2java
 */
public class Groups  implements java.io.Serializable {


     private Integer GId;
     private String GName;
     private String GDesctiption;
     private int GStat;
     private Date GCreatedDate;
     private Date GCreatedTime;

    public Groups() {
    }

    public Groups(String GName, String GDesctiption, int GStat, Date GCreatedDate, Date GCreatedTime) {
       this.GName = GName;
       this.GDesctiption = GDesctiption;
       this.GStat = GStat;
       this.GCreatedDate = GCreatedDate;
       this.GCreatedTime = GCreatedTime;
    }
   
    public Integer getGId() {
        return this.GId;
    }
    
    public void setGId(Integer GId) {
        this.GId = GId;
    }
    public String getGName() {
        return this.GName;
    }
    
    public void setGName(String GName) {
        this.GName = GName;
    }
    public String getGDesctiption() {
        return this.GDesctiption;
    }
    
    public void setGDesctiption(String GDesctiption) {
        this.GDesctiption = GDesctiption;
    }
    public int getGStat() {
        return this.GStat;
    }
    
    public void setGStat(int GStat) {
        this.GStat = GStat;
    }
    public Date getGCreatedDate() {
        return this.GCreatedDate;
    }
    
    public void setGCreatedDate(Date GCreatedDate) {
        this.GCreatedDate = GCreatedDate;
    }
    public Date getGCreatedTime() {
        return this.GCreatedTime;
    }
    
    public void setGCreatedTime(Date GCreatedTime) {
        this.GCreatedTime = GCreatedTime;
    }




}


