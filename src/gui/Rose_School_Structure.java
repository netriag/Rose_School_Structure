package gui;

import javax.swing.SwingUtilities;

public class Rose_School_Structure {

   
       public static void main(String[] args) {
        
        //In case of multithreading it must be running inside a thread, so it does not crush
        SwingUtilities.invokeLater(new Runnable() {      
            
        //Abstract method of instance Runnable
            @Override
            public void run() {
                MainFrame mainFrame = new MainFrame();            
            }
        });        
    }    
}
   
    
