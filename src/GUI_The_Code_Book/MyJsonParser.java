
package GUI_The_Code_Book;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;


public class MyJsonParser {
    
    private static MyJsonParser jp = null;
    public ArrayList<CodeList> codelist = null;
    
    private MyJsonParser (){}
    public static MyJsonParser getMyJsonParser(){
        if(jp==null){
            jp=new MyJsonParser();
            jp.process();
        }
        return jp;
    }
    public void process(){
        codelist = new ArrayList<CodeList>();
        FileInputStream fstream = null;
         JsonReader reader = null;
        try {
            fstream = new FileInputStream("D:/การเรียน/project I/Project/GUI TheCodeBook/TheCodeBook1/TheCodeBook V 0.1/jsonfile_CSharp.json");
           //D:/การเรียน/project I/Project/GUI TheCodeBook/TheCodeBook1/TheCodeBook V 0.1/jsonfile_CSharp.json
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;

            //Read File Line By Line
            while ((strLine = br.readLine()) != null)   {
                reader = Json.createReader(new StringReader(strLine));
                JsonObject jsonObject = reader.readObject();
                reader.close();
                
                //Start reading value
                codelist.add(new CodeList(Integer.parseInt(jsonObject.getString("ID")),
                        jsonObject.getString("language"),
                        jsonObject.getString("title"),
                        jsonObject.getString("content")));
            }
        }catch(Exception ex){ex.printStackTrace();}     
    }
}
