/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_The_Code_Book;

import static java.awt.PageAttributes.MediaType.A;
import java.io.StringReader;
import java.util.ArrayList;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author EijiD
 */
public class ParserAPIStackEx {

    private static ParserAPIStackEx obj = null;

    public static ArrayList<URLlist> urlList;

    //private ParserAPIStackEx() {

    //}

    public static ParserAPIStackEx getParserAPIStackEx() {
        if (obj == null) {
            obj = new ParserAPIStackEx();
        }
        return obj;
    }

    public ArrayList<URLlist> getStackEx(String word, String web) {
        urlList = new ArrayList<URLlist>();    
        word = word.replaceAll(" ", "+");
        String url = "https://api.stackexchange.com/2.2/search/advanced?order=desc&sort=activity&accepted=True&title=" + word + "&site=" + web + "&filter=withbody";
        DefaultHttpClient httpclient = new DefaultHttpClient();
        HttpGet getRequest = new HttpGet(url);
        HttpResponse httpResponse;
        try {
            httpResponse = httpclient.execute(getRequest);
            HttpEntity entity = httpResponse.getEntity();
            System.out.println("----------------------------------------");
            System.out.println(httpResponse.getStatusLine());
            Header[] headers = httpResponse.getAllHeaders();
            for (int i = 0; i < headers.length; i++) {
                System.out.println(headers[i]);
            }
            System.out.println("----------------------------------------");
            if (entity != null) {
                entity = new GzipDecompressingEntity(entity);
                String jsonStr = EntityUtils.toString(entity);
                  //System.out.println(jsonStr);
                parseStackExchange(jsonStr);
            } else {
                System.out.println("NOTHING");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            httpclient.getConnectionManager().shutdown();
        }
        return urlList;
    }

    private void parseStackExchange(String jsonStr) {
        JsonReader reader = null;
        try {
            reader = Json.createReader(new StringReader(jsonStr));
            JsonObject jsonObject = reader.readObject();
            reader.close();
            JsonArray array = jsonObject.getJsonArray("items");
            for (JsonObject result : array.getValuesAs(JsonObject.class)) {
                urlList.add(new URLlist(result.getInt("view_count"), 
                                        result.getInt("answer_count"), 
                                        result.getString("title"), 
                                        result.getString("link")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
