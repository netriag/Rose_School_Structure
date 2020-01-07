package model;

import java.util.ArrayList;

public class AssignmentsPerStudent {
    private ArrayList<Assignment> assignmentsPerStudent =  new ArrayList<Assignment>();
    
    
    public ArrayList<Assignment> getAssignmentsPerStudent(){
        
        ArrayList<Assignment> assignmentsPerStudentFinal = new ArrayList<Assignment>();
         
         assignmentsPerStudentFinal= assignmentsPerStudent;      
         return assignmentsPerStudentFinal;    
    }
    
    public void setAssignmentsPerStudent(ArrayList<Assignment> assignmentsPerStudent){
        this.assignmentsPerStudent=assignmentsPerStudent;
    }
    
    
    
}
