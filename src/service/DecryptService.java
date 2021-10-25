package service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class DecryptService {

	 public static String getDecryptCode(String code)  
	  {  
	    StringBuilder content = new StringBuilder();  
	  // Use try and catch to avoid the exceptions  
	    try  
	    {  
	      URL url = new URL("https://test.evalartapp.com/extapiquest/code_decrypt/"+code); // creating a url object  
	      URLConnection urlConnection = url.openConnection(); // creating a urlconnection object  
	  	      // wrapping the urlconnection in a bufferedreader  
	      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));  
	      String line;  
	      // reading from the urlconnection using the bufferedreader  
	      while ((line = bufferedReader.readLine()) != null)  
	      {  
	        content.append(line + "\n");  
	      }  
	      bufferedReader.close();  
	    }  
	    catch(Exception e)  
	    {  
	      e.printStackTrace();  
	    }  
	    return content.toString().replace("\"", "");  
	  }  
}
