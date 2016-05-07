
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
            obj.getSharedCode();
            }
          return obj;  
        
    }
        
    public static void getSharedCode()  {
    sharedList = new ArrayList<SharedCodeList>();
       
       JSONParser parser = new JSONParser();
       FileInputStream fileStream = null;
       
     try {
         fileStream = new FileInputStream("D:/การเรียน/project I/Project/GUI TheCodeBook/TheCodeBook1/testWriteflie.json");
         BufferedReader br = new BufferedReader(new InputStreamReader(fileStream));
         Object obj = parser.parse(br);
         if(obj instanceof JSONArray)
         {
         JSONArray array = (JSONArray)obj;
          for(int i =0;i<array.size();i++)
          {
          JSONObject jsonObj = (JSONObject) array.get(i);
          String id = jsonObj.get("id").toString();
          String title = jsonObj.get("title").toString();
          String content = jsonObj.get("content").toString();
          String type  = jsonObj.get("type").toString();
          String created = "";
          String updated = "";
             if(jsonObj.get("created_at") != null)
                 created = jsonObj.get("created_at").toString();
             if(jsonObj.get("updated_at") != null)
                 updated = jsonObj.get("updated_at").toString();
                   sharedList.add(new SharedCodeList(id,title,content,type,updated,created));
                   //   System.out.println("ID: "+id);
                   //  System.out.println("TITLE: "+title);
                   //   System.out.println("Content: "+content);
                    //  System.out.println("Created: "+created);
                    // System.out.println("Updated: "+updated);
          }
         }
         
         
         
     } catch (Exception ex) {
         Logger.getLogger(ParserJsonSharedCode.class.getName()).log(Level.SEVERE, null, ex);
     }
       
     
     
    }
    
}
 
    
    

