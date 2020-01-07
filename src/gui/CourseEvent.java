package gui;

import java.util.Date;
import java.util.EventObject;

public class CourseEvent extends EventObject{
    
    private String courseName;
    private Date startDate;
    private Date endDate;
    
    public CourseEvent(Object o) {
        super(o);
    }
    
    public CourseEvent(Object o, String courseName, Date startDate, Date endDate){
        super(o);
        this.courseName = courseName;
        this. startDate = startDate;
        this.endDate = endDate;   
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }
    
    
}
