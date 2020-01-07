package gui;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class CoursePanel extends JPanel{
    
    private JLabel nameOfCourseLabel;
    private JLabel startDateLabel;
    private JLabel endDateLabel;
    
    private JTextField nameOfCourseTextField;       
    
    private JList titleList;
    private JList streamList;
    private JList typeList;
    
    private CourseListener courseListener;
    
    private JDateChooser dateChooserStartDate;
    
    private JDateChooser dateChooserEndDate;
    
    private JButton okCourseButton;
    
    private Color color;
    
    
    public CoursePanel(){
        
        Dimension dim=getPreferredSize();
        dim.width=250;
        setPreferredSize(dim);
        
        nameOfCourseLabel = new JLabel("Course Name: ");        
        startDateLabel = new JLabel("Start_Date: ");
        endDateLabel = new JLabel("End_Date: ");
        
        nameOfCourseTextField = new JTextField(10);        
        
        dateChooserStartDate = new JDateChooser();
        dateChooserStartDate.setDateFormatString("dd/MM/yy");
        
        dateChooserEndDate = new JDateChooser();
        dateChooserEndDate.setDateFormatString("dd/MM/yy");
        
        titleList = new JList();        
        
        okCourseButton = new JButton("Add Course");
        
        color = new Color(0xadcff7);
        
        //SET UP LIST BOX FOR TITLE////////
        DefaultListModel titleOfCourse=new DefaultListModel();
        titleOfCourse.addElement("C1_Java_FT");
        titleOfCourse.addElement("C2_CSharp_FT");
        titleOfCourse.addElement("C3_Java_PT");  
        titleOfCourse.addElement("C4_CSharp_PT");        
        
        titleList.setModel(titleOfCourse);
        titleList.setPreferredSize(new Dimension(110, 75));
        titleList.setBorder(BorderFactory.createEtchedBorder());
        titleList.setSelectedIndex(0);
        
        okCourseButton.setBackground(color);       
        
        okCourseButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String courseName = titleList.getSelectedValue().toString();
                Date startDate = dateChooserStartDate.getDate();
                Date endDate = dateChooserEndDate.getDate();
                
                if(!startDate.equals("")&&!endDate.equals("")){
                    if(courseListener!=null){
                        CourseEvent courseEvent=new CourseEvent(this, courseName, startDate, endDate);
                        courseListener.courseEventOccured(courseEvent);                    
                    }                
                }                
            }       
        });       
        
        Border innerBorder=BorderFactory.createTitledBorder("Add Course");
        Border outerBorder=BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        dateChooserStartDate.getJCalendar().setPreferredSize(new Dimension(300,200));
        dateChooserEndDate.getJCalendar().setPreferredSize(new Dimension(300,200));
        
        layoutComponents();   
    }
    
    public void layoutComponents(){
        setLayout(new GridBagLayout());
        GridBagConstraints gc=new GridBagConstraints();
        
        //FIRST LINE////////
        gc.gridy=0;
        
        gc.gridx=0;
        
        gc.weightx=1;
        gc.weighty=0.1;
        gc.fill=GridBagConstraints.NONE;
        gc.anchor=GridBagConstraints.LINE_END;
        gc.insets=new Insets(0,0,0,5);
        add(nameOfCourseLabel,gc);
        
        gc.gridx=1;
        gc.gridy=0;
        gc.anchor=GridBagConstraints.LINE_START;
        gc.insets=new Insets(0,0,0,0);
        add(titleList,gc);        
        
        //NEXT LINE///////
        
        gc.gridy++;
        
        gc.gridx=0;
        gc.anchor=GridBagConstraints.LINE_END;
        gc.insets=new Insets(0,0,0,5);
        add(startDateLabel, gc);
        
        gc.gridx=1;
        
        gc.weightx=1;
        gc.weighty=0.1;
        gc.anchor=GridBagConstraints.LINE_START;
        gc.insets=new Insets(0,0,0,0);
        add(dateChooserStartDate, gc);
        
        //NEXT LINE///////
        
        gc.gridy++;
        
        gc.gridx=0;
        gc.anchor=GridBagConstraints.LINE_END;
        gc.insets=new Insets(0,0,0,5);
        add(endDateLabel, gc);
        
        gc.gridx=1;
        
        gc.weightx=1;
        gc.weighty=0.1;
        gc.anchor=GridBagConstraints.LINE_START;
        gc.insets=new Insets(0,0,0,0);
        add(dateChooserEndDate, gc);
        
        
        //NEXT LINE///////
        
        gc.gridy++;
        
        gc.gridx=1;
        
        gc.weightx=1;
        gc.weighty=2.0;
        gc.anchor=GridBagConstraints.FIRST_LINE_START;
        add(okCourseButton, gc);    
    }   
    
    public void setCourseListener(CourseListener courseListener){
        this.courseListener = courseListener;    
    }
}
    
    
    
    

