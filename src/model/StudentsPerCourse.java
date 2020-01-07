package model;

import java.util.ArrayList;

public class StudentsPerCourse {
    
    private ArrayList<Student> studentsPerCourse=new ArrayList<Student>();
    
    public ArrayList<Student> getStudentsPerCourse(){
        ArrayList<Student> studentsPerCourseFinal=new ArrayList<Student>();
        for(int i=0; i<studentsPerCourse.size(); i++){
            if(studentsPerCourse.get(i).getCourse().getCourseName()=="C1_Java_FT"){
                studentsPerCourseFinal.add(studentsPerCourse.get(i));
            }        
        }
        for (int i=0; i<studentsPerCourse.size(); i++){
            if(studentsPerCourse.get(i).getCourse().getCourseName()=="C2_CSharp_FT"){
                studentsPerCourseFinal.add(studentsPerCourse.get(i));            
            }        
        }
        for(int i=0; i<studentsPerCourse.size();i++){
            if(studentsPerCourse.get(i).getCourse().getCourseName()=="C3_Java_PT"){
                studentsPerCourseFinal.add(studentsPerCourse.get(i));            
            }        
        }
        for(int i=0; i<studentsPerCourse.size(); i++){
            if (studentsPerCourse.get(i).getCourse().getCourseName()=="C4_CSharp_PT"){
                studentsPerCourseFinal.add(studentsPerCourse.get(i));
            }            
        }
        
        return studentsPerCourseFinal;    
    }
    
    public void setStudentsPerCourse(ArrayList<Student> studentsPerCourse){
        this.studentsPerCourse=studentsPerCourse;
    }
}
