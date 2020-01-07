package model;

import java.util.ArrayList;

public class StudentsInMultipleCourses {
    ArrayList<Student> studentsInMultipleCourses=new ArrayList<Student>();
    
    public ArrayList<Student> getStudentsInMultipleCourses(){
        ArrayList<Student> studentsInMultipleCoursesFinal=new ArrayList<Student>();
        for(int i=0; i<studentsInMultipleCourses.size(); i++){
            studentsInMultipleCourses.get(i);
            for(int j=i+1; j<studentsInMultipleCourses.size(); j++){
                if(studentsInMultipleCourses.get(i).getFirstName().equals(studentsInMultipleCourses.get(j).getFirstName())){
                    if(studentsInMultipleCourses.get(i).getLastName().equals(studentsInMultipleCourses.get(j).getLastName())){
                        if(studentsInMultipleCourses.get(i).getDateOfBirth().equals(studentsInMultipleCourses.get(j).getDateOfBirth())){
                            if(!studentsInMultipleCourses.get(i).getCourse().getCourseName().equals(studentsInMultipleCourses.get(j).getCourse().getCourseName())){
                                studentsInMultipleCoursesFinal.add(studentsInMultipleCourses.get(j));
                                if(!studentsInMultipleCoursesFinal.contains(studentsInMultipleCourses.get(i))){
                                    studentsInMultipleCoursesFinal.add(studentsInMultipleCourses.get(i));
                                }
                            }
                        }                    
                    }              
                }                               
            }                    
        }
        return studentsInMultipleCoursesFinal;    
    }
    
    public void setStudentsInMultipleCourses(ArrayList<Student> studentsInMultipleCourses){
        this.studentsInMultipleCourses=studentsInMultipleCourses;
    }    
}
