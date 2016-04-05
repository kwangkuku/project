
package GUI_The_Code_Book;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.json.JsonReader;
//import jdk.nashorn.internal.parser.JSONParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonObject;
 import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;   

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
            obj.ParserProcess();
            }
          return obj;  
        
    }
        
    public void ParserProcess()  {
    sharedList = new ArrayList<SharedCodeList>();
   // FileInputStream file = null;
        JsonReader reader = null;
       JSONParser parser = new JSONParser();
       
     
     
    }
}
 
    
    

