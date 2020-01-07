package gui;

import java.util.EventObject;

public class TrainerEvent extends EventObject{
    
    
    private String firstName;
    private String lastName;
    private String subject;
    
    public TrainerEvent(Object source) {
        super(source);
    }
    
    public TrainerEvent(Object source, String firstName, String lastName, String subject) {
        super(source);
        this.firstName=firstName;
        this.lastName=lastName;
        this.subject=subject;        
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }
    
    
    
}
