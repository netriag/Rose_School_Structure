package model;

import java.util.List;
import java.util.ArrayList;

public class Database {
    
    private ArrayList<Trainer>trainers;  
    private ArrayList<Student>students;
    private ArrayList<Course> courses;    
    private ArrayList<Assignment> assignments;
    
    
    private ArrayList<Trainer> trainersPerCourse;  
    private ArrayList<Student> studentsPerCourse;
    private ArrayList<Student> studentsInMultipleCourses;
    private ArrayList<Assignment> assignmentsPerCourse;
    private ArrayList<Assignment> assignmentsPerStudent;
    
    
    private GiveADate giveADate;
    private TrainersPerCourse trpc;
    private StudentsPerCourse stpc;    
    private StudentsInMultipleCourses smc;
    private AssignmentsPerCourse apc;
    private AssignmentsPerStudent aps;
    
    
    public Database(){
         trainers=new ArrayList<Trainer>();   
         students=new ArrayList<Student>();
         courses=new ArrayList<Course>();      
         assignments=new ArrayList<Assignment>();
         
         giveADate=new GiveADate();
         trainersPerCourse=trainers;     
         studentsPerCourse=students;
         studentsInMultipleCourses=students;      
         assignmentsPerCourse=assignments;
         assignmentsPerStudent=assignments;
         trpc=new TrainersPerCourse();
         stpc=new StudentsPerCourse();
         smc=new StudentsInMultipleCourses(); 
         
         aps=new AssignmentsPerStudent();
         apc=new AssignmentsPerCourse();
         
    }
    
    public void addTrainer(Trainer trainer){        
        trainers.add(trainer);  
    }
    
    public void addStudent(Student student) {
        students.add(student)  ;
    }
    
    public void addCourse(Course course){
        courses.add(course);    
    }
    
    public void addAssignment(Assignment assignment){
        assignments.add(assignment);          
    }
    
    public ArrayList<Assignment> getGiveADateIntegerArrayList(int weekNumber){
        //giveADate=new GiveADate(weekNumber, getAssignmentsPerStudent());  
        ArrayList<Assignment> studentsPerAssignmentsGivenDate=new ArrayList<Assignment>();
               studentsPerAssignmentsGivenDate =giveADate.getStudentsPerAssignmentsDueDate(weekNumber, getAssignmentsPerStudent());
        return studentsPerAssignmentsGivenDate;
    }  
    
    public ArrayList<Trainer> getTrainers(){    
        for(int i=0; i<trainers.size(); i++){
            trainers.get(i);
            for(int j=i+1; j<trainers.size(); j++){                
                if(trainers.get(i).getFirstName().equals(trainers.get(j).getFirstName())){                    
                    if(trainers.get(i).getLastName().equals(trainers.get(j).getLastName())){                        
                        if(trainers.get(i).getCourse().getCourseName().equals(trainers.get(j).getCourse().getCourseName())){                           
                            trainers.remove(trainers.get(j));  
                            System.out.println("Can't submit same Trainer: "+trainers.get(j-1)+" twice -  submission denied");
                        }                       
                    }
                }
            }            
        }        
        return trainers;   
    } 
    
    public ArrayList<Student> getStudents(){
        for(int i=0; i<students.size(); i++){
            students.get(i);
            for(int j=i+1; j<students.size(); j++){                
                if(students.get(i).getFirstName().equals(students.get(j).getFirstName())){                    
                    if(students.get(i).getLastName().equals(students.get(j).getLastName())){                        
                        if(students.get(i).getDateOfBirth().equals(students.get(j).getDateOfBirth())){   
                            if(students.get(i).getCourse().getCourseName().equals(students.get(j).getCourse().getCourseName())){
                                System.out.println("Can't submit same Student: "+students.get(j)+" twice -  submission denied");
                            students.remove(students.get(j)); 
                            
                            }
                        }                       
                    }
                }
            }            
        }
        return students;    
    }
    
    public ArrayList<Course> getCourses(){
        for(int i=0; i<courses.size(); i++){
            courses.get(i);
            for(int j=i+1; j<courses.size(); j++){                
                if(courses.get(i).getCourseName().equals(courses.get(j).getCourseName())){                    
                    if(courses.get(i).getStartDate().equals(courses.get(j).getStartDate())){                        
                        if(courses.get(i).getEndDate().equals(courses.get(j).getEndDate())){                             
                            courses.remove(courses.get(j));               
                            System.out.println("Can't submit same Course: "+courses.get(j-1)+" twice -  submission denied");
                        }                       
                    }
                }
            }            
        }
        return courses;    
    }
    
    public ArrayList<Assignment> getAssignments() throws NullPointerException{
        
        for (int i=0; i<assignments.size(); i++){
            assignments.get(i);
            for(int j=i+1; j<assignments.size();j++){
               if(assignments.get(i).getTitle().equals(assignments.get(j).getTitle())){
                   if(assignments.get(i).getSubmissionDate().equals(assignments.get(j).getSubmissionDate())){
                       if(assignments.get(i).getDateOfBirth().equals(assignments.get(j).getDateOfBirth())){
                           if(assignments.get(i).getSubDateDue().equals(assignments.get(j).getSubDateDue())){
                               if(assignments.get(i).getOralMark()==assignments.get(j).getOralMark()){
                                   if(assignments.get(i).getStudent().getFirstName().equals(assignments.get(j).getStudent().getFirstName())){
                                       if(assignments.get(i).getStudent().getLastName().equals(assignments.get(j).getStudent().getLastName())){
                                           if(assignments.get(i).getStudent().getCourse().getCourseName().equals(assignments.get(j).getStudent().getCourse().getCourseName())){
                                           assignments.remove(assignments.get(j)); 
                                           System.out.println("Can't submit same Assignment: "+assignments.get(j-1)+"for the same student twice -  submission denied");
                                           }
                                       }
                                   }
                               }
                           }
                       }
                   }
               }          
            }        
        }        
        return assignments;
    }

    public TrainersPerCourse getTrpc() {
        return trpc;
    }

    public void setTrpc(TrainersPerCourse trpc) {
        this.trpc = trpc;
    }        
    
    public ArrayList<Trainer> getTrainersPerCourse(){
        trpc.setTrainersPerCourse(getTrainers());
        
        return trpc.getTrainersPerCourse();       
    }   
    
    public ArrayList<Student> getStudentsPerCourse(){
        stpc.setStudentsPerCourse(students);
        return stpc.getStudentsPerCourse();    
    }
    
    public ArrayList<Student> getStudentsInMultipleCourses(){
        
        smc.setStudentsInMultipleCourses(studentsInMultipleCourses);
        return smc.getStudentsInMultipleCourses();
    }
    
    public ArrayList<Assignment> getAssignmentsPerCourse(){        
        apc.setAssignmentsPerCourse(assignmentsPerCourse);
        return apc.getAssignmentsPerCourse();
    }
    
    public ArrayList<Assignment> getAssignmentsPerStudent(){
        
        aps.setAssignmentsPerStudent(assignmentsPerStudent);
        return aps.getAssignmentsPerStudent();    
    }
}
