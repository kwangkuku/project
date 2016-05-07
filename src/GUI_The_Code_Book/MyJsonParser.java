
package GUI_The_Code_Book;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class MyJsonParser {
    
    private static MyJsonParser jp = null;
    public ArrayList<CodeList> codelist = null;
    
    private MyJsonParser (){}
    public static MyJsonParser getMyJsonParser(){
        if(jp==null){
            jp=new MyJsonParser();
            
        }
        jp.process();
        return jp;
    }
    public void process(){
        codelist = new ArrayList<CodeList>();
         FileInputStream fstream = null;
         JsonReader reader = null;
         JSONParser parser = new JSONParser();
        try {
            fstream = new FileInputStream("D:/การเรียน/project I/Project/GUI TheCodeBook/TheCodeBook1/testWriteflie.json");
           
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            
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
                   codelist.add(new CodeList(id,title,content,type));
                  
          }
         }
            
            
            
            
            
            //Read File Line By Line
          /*  while ((strLine = br.readLine()) != null)   {
                reader = Json.createReader(new StringReader(strLine));
                JsonObject jsonObject = reader.readObject();
                reader.close();
                
                //Start reading value
                codelist.add(new CodeList(Integer.parseInt(jsonObject.getString("ID")),
                        jsonObject.getString("language"),
                        jsonObject.getString("title"),
                        jsonObject.getString("content")));
            }*/
        }catch(Exception ex){ex.printStackTrace();}     
    }
}
