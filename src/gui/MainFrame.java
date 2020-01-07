package gui;

import model.GiveADate;
import controller.Controller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import model.Trainer;

public class MainFrame extends JFrame{
    
    private JButton viewListOfAllCourses;   
    private JButton viewListOfAllStudents;
    private JButton viewListOfAllTrainers;   
    private JButton viewListOfAllAsignments;

    private CoursePanel coursePanel;
    private StudentPanel studentPanel;
    private TrainerPanel trainerPanel;
    private AssignmentPanel assignmentPanel;    
    
    private Color color1;
    private Color color2;
    private Color color3;
     
    private Controller controller;    
    
    private GiveADate giveADate;      
    
    private JPanel viewListsOfClassesButtons;
    private JPanel JPaneClassesbuttons;
    
    
    
    public MainFrame(){
        super("Rose School Structure");   
        
        /////Initialization////////////
        viewListOfAllCourses = new JButton("View List of All Courses");         
        viewListOfAllStudents = new JButton("View List of All Students");        
        viewListOfAllTrainers = new JButton("View List of All Trainers");        
        viewListOfAllAsignments = new JButton("View List of All Assignments");
        
        coursePanel = new CoursePanel();
        studentPanel = new StudentPanel();
        trainerPanel = new TrainerPanel(); 
        assignmentPanel =new AssignmentPanel();                              
                
        viewListsOfClassesButtons = new JPanel();
        JPaneClassesbuttons = new JPanel();  
        
        controller = new Controller();
        
        color1 = new Color(0xadcff7);
        color2 = new Color(0xf1f8fd);
        color3 = new Color(0xcdeebe);
        
        viewListsOfClassesButtons.setLayout(new GridLayout(1,4,20,20));
        JPaneClassesbuttons.setLayout(new GridLayout(1,4,20,20));          
        
        viewListsOfClassesButtons.setBackground(color3);
        JPaneClassesbuttons.setBackground(color3);  
        viewListOfAllCourses.setBackground(color1);
        viewListOfAllStudents.setBackground(color1);       
        viewListOfAllTrainers.setBackground(color1);
        viewListOfAllAsignments.setBackground(color1);
        coursePanel.setBackground(color2);
        studentPanel.setBackground(color2);
        trainerPanel.setBackground(color2);
        assignmentPanel.setBackground(color2);
        
        viewListsOfClassesButtons.add(viewListOfAllCourses);
        viewListsOfClassesButtons.add(viewListOfAllStudents);
        viewListsOfClassesButtons.add(viewListOfAllTrainers);
        viewListsOfClassesButtons.add(viewListOfAllAsignments);              
        
        JPaneClassesbuttons.add(coursePanel);
        JPaneClassesbuttons.add(studentPanel);
        JPaneClassesbuttons.add(trainerPanel);
        JPaneClassesbuttons.add(assignmentPanel);                  
        
        trainerPanel.setTrainerListener(new TrainerListener(){            
            @Override
            public void trainerEventOccured(TrainerEvent e){
                try {                                     
                    controller.addTrainer(e);
                } catch (Exception ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        });
        
        studentPanel.setStudentListener(new StudentListener(){            
            @Override
            public void studentEventOccured(StudentEvent e){
                try {                                    
                    controller.addStudent(e);
                } catch (Exception ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        });      
        
        coursePanel.setCourseListener(new CourseListener(){
            @Override
            public void courseEventOccured(CourseEvent e) {
                controller.addCourse(e);
            }           
        });        
        
        assignmentPanel.setAssignmentListener(new AssignmentListener(){
            @Override
            public void assignmentEventOccured(AssignmentEvent ae) {
                try {               
                    controller.addAssignment(ae);
                } catch (Exception ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }           
        });
        
        studentPanel.setGiveADateListener(new StudentGiveADateListener(){
            @Override
            public void giveADateOccurred(int weekNumber) {
                  for(int i=0; i<controller.getGiveADateIntegerArrayList(weekNumber).size(); i++) {
                      System.out.println(controller.getGiveADateIntegerArrayList(weekNumber).get(i).toString3());
                  }
            }       
        });        
        
        viewListOfAllTrainers.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {                
                for(int i=0; i<controller.getTrainersList().size(); i++){                    
                    System.out.println(controller.getTrainersList().get(i));                
                }                
            }       
        });
        
        viewListOfAllStudents.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                for(int i=0; i<controller.getStudentsList().size(); i++){
                    System.out.println(controller.getStudentsList().get(i));
                }                           
            }       
        });
        
        viewListOfAllCourses.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                for(int i=0; i<controller.getCoursesList().size(); i++){
                    System.out.println(controller.getCoursesList().get(i));                
                }                
            }            
        });
        
        viewListOfAllAsignments.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                for(int i=0; i<controller.getAssignmentsList().size();i++){
                    System.out.println(controller.getAssignmentsList().get(i));                
                }              
            }           
        });
        
        
        
        
        
        add(JPaneClassesbuttons, BorderLayout.CENTER);           
        add(viewListsOfClassesButtons, BorderLayout.SOUTH);
        
        //////MENU BAR/////////
        setJMenuBar(createMenuBar());
        
        ////Dimensions///////////    
        setMinimumSize(new Dimension(1000,300)); 
        setSize(1200,400);
        setLocation(400,200);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true); 
    }
    
    protected JMenuBar createMenuBar(){
        
        JMenuBar menuBar=new JMenuBar();        
        
        JMenu applicationMenu=new JMenu("Application Data");          
        JMenu DataMenu = new JMenu("Data");        
        //JMenuItem dateItem = new JMenuItem("Enter a date!");
        JMenuItem exitItem = new JMenuItem("Exit Application");       
        
        menuBar.add(applicationMenu);
        applicationMenu.add(DataMenu);
        //applicationMenu.add(dateItem);
        applicationMenu.addSeparator(); 
        applicationMenu.add(exitItem);        
        JCheckBoxMenuItem showFormItem=new JCheckBoxMenuItem("Data Entry");        
        DataMenu.add(showFormItem);      
        
        showFormItem.setSelected(true);
        
        showFormItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev) {
                JCheckBoxMenuItem menuItem=(JCheckBoxMenuItem)ev.getSource();
                JPaneClassesbuttons.setVisible(menuItem.isSelected());   
                if(!menuItem.isSelected()){
                    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        controller.addCourse(new CourseEvent(this,"C1_Java_FT",df.parse("15/10/2019"), df.parse("15/02/2020")));
                        controller.addCourse(new CourseEvent(this,"C2_CSharp_FT",df.parse("16/10/2019"), df.parse("16/02/2020")));
                        controller.addCourse(new CourseEvent(this,"C3_Java_PT",df.parse("15/10/2019"), df.parse("15/05/2020")));
                        controller.addCourse(new CourseEvent(this,"C4_CSharp_PT",df.parse("16/10/2019"), df.parse("16/05/2020")));
                        
                        controller.addTrainer(new TrainerEvent(this, "Nikos", "Trianta","Java_C1_FT"));
                        controller.addTrainer(new TrainerEvent(this, "Ilias",  "Giakoumatos","C#_C2_FT"));
                        controller.addTrainer(new TrainerEvent(this,  "Kostas", "Alivizatos","C#_C2_FT"));
                        controller.addTrainer(new TrainerEvent(this,  "Effrossini", "Kountiou","Java_C1_FT"));
                        controller.addTrainer(new TrainerEvent(this,  "Petros", "Nikou","C#_C4_PT"));
                        controller.addTrainer(new TrainerEvent(this,  "Giorgos", "Karakitsos","Java_C1_FT"));
                        controller.addTrainer(new TrainerEvent(this,  "Dimitris", "Nasou","Java_C3_PT"));
                        controller.addTrainer(new TrainerEvent(this, "Christos", "Petrou","C#_C2_FT"));
                        controller.addTrainer(new TrainerEvent(this,  "Giannis", "Gavrielatos","C#_C4_PT"));
                        
                        
                        controller.addStudent(new StudentEvent(this, "Nikos","Trianta", df.parse("25/07/1980"), "Java_Full_Time", 2500));
                        controller.addStudent(new StudentEvent(this, "Kostas","Alivizatos", df.parse("25/07/1981"), "C#_Full_Time", 2500));
                        controller.addStudent(new StudentEvent(this, "Effrossini","Giakoumatou", df.parse("27/07/1980"), "Java_Part_Time", 2000));
                        controller.addStudent(new StudentEvent(this, "Ilias","Gavrielatos", df.parse("25/09/1980"), "C#_Part_Time", 2000));
                        controller.addStudent(new StudentEvent(this, "Kostas","Theokleous", df.parse("26/07/1990"), "Java_Full_Time", 2500));
                        controller.addStudent(new StudentEvent(this, "Petros","Gavrielatos", df.parse("25/07/1991"), "Java_Full_Time", 2500));
                        controller.addStudent(new StudentEvent(this, "Giannis","Papatheodorou", df.parse("25/08/1995"), "Java_Full_Time", 2500));
                        controller.addStudent(new StudentEvent(this, "Nikos","Karakitsos",  df.parse("08/07/1989"), "Java_Full_Time", 2500));
                        controller.addStudent(new StudentEvent(this, "Effrossini","Giannaki", df.parse("15/07/1987"), "C#_Full_Time", 2500));
                        controller.addStudent(new StudentEvent(this, "Kostas", "Pesmazoglou", df.parse("17/11/1986"), "Java_Part_Time", 2000));
                        controller.addStudent(new StudentEvent(this,  "Ilias", "Zafiratos", df.parse("25/07/2000"), "C#_Full_Time", 2000));
                        controller.addStudent(new StudentEvent(this, "Giorgos","Giakoumatos", df.parse("21/04/1987"), "Java_Full_Time", 2500));
                        controller.addStudent(new StudentEvent(this, "Zisis","Theodorou", df.parse("16/02/1999"), "Java_Full_Time", 2500));
                        controller.addStudent(new StudentEvent(this, "Anna","Papavasiliou", df.parse("16/10/1996"), "C#_Part_Time", 2500));
                        controller.addStudent(new StudentEvent(this, "Dimitris","Kostios", df.parse("06/01/1995"), "Java_Part_Time", 2000));
                        controller.addStudent(new StudentEvent(this, "Giorgos","Papacharalampous", df.parse("06/01/2000"), "C#_Full_Time", 2000));
                        controller.addStudent(new StudentEvent(this, "Giannis", "Theotokatos",df.parse("19/03/1979"), "Java_Full_Time", 2500));
                        controller.addStudent(new StudentEvent(this, "Dimitris","Manolatos", df.parse("18/06/1975"), "Java_Full_Time", 2500));
                        controller.addStudent(new StudentEvent(this, "Nikos","Trianta", df.parse("25/07/1980"), "C#_Part_Time", 2000));
                        controller.addStudent(new StudentEvent(this, "Antonis","Ampoutis", df.parse("14/12/1976"), "Java_Full_Time", 2500));
                        
                                      
                        controller.addAssignment(new AssignmentEvent(this, "Assignment_1","Java_Full_Time", df.parse("01/12/2019"),45,0,"Nikos", "Trianta",df.parse("25/07/1980"), 50, df.parse("15/12/2019")));
                        controller.addAssignment(new AssignmentEvent(this, "Assignment_2","Java_Full_Time", df.parse("31/12/2019"),44,0,"Nikos", "Trianta",df.parse("25/07/1980"), 5, df.parse("30/01/2020")));
                        controller.addAssignment(new AssignmentEvent(this, "Assignment_3","Java_Full_Time", df.parse("30/01/2020"),43,0,"Nikos", "Trianta",df.parse("25/07/1980"),11, df.parse("15/03/2020")));
                        controller.addAssignment(new AssignmentEvent(this, "Assignment_1","", df.parse("30/11/2019"),45,0,"Kostas", "Theokleous",df.parse("26/07/1990"), 48, df.parse("02/12/2019")));
                        controller.addAssignment(new AssignmentEvent(this, "Assignment_2","", df.parse("30/12/2019"),44,0,"Kostas", "Theokleous",df.parse("26/07/1990"), 1, df.parse("02/01/2020")));
                        controller.addAssignment(new AssignmentEvent(this, "Assignment_3","", df.parse("25/01/2020"),43,0,"Kostas", "Theokleous",df.parse("26/07/1990"), 5, df.parse("02/02/2020")));
                        controller.addAssignment(new AssignmentEvent(this, "Assignment_1","", df.parse("20/11/2019"),45,0,"Petros", "Gavrielatos",df.parse("25/07/1991"), 48, df.parse("02/12/2019")));
                        controller.addAssignment(new AssignmentEvent(this, "Assignment_2","", df.parse("20/12/2019"),44,0,"Petros", "Gavrielatos",df.parse("25/07/1991"), 1, df.parse("02/01/2020")));
                        controller.addAssignment(new AssignmentEvent(this, "Assignment_3","", df.parse("25/01/2020"),43,0,"Petros", "Gavrielatos",df.parse("25/07/1991"), 5, df.parse("02/02/2020")));
                        controller.addAssignment(new AssignmentEvent(this, "Assignment_3","", df.parse("25/01/2020"),43,0,"Kostas", "Theokleous",df.parse("26/07/1990"), 5, df.parse("02/02/2020")));
                        controller.addAssignment(new AssignmentEvent(this, "Assignment_1","", df.parse("21/11/2019"),45,0,"Giannis", "Papatheodorou",df.parse("25/08/1995"), 48, df.parse("02/12/2019")));
                        controller.addAssignment(new AssignmentEvent(this, "Assignment_2","", df.parse("21/12/2019"),44,0,"Giannis", "Papatheodorou",df.parse("25/08/1995"), 1, df.parse("02/01/2020")));
                        controller.addAssignment(new AssignmentEvent(this, "Assignment_3","", df.parse("21/01/2020"),43,0,"Giannis", "Papatheodorou",df.parse("25/08/1995"), 5, df.parse("02/02/2020")));
                        controller.addAssignment(new AssignmentEvent(this, "Assignment_1","", df.parse("21/11/2019"),45,0,"Nikos", "Karakitsos",df.parse("08/07/1989"), 48, df.parse("02/12/2019")));
                        controller.addAssignment(new AssignmentEvent(this, "Assignment_2","", df.parse("21/12/2019"),44,0,"Nikos", "Karakitsos",df.parse("08/07/1989"), 1, df.parse("02/01/2020")));
                        controller.addAssignment(new AssignmentEvent(this, "Assignment_3","", df.parse("21/01/2020"),43,0,"Nikos", "Karakitsos",df.parse("08/07/1989"), 5, df.parse("02/02/2020")));
                        controller.addAssignment(new AssignmentEvent(this, "Assignment_1","CSharp_Part_Time", df.parse("21/11/2019"),45,0,"Nikos", "Trianta",df.parse("25/07/1980"), 48, df.parse("02/12/2019")));
                        controller.addAssignment(new AssignmentEvent(this, "Assignment_2","CSharp_Part_Time", df.parse("30/12/2019"),44,0,"Nikos", "Trianta",df.parse("25/07/1980"), 1, df.parse("02/01/2020")));
                        controller.addAssignment(new AssignmentEvent(this, "Assignment_3","CSharp_Part_Time", df.parse("25/01/2020"),43,0,"Nikos", "Trianta",df.parse("25/07/1980"), 5, df.parse("02/02/2020")));
                        controller.addAssignment(new AssignmentEvent(this, "Assignment_1","", df.parse("30/11/2019"),45,0,"Kostas", "Alivizatos",df.parse("25/07/1981"), 48, df.parse("02/12/2019")));
                        controller.addAssignment(new AssignmentEvent(this, "Assignment_2","", df.parse("30/12/2019"),44,0,"Kostas", "Alivizatos",df.parse("25/07/1981"), 1, df.parse("02/01/2020")));
                        controller.addAssignment(new AssignmentEvent(this, "Assignment_3","", df.parse("25/01/2020"),43,0,"Kostas", "Alivizatos",df.parse("25/07/1981"), 5, df.parse("02/02/2020")));
                        controller.addAssignment(new AssignmentEvent(this, "Assignment_1","", df.parse("30/11/2019"),45,0,"Effrossini", "Giannaki",df.parse("15/07/1987"), 48, df.parse("02/12/2019")));
                        controller.addAssignment(new AssignmentEvent(this, "Assignment_2","", df.parse("30/12/2019"),44,0,"Effrossini", "Giannaki",df.parse("15/07/1987"), 1, df.parse("02/01/2020")));
                        controller.addAssignment(new AssignmentEvent(this, "Assignment_3","", df.parse("25/01/2020"),43,0,"Effrossini", "Giannaki",df.parse("15/07/1987"), 5, df.parse("02/02/2020")));
                        controller.addAssignment(new AssignmentEvent(this, "Assignment_1","", df.parse("30/11/2019"),45,0,"Ilias", "Zafiratos",df.parse("25/07/2000"), 48, df.parse("02/12/2019")));
                        controller.addAssignment(new AssignmentEvent(this, "Assignment_2","", df.parse("30/12/2019"),44,0,"Ilias", "Zafiratos",df.parse("25/07/2000"), 1, df.parse("02/01/2020")));
                        controller.addAssignment(new AssignmentEvent(this, "Assignment_3","", df.parse("25/01/2020"),43,0,"Ilias", "Zafiratos",df.parse("25/07/2000"), 5, df.parse("02/02/2020")));
                        controller.addAssignment(new AssignmentEvent(this, "Assignment_1","", df.parse("01/12/2019"),45,0,"Dimitris", "Kostios",df.parse("06/01/1995"), 50, df.parse("15/12/2019")));
                        controller.addAssignment(new AssignmentEvent(this, "Assignment_2","", df.parse("31/12/2019"),44,0,"Dimitris", "Kostios",df.parse("06/01/1995"), 5, df.parse("30/01/2020")));
                        controller.addAssignment(new AssignmentEvent(this, "Assignment_3","", df.parse("30/01/2020"),43,0,"Dimitris", "Kostios",df.parse("06/01/1995"),11, df.parse("15/03/2020")));
                        controller.addAssignment(new AssignmentEvent(this, "Assignment_1","", df.parse("01/12/2019"),45,0,"Effrossini", "Giakoumatou",df.parse("27/07/1980"), 50, df.parse("15/12/2019")));
                        controller.addAssignment(new AssignmentEvent(this, "Assignment_2","", df.parse("31/12/2019"),44,0,"Effrossini", "Giakoumatou",df.parse("27/07/1980"), 5, df.parse("30/01/2020")));
                        controller.addAssignment(new AssignmentEvent(this, "Assignment_3","", df.parse("30/01/2020"),43,0,"Effrossini", "Giakoumatou",df.parse("27/07/1980"),11, df.parse("15/03/2020")));
                        controller.addAssignment(new AssignmentEvent(this, "Assignment_1","", df.parse("01/12/2019"),45,0,"Anna", "Papavasiliou",df.parse("16/10/1996"), 50, df.parse("15/12/2019")));
                        controller.addAssignment(new AssignmentEvent(this, "Assignment_2","", df.parse("31/12/2019"),44,0,"Anna", "Papavasiliou",df.parse("16/10/1996"), 5, df.parse("30/01/2020")));
                        controller.addAssignment(new AssignmentEvent(this, "Assignment_3","", df.parse("30/01/2020"),43,0,"Anna", "Papavasiliou",df.parse("16/10/1996"),11, df.parse("15/03/2020")));
                        
                        
                    } catch (ParseException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                }
            }                 
        });
        
        JMenu combinationMenu = new JMenu("Combination Lists");
        JMenu studentsMenu = new JMenu("Students");
        JMenuItem studentsPerCourse = new JMenuItem("Students per Course");
        JMenuItem studentsInMultipleCourses = new JMenuItem("Students in multiple Courses");
        JMenu assignmentsMenu = new JMenu("Assignments");
        JMenuItem assignmentsPerCourse = new JMenuItem("Assignments per Course");
        JMenuItem asignmentsPerStudent = new JMenuItem("Assignments per Student");
        JMenuItem trainersPerCourse = new JMenuItem("Trainers per Course");
        
        combinationMenu.add(studentsMenu);
        combinationMenu.add(assignmentsMenu);
        combinationMenu.add(trainersPerCourse);
        studentsMenu.add(studentsPerCourse);
        studentsMenu.add(studentsInMultipleCourses);
        assignmentsMenu.add(assignmentsPerCourse);
        assignmentsMenu.add(asignmentsPerStudent);
        menuBar.add(combinationMenu);
        
        applicationMenu.setFont(new Font("Times Roman", Font.BOLD, 12));
        combinationMenu.setFont(new Font("Times Roman", Font.BOLD, 12));
        
        menuBar.setBackground(color3);
        
        ///////SET MNEMONICS - ACCELERATORS
        applicationMenu.setMnemonic(KeyEvent.VK_A);
        exitItem.setMnemonic(KeyEvent.VK_X); 
        combinationMenu.setMnemonic(KeyEvent.VK_C);
        
        DataMenu.setMnemonic(KeyEvent.VK_D);        
        
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
                ActionEvent.CTRL_MASK));
        
        trainersPerCourse.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                for (int i=0; i<controller.getTrainersPerCourseList().size(); i++){
                    System.out.println(controller.getTrainersPerCourseList().get(i).toString1());                
                }                
            }       
        });        
        
        studentsPerCourse.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                for(int i=0; i<controller.getStudentsPerCourseList().size();i++){
                    System.out.println(controller.getStudentsPerCourseList().get(i).toString1());
                }
            }            
        });
        
        studentsInMultipleCourses.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                for(int i=0; i<controller.getStudentsInMultipleCoursesList().size(); i++){
                    System.out.println(controller.getStudentsInMultipleCoursesList().get(i));                
                }                
            }       
        });
        
        assignmentsPerCourse.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                for(int i=0; i<controller.getAssignmentsPerCourseList().size(); i++){
                    System.out.println(controller.getAssignmentsPerCourseList().get(i).toString1());                
                }
            }         
        });
        
        asignmentsPerStudent.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                for(int i=0; i<controller.getAssignmentsPerStudentList().size(); i++){
                    System.out.println(controller.getAssignmentsPerStudentList().get(i).toString2());
                }                
            }            
        });      
                
        applicationMenu.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e) {
            //applicationMenu.setForeground(Color.BLUE);
            applicationMenu.setFont(new Font("TimesRoman", Font.BOLD, 13));          
            
        }
        });
        
        applicationMenu.addMouseListener(new MouseAdapter(){
            public void mouseExited(MouseEvent e){
            //applicationMenu.setForeground(Color.BLACK);
            applicationMenu.setFont(new Font("TimesRoman", Font.BOLD, 12));
            }                   
        });
        
        combinationMenu.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e) {
            //applicationMenu.setForeground(Color.BLUE);
            applicationMenu.setFont(new Font("TimesRoman", Font.BOLD, 13));          
            
        }
        });
        
        combinationMenu.addMouseListener(new MouseAdapter(){
            public void mouseExited(MouseEvent e){
            //applicationMenu.setForeground(Color.BLACK);
            applicationMenu.setFont(new Font("TimesRoman", Font.BOLD, 12));
            }                   
        });
        
        exitItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                int action=JOptionPane.showConfirmDialog(MainFrame.this, "Do you really want to exit application?", 
                        "Confirm Exit", JOptionPane.OK_CANCEL_OPTION);
                if (action==JOptionPane.OK_OPTION){
                System.exit(0);
                }
            }
        });        
        return menuBar;
    }
}    
    