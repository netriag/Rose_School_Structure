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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class AssignmentPanel extends JPanel{
    
    
    
    private JLabel TitleOfAsiignmentLabel;
    private JLabel DescriptionOfAssignmentLabel;
    private JLabel submissionDateTimeLabel;
    private JLabel submittedDateLabel;
    private JLabel oralMarkLabel;
    private JLabel totalMarkLabel;
    private JLabel stFirstName;
    private JLabel stLastName;
    private JLabel stDateOfBirth;   
    
    private JTextField DescriptionOfAssignmenTextField;    
    private JTextField oralMarkLTextField;
    private JTextField totalMarkTextField;
    private JTextField stFirstNameTextField;
    private JTextField stLastNameTextField;
    private JComboBox assignmentCombo;
    
    private JDateChooser dateTimeChooser;    
    private JDateChooser dateOfBirth;    
    private JDateChooser submittedDate;
    
    private JButton okAssignmentButton;
    
    private AssignmentListener assignmentListener;
    
    private Color color;
    
    
    public AssignmentPanel(){
        
        Dimension dim=getPreferredSize();
        dim.width=250;
        setPreferredSize(dim);
        
        TitleOfAsiignmentLabel = new JLabel("Title: ");
        DescriptionOfAssignmentLabel = new JLabel("Description: ");
        submissionDateTimeLabel = new JLabel("Submission_Deadline: ");
        submittedDateLabel=new JLabel("Date_Submitted");
        oralMarkLabel = new JLabel("Oral_Mark: ");
        totalMarkLabel = new JLabel("Total_Mark: ");
        stFirstName = new JLabel("Student_FisrtName: ");
        stLastName = new JLabel("Student_Last Name: ");
        stDateOfBirth = new JLabel("Student_Date of Birth: ");       
        
        DescriptionOfAssignmenTextField =new JTextField( "Course Name for Students with 2 courses ONLY",10);       
        
  
        
        oralMarkLTextField = new JTextField("<=50",10);
        totalMarkTextField = new JTextField("MUST BE NULL",10); 
        stFirstNameTextField = new JTextField(10);
        stLastNameTextField = new JTextField(10);
        
        dateTimeChooser =  new JDateChooser();
        dateTimeChooser.setDateFormatString("dd/MM/yy");
     
        dateOfBirth = new JDateChooser();
        dateOfBirth.setDateFormatString("dd/MM/yy");   
        
        submittedDate=new JDateChooser();
        submittedDate.setDateFormatString("dd/MM/yy");
        
        assignmentCombo = new JComboBox();
        
        okAssignmentButton=new JButton("Add Assignment");
        
        color = new Color(0xadcff7);
        
        okAssignmentButton.setBackground(color);
        
        //SET UP COMBO BOX FOR COURSE////////
        DefaultComboBoxModel assignmentModel=new DefaultComboBoxModel();
        assignmentModel.addElement("Assignment_1");
        assignmentModel.addElement("Assignment_2");        
        assignmentModel.addElement("Assignment_3");        
        assignmentModel.addElement("Assignment_4"); 
        assignmentModel.addElement("Assignment_5"); 
        assignmentModel.addElement("Project_1"); 
        assignmentModel.addElement("Project_2"); 
        
        assignmentCombo.setModel(assignmentModel);
        assignmentCombo.setSelectedIndex(0);
        assignmentCombo.setEditable(false);
        
        okAssignmentButton.addActionListener(new ActionListener()  {
            public void actionPerformed(ActionEvent e) {                                          
                String title  = assignmentCombo.getSelectedItem().toString();
                String description= DescriptionOfAssignmenTextField.getText();
                
                Date subDateTime=null;
                Date birthDate=null;
                Date submitted=null;
                float oralMarkAssign=0.0f;
                float totalMarkAssign=0.0f;
                
                
                String oralMark = oralMarkLTextField.getText();
                String totalMark = totalMarkTextField.getText();
                String stFirstName = "";
                String stLastName = "";                                
                
                if(StaticMethods.compareDates(dateTimeChooser.getDate(), submittedDate.getDate())){                    
                    Float f=100.0f-Float.parseFloat(oralMarkLTextField.getText());
                    Random random=new Random();                          
                    totalMarkTextField.setText(Float.toString(random.nextInt((int) ((f)+1.0f))+Float.parseFloat((oralMark))));
                    //System.out.println("Total Mark: "+totalMarkTextField.getText());
                    if(Float.parseFloat(totalMarkTextField.getText())>100||Float.parseFloat(totalMarkTextField.getText())<0.0){
                        System.out.println("Please enter valid Total Mark(Total Mark must not exceed 100 points!)");               
                    }
                    else{
                        
                        totalMarkAssign=Float.parseFloat(totalMarkTextField.getText());                          
                    }              
                }
                else{
                    System.out.println("Assignment not accepted - Overdue: Please contact your tutor");
                    totalMarkAssign=0;
                }
                
                if(!StaticMethods.isLetter(stFirstNameTextField.getText())){
                    System.out.println("Enter valid First Name!");                
                }
                else{
                    stFirstName=stFirstNameTextField.getText();                
                }
                
                if(!StaticMethods.isLetter(stLastNameTextField.getText())){
                    System.out.println("Enter valid Last Name!");                
                }
                else{
                    stLastName=stLastNameTextField.getText();                
                }
                
                if(dateTimeChooser.getDate()==null){
                    throw new NullPointerException("ENTER VALID DATE WITH THE CALENDAR!\n\n");                    
                }
                else{
                subDateTime = dateTimeChooser.getDate();
                }
                
                if(dateOfBirth.getDate()==null){
                    throw new NullPointerException("ENTER VALID DATE WITH THE CALENDAR!\n\n");                    
                }
                else{
                birthDate = dateOfBirth.getDate();
                }   
                
                if(submittedDate.getDate()==null){
                    throw new NullPointerException("ENTER VALID DATE WITH THE CALENDAR!\n\n");                    
                }
                else{
                submitted = submittedDate.getDate();
                } 
                
                if(!StaticMethods.isNumber(oralMarkLTextField.getText())){
                    throw new NumberFormatException ("INSERT CORRECT NUMBER FORMAT!\n\n");                    
                }                
                else{
                Float.parseFloat(oralMarkLTextField.getText());    
                }
                
                if(!StaticMethods.isNumber(totalMarkTextField.getText())){
                    throw new NumberFormatException ("INSERT CORRECT NUMBER FORMAT!\n\n");    
                    
                }                
                else{
                Float.parseFloat(totalMarkTextField.getText());    
                }
                
                if(Float.parseFloat(oralMarkLTextField.getText())>50||Float.parseFloat(oralMarkLTextField.getText())<0.0){
                    System.out.println("Please enter valid Oral Mark(Oral Mark must not exceed 50 points!)");                
                }
                else{
                    oralMarkAssign=Float.parseFloat(oralMarkLTextField.getText());                
                }
                
                if(Float.parseFloat(totalMarkTextField.getText())>100||Float.parseFloat(totalMarkTextField.getText())<0.0){
                    System.out.println("Please enter valid Total Mark(Total Mark must not exceed 100 points!)");               
                }
                else{
                    totalMarkAssign=Float.parseFloat(totalMarkTextField.getText()); 
                }
                WeekFields weekFields = WeekFields.of(Locale.getDefault()); 
                int weekNumber = StaticMethods.convertToLocalDateViaInstant(dateTimeChooser.getDate()).get(weekFields.weekOfWeekBasedYear());
                //System.out.println(weekNumber);
                
                
                if( birthDate!=null&&subDateTime!=null&&submitted!=null&&oralMarkAssign!=0.0f
                        &&totalMarkAssign!=0.0f&&StaticMethods.isLetter(stFirstNameTextField.getText())&&StaticMethods.isLetter(stLastNameTextField.getText())){                           
                    AssignmentEvent assignmentEvent=new AssignmentEvent(this,title,description,submitted,oralMarkAssign,totalMarkAssign,
                        stFirstName,stLastName, birthDate, weekNumber, subDateTime) ;                
                    if (assignmentListener!=null){                    
                        assignmentListener.assignmentEventOccured(assignmentEvent);  
                        totalMarkTextField.setText("MUST BE NULL");
                        
                        }
                }    
                      
                else{
                        System.out.println("All the fields must be filled in! Try again!");
                }               
            }       
        }) ;
        
        
        
        
        //int weekNumber2 = endDateLocal.get(weekFields.weekOfWeekBasedYear());
        
        Border innerBorder=BorderFactory.createTitledBorder("Add Assignment");
        Border outerBorder=BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        dateOfBirth.getJCalendar().setPreferredSize(new Dimension(300,200));
        dateTimeChooser.getJCalendar().setPreferredSize(new Dimension(300,200));
        submittedDate.getJCalendar().setPreferredSize(new Dimension(300,200));
        
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
        add(TitleOfAsiignmentLabel,gc);
        
        gc.gridx=1;
        gc.gridy=0;
        gc.anchor=GridBagConstraints.LINE_START;
        gc.insets=new Insets(0,0,0,0);
        add(assignmentCombo,gc);
        
        //SECOND LINE//////
        gc.gridy++;
        
        gc.gridx=0;
        
        gc.weightx=1;
        gc.weighty=0.1;
        gc.anchor=GridBagConstraints.LINE_END;
        gc.insets=new Insets(0,0,0,5);
        add(DescriptionOfAssignmentLabel, gc);
        
        gc.gridx=1;
        gc.gridy=1;
        gc.anchor=GridBagConstraints.LINE_START;
        gc.insets=new Insets(0,0,0,0);
        add(DescriptionOfAssignmenTextField, gc);
        
        //NEXT LINE///////
        gc.gridy++;
        
        gc.gridx=0;
        gc.anchor=GridBagConstraints.LINE_END;
        gc.insets=new Insets(0,0,0,5);
        add(submissionDateTimeLabel, gc);
        
        gc.gridx=1;
        
        gc.weightx=1;
        gc.weighty=0.1;
        gc.anchor=GridBagConstraints.LINE_START;
        gc.insets=new Insets(0,0,0,0);
        add(dateTimeChooser, gc);   
        
        
        //NEXT LINE///////
        gc.gridy++;
        
        gc.gridx=0;
        gc.anchor=GridBagConstraints.LINE_END;
        gc.insets=new Insets(0,0,0,5);
        add(submittedDateLabel, gc);
        
        gc.gridx=1;
        
        gc.weightx=1;
        gc.weighty=0.1;
        gc.anchor=GridBagConstraints.LINE_START;
        gc.insets=new Insets(0,0,0,0);
        add(submittedDate, gc); 
        
        //NEXT LINE///////
        
        gc.gridy++;
        
        gc.gridx=0;
        gc.anchor=GridBagConstraints.LINE_END;
        gc.insets=new Insets(0,0,0,5);
        add(oralMarkLabel, gc);
        
        gc.gridx=1;
        
        gc.weightx=1;
        gc.weighty=0.1;
        gc.anchor=GridBagConstraints.LINE_START;
        gc.insets=new Insets(0,0,0,0);
        add(oralMarkLTextField, gc);
        
        //NEXT LINE///////
        
        gc.gridy++;
        
        gc.gridx=0;
        gc.anchor=GridBagConstraints.LINE_END;
        gc.insets=new Insets(0,0,0,5);
        add(totalMarkLabel, gc);
        
        gc.gridx=1;
        
        gc.weightx=1;
        gc.weighty=0.1;
        gc.anchor=GridBagConstraints.LINE_START;
        gc.insets=new Insets(0,0,0,0);
        add(totalMarkTextField, gc);
        
        //NEXT LINE///////
        
        gc.gridy++;
        
        gc.gridx=0;
        gc.anchor=GridBagConstraints.LINE_END;
        gc.insets=new Insets(0,0,0,5);
        add(stFirstName, gc);
        
        gc.gridx=1;
        
        gc.weightx=1;
        gc.weighty=0.1;
        gc.anchor=GridBagConstraints.LINE_START;
        gc.insets=new Insets(0,0,0,0);
        add(stFirstNameTextField, gc);
        
        //NEXT LINE///////
        
        gc.gridy++;
        
        gc.gridx=0;
        gc.anchor=GridBagConstraints.LINE_END;
        gc.insets=new Insets(0,0,0,5);
        add(stLastName, gc);
        
        gc.gridx=1;
        
        gc.weightx=1;
        gc.weighty=0.1;
        gc.anchor=GridBagConstraints.LINE_START;
        gc.insets=new Insets(0,0,0,0);
        add(stLastNameTextField, gc);
        
        //NEXT LINE///////
        
        gc.gridy++;
        
        gc.gridx=0;
        gc.anchor=GridBagConstraints.LINE_END;
        gc.insets=new Insets(0,0,0,5);
        add(stDateOfBirth, gc);
        
        gc.gridx=1;
        
        gc.weightx=1;
        gc.weighty=0.1;
        gc.anchor=GridBagConstraints.LINE_START;
        gc.insets=new Insets(0,0,0,0);
        add(dateOfBirth, gc);
        
        //NEXT LINE///////
        
        gc.gridy++;
        
        gc.gridx=1;
        
        gc.weightx=1;
        gc.weighty=2.0;
        gc.anchor=GridBagConstraints.FIRST_LINE_START;
        gc.insets=new Insets(0,0,0,0);
        add(okAssignmentButton, gc);    
    }      
    
    public void setAssignmentListener(AssignmentListener assignmentListener){
        this.assignmentListener=assignmentListener;    
    }
}