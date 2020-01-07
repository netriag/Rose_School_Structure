package controller;


import gui.AssignmentEvent;
import gui.CourseEvent;
import StaticMethods.StaticMethods;
import gui.StudentEvent;
import gui.TrainerEvent;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import model.Assignment;
import model.Course;
import model.Database;
import model.Student;
import model.Trainer;

public class Controller {
    
    Database db=new Database();    
    
    public ArrayList<Trainer> getTrainersList(){
        return db.getTrainers();      
    }  
    
    public ArrayList<Student> getStudentsList(){
        return db.getStudents();    
    }
    
    public ArrayList<Course> getCoursesList(){
        return db.getCourses();    
    } 
    
    public ArrayList<Assignment> getAssignmentsList(){
        return db.getAssignments();
    }
    
    public ArrayList<Trainer> getTrainersPerCourseList(){
        return db.getTrainersPerCourse();    
    }
    
    public ArrayList<Student> getStudentsPerCourseList(){
        return db.getStudentsPerCourse();    
    }
    
    public ArrayList<Student> getStudentsInMultipleCoursesList(){
        return db.getStudentsInMultipleCourses();    
    }
    
    public ArrayList<Assignment> getAssignmentsPerCourseList(){
        return db.getAssignmentsPerCourse();
    }
    
    public ArrayList<Assignment> getAssignmentsPerStudentList(){
        return db.getAssignmentsPerStudent();    
    }
    
    public void addTrainer(TrainerEvent e) throws Exception{
        String firstName = e.getFirstName();  
        String lastName = e.getLastName();
        String subject = e.getSubject(); 
        ArrayList<Course>courses =new ArrayList<Course>();
        courses=db.getCourses();
        Course course=null;
        if(subject.equals("Java_C1_FT")){
            for(int i=0; i<courses.size(); i++){
                if(courses.get(i).getCourseName()=="C1_Java_FT"){                    
                    course=courses.get(i);    
                }                
            }
            if(course==null){
                throw new Exception("This course has not been declared!");
            }        
        }
        
        else if(subject.equals("C#_C2_FT")){
            for(int i=0; i<courses.size(); i++){
                if(courses.get(i).getCourseName()=="C2_CSharp_FT"){                    
                    course=courses.get(i);    
                }                
            }
            if(course==null){
                throw new Exception("This course has not been declared!");
            }        
        }  
        
        else if(subject.equals("Java_C3_PT")){
            for(int i=0; i<courses.size(); i++){
                if(courses.get(i).getCourseName()=="C3_Java_PT"){                    
                    course=courses.get(i);    
                }                
            }
            if(course==null){
                throw new Exception("This course has not been declared!");
            }        
        }
        
        else{
            for(int i=0; i<courses.size(); i++){
                if(courses.get(i).getCourseName()=="C4_CSharp_PT"){                    
                    course=courses.get(i);    
                }                
            }
            if(course==null){
                throw new Exception("This course has not been declared!");
            }        
        }     
        
        Trainer trainer = new Trainer(firstName, lastName, course);
        db.addTrainer(trainer);    
        System.out.println("Unless it has already been submitted Trainer: "+trainer+" is submitted successfully");
    }   
    
    public void addStudent(StudentEvent e) throws Exception{                
        String firstName = e.getFirstName();
        String lastName = e.getLastName();
        Date dateOfBirth = e.getDateOfBirth();
        LocalDate dateOfBirthLocal=StaticMethods.convertToLocalDateViaInstant(dateOfBirth);        
        
        String stCourse = e.getCourse();
        float tuittionFees = e.getTuittionFees();
        
        ArrayList<Course>courses =new ArrayList<Course>();
        courses=db.getCourses();
        Course course=null;
        if(stCourse.equals("Java_Full_Time")){
            for(int i=0; i<courses.size(); i++){
                if(courses.get(i).getCourseName()=="C1_Java_FT"){                    
                    course=courses.get(i);    
                }                
            }
            if(course==null){
                throw new Exception("This course has not been declared!");
            }        
        }
        
        else if(stCourse.equals("C#_Full_Time")){
            for(int i=0; i<courses.size(); i++){
                if(courses.get(i).getCourseName()=="C2_CSharp_FT"){                    
                    course=courses.get(i);    
                }                
            }
            if(course==null){
                throw new Exception("This course has not been declared!");
            }        
        }  
        
        else if(stCourse.equals("Java_Part_Time")){
            for(int i=0; i<courses.size(); i++){
                if(courses.get(i).getCourseName()=="C3_Java_PT"){                    
                    course=courses.get(i);    
                }                
            }
            if(course==null){
                throw new Exception("This course has not been declared!");
            }        
        }
        
        else if(stCourse.equals("C#_Part_Time")){
            for(int i=0; i<courses.size(); i++){
                if(courses.get(i).getCourseName()=="C4_CSharp_PT"){                    
                    course=courses.get(i);    
                }                
            }
            if(course==null){
                throw new Exception("This course has not been declared!");
            }        
        }             
        
        Student student = new Student(firstName, lastName,dateOfBirthLocal, course, tuittionFees);
        db.addStudent(student);   
        System.out.println("Unless it has already been submitted Student: "+student+" is submitted successfully");
    }
    
    public void addAssignment(AssignmentEvent e) throws Exception{                
        String title = e.getTitle();
        String description = e.getDescription();
        
        int weekNumber=e.getWeekNumber();
        
        LocalDate dateOfBirthLocal=StaticMethods.convertToLocalDateViaInstant(e.getBirthDate());        
        LocalDate subDateTimeLocal=StaticMethods.convertToLocalDateViaInstant(e.getSubmitted());        
        LocalDate subDateDue=StaticMethods.convertToLocalDateViaInstant(e.getSubDateDue()); 
        
        float oralMark = e.getOralMarkAssign();
        float totalMark = e.getTotalMarkAssign();
        
        String stFirstName = e.getStFirstName();
        String stLastName = e.getStLastName();       
        
        ArrayList<Student> students = new ArrayList<Student>();
        students=db.getStudents();
        Student student=null;
        for(int i=0; i<students.size();i++){
            if (stFirstName.equals(students.get(i).getFirstName())){    
                
            
                if (stLastName.equals(students.get(i).getLastName())){
                
                
                    if(dateOfBirthLocal.equals(students.get(i).getDateOfBirth())){
                         
                        student=students.get(i);
                    }                      
                }
            }     
        }
         
        if(student!=null&&weekNumber!=0){   
            if(getStudentsInMultipleCoursesList().contains(student)){
                
                if(description=="Java_Full_Time"){
                    description="C1_Java_FT";                    
                }
                else if(description=="C#_Full_Time"){
                    description="C2_CSharp_FT";                    
                }
                else if(description=="Java_Part_Time"){
                    description="C3_Java_PT";
                }    
                else
                    description="C4_CSharp_PT";
                    
            
                    for(int i=0; i<getStudentsInMultipleCoursesList().size();i++){
                        if(description==getStudentsInMultipleCoursesList().get(i).getCourse().getCourseName())
                        student=getStudentsInMultipleCoursesList().get(i);            
                    }
                        Assignment assignment = new Assignment(title, description, dateOfBirthLocal, subDateTimeLocal,subDateDue, oralMark,totalMark, 
                        student, weekNumber);                                   
                        db.addAssignment(assignment);                         
                        System.out.println("Unless it has already been submitted Assignment: "+title+" is submitted successfully on "
                        +subDateTimeLocal.format(DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy",Locale.getDefault()))+" for Student: "+student.getFirstName()
                        +" "+student.getLastName()+", "+student.getCourse().getCourseName());             
            }else{                           
                Assignment assignment = new Assignment(title, e.getDescription(), dateOfBirthLocal, subDateTimeLocal,subDateDue, oralMark,totalMark, 
                student, weekNumber);    
               
                                 
                db.addAssignment(assignment);
                         
                System.out.println("Unless it has already been submitted Assignment: "+title+" is submitted successfully on "
                +subDateTimeLocal.format(DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy",Locale.getDefault()))+" for Student: "+student.getFirstName()
                +" "+student.getLastName()+", "+student.getCourse().getCourseName());                           
            //}
        }
    }  
    }
    public void addCourse(CourseEvent e){
        String courseName = e.getCourseName();
         Date startDate = e.getStartDate();
         Date endDate = e.getEndDate();
         
         LocalDate startDateLocal=StaticMethods.convertToLocalDateViaInstant(startDate);
         LocalDate endDateLocal=StaticMethods.convertToLocalDateViaInstant(endDate);       
        
        Course course = new Course(courseName, startDateLocal, endDateLocal);
        db.addCourse(course);    
        System.out.println("Unless it has already been submitted Course: "+course+ " is submitted successfully!");
    }   
    
    public ArrayList<Assignment > getGiveADateIntegerArrayList(int weekNumber){
        ArrayList<Assignment> studentsPerAssignmentsGivenDate=new ArrayList<Assignment>();
        studentsPerAssignmentsGivenDate=db.getGiveADateIntegerArrayList(weekNumber);
        return studentsPerAssignmentsGivenDate;
    }
}

