package gui;

import java.util.Date;
import java.util.EventObject;
import model.Course;

public class StudentEvent extends EventObject{  
    
    private String lastName;
    private String firstName;
    private Date dateOfBirth;
    private String course;
    private float tuittionFees;   
    
    public StudentEvent(Object o) {
        super(o);
    }

    public StudentEvent( Object o,String firstName,String lastName,  Date dateOfBirth, String course, float tuittionFees) {
        super(o);               
        this.lastName = lastName;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        this.course = course;
        this.tuittionFees = tuittionFees;        
    }      

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public float getTuittionFees() {
        return tuittionFees;
    }

    public void setTuittionFees(float tuittionFees) {
        this.tuittionFees = tuittionFees;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }   
}
