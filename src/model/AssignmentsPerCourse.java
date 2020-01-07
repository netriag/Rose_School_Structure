package model;

import java.util.ArrayList;

public class AssignmentsPerCourse {
    
    private ArrayList<Assignment> assignmentsPerCourse =  new ArrayList<Assignment>();
    
    public ArrayList<Assignment> getAssignmentsPerCourse(){
        
        ArrayList<Assignment> assignmentsPerCourseFinal = new ArrayList<Assignment>();
         for(int i=0; i<assignmentsPerCourse.size(); i++){
             if(assignmentsPerCourse.get(i).getStudent().getCourse().getCourseName()=="C1_Java_FT"){
                 assignmentsPerCourseFinal.add(assignmentsPerCourse.get(i));             
             }
         }
         
         for(int i=0; i<assignmentsPerCourse.size(); i++){
             if(assignmentsPerCourse.get(i).getStudent().getCourse().getCourseName()=="C2_CSharp_FT"){
                 assignmentsPerCourseFinal.add(assignmentsPerCourse.get(i));             
             }
         }
         
         for(int i=0; i<assignmentsPerCourse.size(); i++){
             if(assignmentsPerCourse.get(i).getStudent().getCourse().getCourseName()=="C3_Java_PT"){
                 assignmentsPerCourseFinal.add(assignmentsPerCourse.get(i));             
             }
         }
         
         for(int i=0; i<assignmentsPerCourse.size(); i++){
             if(assignmentsPerCourse.get(i).getStudent().getCourse().getCourseName()=="C2_CSharp_PT"){
                 assignmentsPerCourseFinal.add(assignmentsPerCourse.get(i));             
             }
         }
         
             
         return assignmentsPerCourseFinal;    
    }

    
    public void setAssignmentsPerCourse(ArrayList<Assignment> assignmentsPerCourse){
        this.assignmentsPerCourse=assignmentsPerCourse;
    }    
}
