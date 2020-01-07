package model;

import java.util.ArrayList;

public class TrainersPerCourse {
    ArrayList<Trainer> trainersPerCourse=new ArrayList<Trainer>();

    public ArrayList<Trainer> getTrainersPerCourse() {
        ArrayList<Trainer> trainersPerCourseFinal=new ArrayList<Trainer>();
        for(int i=0; i<trainersPerCourse.size(); i++){
            if(trainersPerCourse.get(i).getCourse().getCourseName()=="C1_Java_FT"){
                trainersPerCourseFinal.add(trainersPerCourse.get(i));            
            }        
        }
        for(int i=0; i<trainersPerCourse.size(); i++){
            if(trainersPerCourse.get(i).getCourse().getCourseName()=="C2_CSharp_FT"){
                trainersPerCourseFinal.add(trainersPerCourse.get(i));            
            }        
        }
        for(int i=0; i<trainersPerCourse.size(); i++){
            if(trainersPerCourse.get(i).getCourse().getCourseName()=="C3_Java_PT"){
                trainersPerCourseFinal.add(trainersPerCourse.get(i));            
            }        
        }
        for(int i=0; i<trainersPerCourse.size(); i++){
            if(trainersPerCourse.get(i).getCourse().getCourseName()=="C4_CSharp_PT"){
                trainersPerCourseFinal.add(trainersPerCourse.get(i));            
            }        
        }       
        
        return  trainersPerCourseFinal;
    }

    public void setTrainersPerCourse(ArrayList<Trainer> trainersPerCourse) {
        this.trainersPerCourse = trainersPerCourse;
    }    
}
