
package GUI_The_Code_Book;

import static GUI_The_Code_Book.ParserAPIStackEx.urlList;
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
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
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
           
            }
          return obj;  
        
    }
       
      
     public  static String callURLSheardCode(String word)
      {
      StringBuilder sb = new StringBuilder();
		URLConnection urlConn = null;
		InputStreamReader in = null;
             //   word = word.replaceAll("","+");
		try {
			URL url = new URL("http://172.19.195.162:8080/laravel/public/thecodebook/search/"+word);
			urlConn = url.openConnection();
			
			if (urlConn != null && urlConn.getInputStream() != null) {
				in = new InputStreamReader(urlConn.getInputStream(),
						Charset.defaultCharset());
				BufferedReader bufferedReader = new BufferedReader(in);
				if (bufferedReader != null) {
					int i;
					while (( i = bufferedReader.read()) != -1) {
						sb.append((char) i);
                                                
					}
					bufferedReader.close();
				}
			}
		in.close();
		} catch (Exception e) {
			//throw new RuntimeException("Exception while calling URL:"+ e);
		} 
 
		return sb.toString();
      
      }
     
      
      public  ArrayList<SharedCodeList> parseShared(String word)
      {
          sharedList = new ArrayList<SharedCodeList>();
     try {
         
         //JsonReader reader = null;
         JSONParser parser = new JSONParser();
         //String word word = null;
         Object obj = parser.parse(callURLSheardCode(word));
          if(obj instanceof JSONArray)
         {
         JSONArray array = (JSONArray)obj;
          for(int i =0;i<array.size();i++)
          {
          JSONObject jsonObj = (JSONObject) array.get(i);
          int id_code =Integer.parseInt(jsonObj.get("id").toString());
          String title = jsonObj.get("title").toString();
          String content = jsonObj.get("content").toString();
          String description = jsonObj.get("description").toString();
          String type  = jsonObj.get("type").toString();
          Double evaluation =Double.parseDouble(jsonObj.get("evaluation").toString());
          int viewcounter = Integer.parseInt(jsonObj.get("viewcounter").toString());

             
              sharedList.add(new SharedCodeList(id_code,title,content,description,type,evaluation,viewcounter));
                    System.out.println("id_code :"+id_code);
                    System.out.println("title"+title);
                    System.out.println("type :"+type);
     
          }
         }
            
 
     } catch (ParseException ex) {
         Logger.getLogger(ParserJsonSharedCode.class.getName()).log(Level.SEVERE, null, ex);
     }
     return sharedList;
}}
 
    
    

