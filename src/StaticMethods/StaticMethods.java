
package StaticMethods;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author netri
 */
public class StaticMethods {
    
    public static boolean isLetter(String s){
        for (int i=0; i<s.length(); i++){
            if (Character.isLetter(s.charAt(i))==false){
                return false;
            }        
        }    
        return true;
    }
    
    public static boolean isNumber(String s){
        
        for (int i=0; i<s.length();i++){
            if ((Character.isDigit(s.charAt(i))==false)&&s.charAt(i)!='.'){                
                return false;
            }        
        }
        return true;   
    }   
    
    public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
    return dateToConvert.toInstant()
      .atZone(ZoneId.systemDefault())
      .toLocalDate();
    }
    
    public static boolean compareDates(Date d1, Date d2){
        if (d1.compareTo(d2)>=0){
            return true;
        }
        return false;    
    }
}
