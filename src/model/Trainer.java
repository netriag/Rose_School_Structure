package model;

public class Trainer {   
    
    private static int count=1;
    private int id;
    private String firstName;
    private String lastName;      
    private Course course;

    public Trainer(String firstName, String lastName, Course course) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;       
        this.id=count;
        count++;
    }

    @Override
    public String toString() {
        return "Trainer_ID " + id+": First Name = " + firstName + ", Last Name =  " + lastName + ", Course = " + course.getCourseName() ;
    }
  
    public String toString1(){
        return "Course = "+course.getCourseName()+", Trainer_ID: "+id+", First Name = "+firstName+", Last Name = "+lastName;
    }

    public static int getCount() {
        return count;
    }    

    public static void setCount(int count) {
        Trainer.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Course getCourse() {
        return course;
    }

    public void setSubject(Course course) {
        this.course = course;
    }   
}
