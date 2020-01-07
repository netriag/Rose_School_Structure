package gui;

import StaticMethods.StaticMethods;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.temporal.WeekFields;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class StudentPanel extends JPanel { 
    
    private StudentListener studentListener;        
    
    private JLabel studentIdLabel;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel dateOfBirthLabel;
    private JLabel tuitionFeesLabel;
    private JLabel giveADateLabel;
    
    private JLabel courseLabel;    
    
    private JTextField firstNameTextField;
    private JTextField lastNameTextField;    
    private JTextField tuitionFeesField;   
    
    private JComboBox courseCombo;
    
    private JButton giveADateBtn;
    private JButton okStudentButton;
    
    private JDateChooser dateChooser;    
    private JDateChooser giveADateChooser;
    
    private StudentGiveADateListener studentGiveADateListener;
    
    private Color color;
    
    public StudentPanel(){
        
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);
        
        studentIdLabel = new JLabel("StudentId: ");
        lastNameLabel = new JLabel("Last_Name: ");
        firstNameLabel = new JLabel("First_Name: ");        
        dateOfBirthLabel = new JLabel("Date_Of_Birth: ");          
        courseLabel = new JLabel("Course: ");
        tuitionFeesLabel = new JLabel("Tuition_Fees: ");  
        giveADateLabel= new JLabel("Give a Date!");
        
        firstNameTextField = new JTextField(10);
        lastNameTextField = new JTextField(10);        
        tuitionFeesField = new JTextField(10);       
        
        courseCombo = new JComboBox();
        
        giveADateBtn = new JButton("Give a Date Results");
        okStudentButton = new JButton("Add Student");
        
        dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("dd/MM/yy");     
        
        giveADateChooser=new JDateChooser();
        giveADateChooser.setDateFormatString("dd/MM/yy"); 
        
        color = new Color(0xadcff7);       
        
        //SET UP COMBO BOX FOR COURSE////////
        DefaultComboBoxModel courseModel=new DefaultComboBoxModel();
        courseModel.addElement("Java_Full_Time");
        courseModel.addElement("C#_Full_Time");        
        courseModel.addElement("Java_Part_Time");
        courseModel.addElement("C#_Part_Time");       
        
        courseCombo.setModel(courseModel);
        courseCombo.setSelectedIndex(0);
        courseCombo.setEditable(false);
        
        okStudentButton.setBackground(color);
        giveADateBtn.setBackground(new Color(51, 255, 184));
        
        okStudentButton.addActionListener(new ActionListener()  {
            public void actionPerformed(ActionEvent e) {                                             
                String firstName=""; 
                String lastName="";
                Float tuitionFees;
                Date dateOfBirth=null;
                
                if(!StaticMethods.isLetter(firstNameTextField.getText())){                               
                    System.out.println("Enter valid First Name!");                   
                }                
                else{
                    firstName=firstNameTextField.getText();
                }
                
                if(!StaticMethods.isLetter(lastNameTextField.getText())){
                    System.out.println("Enter valid Last Name!");                
                }       
                else{
                     lastName= lastNameTextField.getText();
                }
                
                if(dateChooser.getDate()==null){
                    throw new NullPointerException("ENTER VALID DATE WITH THE CALENDAR!\n\n");                    
                }
                else{
                dateOfBirth = dateChooser.getDate();
                }             
                
                String course = (String) courseCombo.getSelectedItem();  
                
                if(!StaticMethods.isNumber(tuitionFeesField.getText())){
                    throw new NumberFormatException ("INSERT CORRECT NUMBER FORMAT!\n\n");                    
                }                
                else{
                tuitionFees=Float.parseFloat(tuitionFeesField.getText());    
                }              
                
                if(!lastName.equals("")&&!firstName.equals("")&&
                        !dateOfBirth.equals("")&&!course.equals("")&&tuitionFees!=0.0f){                           
                    StudentEvent studentEvent=new StudentEvent(this,firstName,lastName,dateOfBirth,course,tuitionFees) ;                
                    if (studentListener!=null){                    
                        studentListener.studentEventOccured(studentEvent);                      
                        }
                    }
                    else{
                        System.out.println("All the fields must be filled in!");
                    }                    
            }       
        }) ;
        
        giveADateBtn.addActionListener((ActionEvent ae) -> {
            Date giveDate=null;
            
            if(giveADateChooser.getDate()==null){
                throw new NullPointerException("ENTER VALID DATE WITH THE CALENDAR!\n\n");
            }
            else{
                giveDate = giveADateChooser.getDate();
            }
            
            WeekFields weekFields = WeekFields.of(Locale.getDefault());
            int weekNumber = StaticMethods.convertToLocalDateViaInstant(giveDate).get(weekFields.weekOfWeekBasedYear());            
            
            if(giveDate!=null){
                studentGiveADateListener.giveADateOccurred(  weekNumber);
            }
        });
        
        
        
        Border innerBorder=BorderFactory.createTitledBorder("Add Student");
        Border outerBorder=BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        dateChooser.getJCalendar().setPreferredSize(new Dimension(300,200));
        giveADateChooser.getJCalendar().setPreferredSize(new Dimension(300,200));
        
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
        add(firstNameLabel,gc);
        
        gc.gridx=1;
        gc.gridy=0;
        gc.anchor=GridBagConstraints.LINE_START;
        gc.insets=new Insets(0,0,0,0);
        add(firstNameTextField,gc);
        
        //SECOND LINE////////
        gc.gridy++;
        
        gc.gridx=0;
        
        gc.weightx=1;
        gc.weighty=0.1;
        gc.fill=GridBagConstraints.NONE;
        gc.anchor=GridBagConstraints.LINE_END;
        gc.insets=new Insets(0,0,0,5);
        add(lastNameLabel,gc);
        
        gc.gridx=1;
        
        gc.anchor=GridBagConstraints.LINE_START;
        gc.insets=new Insets(0,0,0,0);
        add(lastNameTextField,gc);
        
        //NEXT LINE//////
        gc.gridy++;
        
        gc.gridx=0;
        
        gc.weightx=1;
        gc.weighty=0.1;
        gc.anchor=GridBagConstraints.LINE_END;
        gc.insets=new Insets(0,0,0,5);
        add(dateOfBirthLabel, gc);
        
        gc.gridx=1;
        
        gc.anchor=GridBagConstraints.LINE_START;
        gc.insets=new Insets(0,0,0,0);
        add(dateChooser, gc);
        
        //NEXT LINE///////
        gc.gridy++;
        
        gc.gridx=0;
        gc.anchor=GridBagConstraints.LINE_END;
        gc.insets=new Insets(0,0,0,5);
        add(courseLabel, gc);
        
        gc.gridx=1;
        
        gc.weightx=1;
        gc.weighty=0.1;
        gc.anchor=GridBagConstraints.LINE_START;
        gc.insets=new Insets(0,0,0,0);
        add(courseCombo, gc);          
        
        //NEXT LINE///////
        
        gc.gridy++;
        
        gc.gridx=0;
        gc.anchor=GridBagConstraints.LINE_END;
        gc.insets=new Insets(0,0,0,5);
        add(tuitionFeesLabel, gc);
        
        gc.gridx=1;
        
        gc.weightx=1;
        gc.weighty=0.1;
        gc.anchor=GridBagConstraints.LINE_START;
        gc.insets=new Insets(0,0,0,0);
        add(tuitionFeesField, gc);      
        
        //NEXT LINE///////
        
        gc.gridy++;
        
        gc.gridx=0;
        gc.anchor=GridBagConstraints.LINE_END;
        gc.insets=new Insets(0,0,0,5);
        add(giveADateLabel, gc);
        
        gc.gridx=1;
        
        gc.weightx=1;
        gc.weighty=0.1;
        gc.anchor=GridBagConstraints.LINE_START;
        gc.insets=new Insets(0,0,0,0);
        add(giveADateChooser, gc); 
        
        //NEXT LINE///////
        
        gc.gridy++;
        
        gc.gridx=1;
        
        gc.weightx=1;
        gc.weighty=0.1;
        gc.anchor=GridBagConstraints.LINE_START;
        gc.insets=new Insets(0,0,0,0);
        add(giveADateBtn, gc);
        
        //NEXT LINE///////
        
        gc.gridy++;
        
        gc.gridx=1;
        
        gc.weightx=1;
        gc.weighty=2.0;
        gc.anchor=GridBagConstraints.FIRST_LINE_START;
        gc.insets=new Insets(0,0,0,0);
        add(okStudentButton, gc);
    
    }   

    public void setStudentListener(StudentListener studentListener) {
        this.studentListener = studentListener;
    }       
    
    public void setGiveADateListener(StudentGiveADateListener studentGiveADateListener){
        this.studentGiveADateListener= studentGiveADateListener;    
    }
}
