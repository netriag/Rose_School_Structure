package gui;

import java.util.Date;
import java.util.EventObject;

public class AssignmentEvent extends EventObject{
    
    private String title;
    private String description;
    private Date submitted;    
    private float oralMarkAssign;
    private float totalMarkAssign;
    private String stFirstName;
    private String stLastName;
    private Date birthDate;
    private int weekNumber;
    private Date subDateDue;

    public int getWeekNumber() {
        return weekNumber;
    }
    
    public AssignmentEvent(Object o) {
        super(o);
    }
    
    public AssignmentEvent(Object o,String title,String description,Date submitted, float oralMarkAssign,float totalMarkAssign,
                        String stFirstName,String stLastName, Date birthDate, int weekNumber, Date subDateDue){
        super(o);
        this.title=title;
        this.description=description;
        this.submitted=submitted;
        this.oralMarkAssign=oralMarkAssign;
        this.totalMarkAssign=totalMarkAssign;
        this.stFirstName=stFirstName;
        this.stLastName=stLastName;
        this.birthDate=birthDate;   
        this.weekNumber=weekNumber;
        this.subDateDue=subDateDue;
    }

    public Date getSubDateDue() {
        return subDateDue;
    }

    public void setSubDateDue(Date subDateDue) {
        this.subDateDue = subDateDue;
    }

    public Object getSource() {
        return source;
    }

    public void setWeekNumber(int weekNumber) {
        this.weekNumber = weekNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getSubmitted() {
        return submitted;
    }

    public void setSubDateTime(Date submitted) {
        this.submitted = submitted;
    }

    public float getOralMarkAssign() {
        return oralMarkAssign;
    }

    public void setOralMarkAssign(float oralMarkAssign) {
        this.oralMarkAssign = oralMarkAssign;
    }

    public float getTotalMarkAssign() {
        return totalMarkAssign;
    }

    public void setTotalMarkAssign(float totalMarkAssign) {
        this.totalMarkAssign = totalMarkAssign;
    }

    public String getStFirstName() {
        return stFirstName;
    }

    public void setStFirstName(String stFirstName) {
        this.stFirstName = stFirstName;
    }

    public String getStLastName() {
        return stLastName;
    }

    public void setStLastName(String stLastName) {
        this.stLastName = stLastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    
}
