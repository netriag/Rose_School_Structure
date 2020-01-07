package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;

public class Student {
    private static int count=1;
    private int id;   
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;     
    private Course course;
    private float tuitionFees;
    

    public Student(String firstName, String lastName, LocalDate dateOfBirth, Course course, float tuitionFees) {       
        this.firstName = firstName;
        this.lastName = lastName;      
        this.dateOfBirth=dateOfBirth;
        
        this.course=course;
        this.tuitionFees=tuitionFees;        
        this.id=count;
        count++;
    }
    
    public Student(){}
    

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Student.count = count;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Course getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "Student: " + id + ", First Name = " + firstName + ", Last Name = " + lastName + 
                ", Date Of Birth = " + dateOfBirth.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL))
                + ", Course = " + course.getCourseName()+ ", Tuition Fees = " + tuitionFees ;
    }
    
    public String toString1(){
        return "Course = " + course.getCourseName()+", Student: " + id + ", First Name = " + firstName + 
                ", Last Name = " + lastName + ", Date Of Birth = " + dateOfBirth.format(DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy",Locale.getDefault()))
                +  ", Tuition Fees = " + tuitionFees ;    
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public float getTuitionFees() {
        return tuitionFees;
    }

    public void setTuitionFees(float tuitionFees) {
        this.tuitionFees = tuitionFees;
    }   
}
