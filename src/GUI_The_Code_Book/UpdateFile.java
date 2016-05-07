package GUI_The_Code_Book;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;


public class UpdateFile {
   

    public  void createFile(){
        FileOutputStream fs = null;
        try {
            File file = new File("D:/การเรียน/project I/Project/GUI TheCodeBook/TheCodeBook1/testWriteflie.json");
            fs = new FileOutputStream(file);
            OutputStreamWriter ow = new OutputStreamWriter(fs);
            BufferedWriter writer = new BufferedWriter(ow);
            if (file.exists()){file.delete();}
            try {
                
                writer.write(callURL());
                writer.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UpdateFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fs.close();
            } catch (IOException ex) {
                Logger.getLogger(UpdateFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
   
    }
    
    public static String callURL() {
		
		StringBuilder sb = new StringBuilder();
		URLConnection urlConn = null;
		InputStreamReader in = null;
		try {
			URL url = new URL("http://localhost/laravel/public/thecodebook/update");
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
			throw new RuntimeException("Exception while calling URL:"+ e);
		} 
 
		return sb.toString();
	}
}

