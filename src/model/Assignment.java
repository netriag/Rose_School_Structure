package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Assignment {
    private String title;
    private String description;    
    private float oralMark;
    private float totalMark;
    private Student student;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private LocalDate submissionDate;  
    private LocalDate subDateDue;
    private String courseName;
    private int weekNumber;
    private static int count=1;
    private int id;
    
    public Assignment(){}
    
    public Assignment(String title, String decsription, LocalDate dateOfBirth, LocalDate submissionDate, LocalDate subDateDue, float oralMark, float totalMark, Student student, 
            int weekNumber){      
        
        this.title=title;
        this.description=description;        
        this.oralMark=oralMark;
        this.totalMark=totalMark; 
        this.student =student;
        this.firstName=firstName;
        this.lastName=lastName;
        this.dateOfBirth=dateOfBirth;  
        this.submissionDate=submissionDate;
        this.courseName=courseName;
        this.weekNumber=weekNumber;
        this.subDateDue=subDateDue;
        id=count;
        count++;
    }

    @Override
    public String toString() {
        
        return "Assignment " +id+ ", title = " + title + ", Submission Date Due  = " + subDateDue.format(DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy",Locale.getDefault()))
                +", Submitted = "+submissionDate.format(DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy",Locale.getDefault()))+ ", Oral Mark = " + oralMark + ", Total Mark = " + totalMark + ", First Name = " + student.getFirstName() + ", Last Name = " 
                + student.getLastName() + ", dateOfBirth = " + student.getDateOfBirth().format(DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy",Locale.getDefault()))
                +", Course: "+student.getCourse().getCourseName()+", WeekNumber_Deadline_0f_the_Assignment: " +weekNumber;
    }
    
    public String toString1(){
        return "Course: "+student.getCourse().getCourseName()+", Assignment = "+title+                
                ", Date Of Birth = " + student.getDateOfBirth().format(DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy",Locale.getDefault()));
    
    }
    
    public String toString2(){
        return "Student: "+student.getId()+", First Name = "+student.getFirstName()+", Last Name = "+student.getLastName()+
                ", Date Of Birth = "+student.getDateOfBirth().format(DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy",Locale.getDefault()))+
                ", Assignment = "+title+", Submission Date Due = "+subDateDue.format(DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy",Locale.getDefault()))
                +", Submitted = "+submissionDate.format(DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy",Locale.getDefault()))+", Oral Mark = "+oralMark+
                ", Total Mark = "+totalMark;    
    }
    
    public String toString3(){
        return "Student: "+student.getId()+", First Name = "+student.getFirstName()+", Last Name = "+student.getLastName()+
                ", Date Of Birth = "+student.getDateOfBirth().format(DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy",Locale.getDefault()))+
                ", Assignment = "+title+", Submission Date Due = "+subDateDue.format(DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy",Locale.getDefault()))
                +", WeekNumber_Deadline_0f_the_Assignment: " +weekNumber;    
    }

    public String getTitle() {
        return title;
    }

    public Student getStudent() {
        return student;
    }

    public LocalDate getSubDateDue() {
        return subDateDue;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Assignment.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDate getSubDateTime() {
        return submissionDate;
    }

    public void setSubDateTime(LocalDate subDateTime) {
        this.submissionDate = subDateTime;
    }

    public float getOralMark() {
        return oralMark;
    }

    public void setOralMark(float oralMark) {
        this.oralMark = oralMark;
    }

    public float getTotalMark() {
        return totalMark; 
    }

    public LocalDate getSubmissionDate() {
        return submissionDate;
    }

    public int getWeekNumber() {
        return weekNumber;
    }

    public void setTotalMark(float totalMark) {
        this.totalMark = totalMark;
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
}
