package model;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.WeekFields;
import java.util.Date;
import java.util.Locale;

public class Course {
    
    private static int count=1;
    private int id;
    private String courseName;
    private LocalDate startDateLocal;
    private LocalDate endDateLocal;
    
    public Course(){
    }
    
    public Course(String courseName, LocalDate startDateLocal, LocalDate endDateLocal){
        this. courseName = courseName;
        this.startDateLocal=startDateLocal;
        this.endDateLocal=endDateLocal;
        this.id=count;
        count++;    
    }

    @Override
    public String toString() {        
        
        
        return "CourseName = " + courseName + ", startDate = " + startDateLocal.format(DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy",Locale.getDefault()))
                +", endDate = " + endDateLocal.format(DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy",Locale.getDefault())) ;
    }
    
    
    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Course.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDate getStartDate() {
        return startDateLocal;
    }

    public void setStartDate(LocalDate startDateLocal) {
        this.startDateLocal = startDateLocal;
    }

    public LocalDate getEndDate() {
        return endDateLocal;
    }

    public void setEndDate(LocalDate endDateLocal) {
        this.endDateLocal = endDateLocal;
    }    
}
