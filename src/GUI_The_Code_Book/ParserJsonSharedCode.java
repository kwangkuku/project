
package GUI_The_Code_Book;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.json.JsonReader;
import jdk.nashorn.internal.parser.JSONParser;
    

/**
 *
 * @author Administrator
 */
public class ParserJsonSharedCode {
 private static ParserJsonSharedCode obj = null;
 public static ArrayList<SharedCodeList> sharedList = null;

       private  ParserJsonSharedCode(){}

        public static ParserJsonSharedCode getParserJsonSharedCode() {
            if(obj == null)
            {
            obj = new ParserJsonSharedCode();
          //  obj.ParserProcess();
            }
          return obj;  
        
    }
        
    public void ParserProcess() {
    sharedList = new ArrayList<SharedCodeList>();
    FileInputStream file = null;
         JsonReader reader = null;
       JSONParser parser = new JSONParser();
         
     try {
         file = new FileInputStream("D:/การเรียน/project I/Project/GUI TheCodeBook/sharedcode.json");
         BufferedReader br = new BufferedReader(new InputStreamReader(file));
         String readline; 
        
  
     } catch (Exception ex) {
        ex.printStackTrace();
        }
    }}

 
    
    

