package model;

import java.util.ArrayList;

public class GiveADate {
    
    private int weekNumber;
    private ArrayList<Assignment> assignmentsPerStudent;
    
    
    
    //public GiveADate(int weekNumber, ArrayList<Assignment> assignmentsPerStudent){
    //    this.weekNumber=weekNumber;
    //    this.assignmentsPerStudent=assignmentsPerStudent;    
    //    System.out.println(weekNumber);
    //}
    
    public ArrayList<Assignment> getStudentsPerAssignmentsDueDate(int weekNumber, ArrayList<Assignment>assignmentsPerStudent){
        this.weekNumber=weekNumber;
        this.assignmentsPerStudent=assignmentsPerStudent;
        ArrayList<Assignment> studentsPerAssignmentsGivenDate=new ArrayList<Assignment>();
        for (int i=0; i<assignmentsPerStudent.size(); i++){
            if(weekNumber==assignmentsPerStudent.get(i).getWeekNumber()){
                studentsPerAssignmentsGivenDate.add(assignmentsPerStudent.get(i));
            }      
        }
    return studentsPerAssignmentsGivenDate;
    }
    
    
    
    
    
    
    
}
