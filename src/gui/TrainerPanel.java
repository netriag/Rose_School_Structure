 package gui;

import StaticMethods.StaticMethods;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class TrainerPanel extends JPanel{
    
    private JLabel firstNameTrainerLabel;
    private JLabel lastNameTrainerLabel;
    private JLabel subjectLabel;     
    
    private JTextField firstNameTrainerTextField;
    private JTextField lastNameTrainerField;
    private JTextField subjectTextField;    
    
    private TrainerListener trainerListener;   
    
    private JComboBox subjectCombo;
    
    private JButton okTrainerButton;    
    
    private Color color;
    
    public TrainerPanel(){
        
        Dimension dim=getPreferredSize();
        dim.width=250;
        setPreferredSize(dim);
        
        firstNameTrainerLabel = new JLabel("First_Name: ");
        lastNameTrainerLabel = new JLabel("Last_name: ");
        subjectLabel = new JLabel("Subject: "); 
        
        firstNameTrainerTextField = new JTextField(10);
        lastNameTrainerField = new JTextField(10);        
        subjectTextField = new JTextField(10);         
        
        color = new Color(0xadcff7);
               
        subjectCombo = new JComboBox();
        okTrainerButton = new JButton("Add Trainer");          
        
         //SET UP COMBO BOX FOR SUBJECT////////
        DefaultComboBoxModel trainerModel=new DefaultComboBoxModel();
        trainerModel.addElement("Java_C1_FT");
        trainerModel.addElement("C#_C2_FT");        
        trainerModel.addElement("Java_C3_PT");
        trainerModel.addElement("C#_C4_PT");
        
        subjectCombo.setModel(trainerModel);
        subjectCombo.setSelectedIndex(0);
        subjectCombo.setEditable(false);
        
        okTrainerButton.setBackground(color);
        
        okTrainerButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {               
                String firstName ="";               
                String lastName= "";              
                String subject = (String)subjectCombo.getSelectedItem();  
                
                if(!StaticMethods.isLetter(firstNameTrainerTextField.getText())){                    
                    System.out.println("Enter valid First Name!");                      
                }
                else{
                    firstName=firstNameTrainerTextField.getText();                
                }
                
                
                if(!StaticMethods.isLetter(lastNameTrainerField.getText())){
                    System.out.println("Enter valid Last Name!");                
                }                
                else{
                    lastName=lastNameTrainerField.getText() ;         
                }                
                
                if(!firstName.equals("")&&!lastName.equals("")){                          
                    TrainerEvent trainerEvent=new TrainerEvent(this, firstName, lastName, subject) ;                
                        if (trainerListener!=null){                    
                             trainerListener.trainerEventOccured(trainerEvent);                      
                        }
                    }
                    else{
                        System.out.println("All the fields must be filled in!");
                    }
                    
            }       
        });             
        
        Border innerBorder=BorderFactory.createTitledBorder("Add Trainer");        
        Border outerBorder=BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        
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
        add(firstNameTrainerLabel,gc);
        
        gc.gridx=1;
        gc.gridy=0;
        gc.anchor=GridBagConstraints.LINE_START;
        gc.insets=new Insets(0,0,0,0);
        add(firstNameTrainerTextField,gc);
        
        //SECOND LINE//////
        gc.gridy++;
        
        gc.gridx=0;
        
        gc.weightx=1;
        gc.weighty=0.1;
        gc.anchor=GridBagConstraints.LINE_END;
        gc.insets=new Insets(0,0,0,5);
        add(lastNameTrainerLabel, gc);
        
        gc.gridx=1;
        gc.gridy=1;
        gc.anchor=GridBagConstraints.LINE_START;
        gc.insets=new Insets(0,0,0,0);
        add(lastNameTrainerField, gc);
        
        //NEXT LINE///////
        gc.gridy++;
        
        gc.gridx=0;
        gc.anchor=GridBagConstraints.LINE_END;
        gc.insets=new Insets(0,0,0,5);
        add(subjectLabel, gc);
        
        gc.gridx=1;
        
        gc.weightx=1;
        gc.weighty=0.1;
        gc.anchor=GridBagConstraints.LINE_START;
        gc.insets=new Insets(0,0,0,0);
        add(subjectCombo, gc);           
        
        //NEXT LINE///////
        
        gc.gridy++;
        
        gc.gridx=1;
        
        gc.weightx=1;
        gc.weighty=2.0;
        gc.anchor=GridBagConstraints.FIRST_LINE_START;
        gc.insets=new Insets(0,0,0,0);
        add(okTrainerButton, gc);           
    }    
    
    public void setTrainerListener(TrainerListener listener){
        this.trainerListener=listener;    
    }     
}
