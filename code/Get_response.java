import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Get_response {

	static String response_api(String urlAddress)
	{
		String line="";
		HttpURLConnection connection = null;
		 URL url = null;
	        InputStreamReader isR = null;
	        BufferedReader bfR = null;
	        try {
	            url = new URL(urlAddress);
	            connection = (HttpURLConnection) url.openConnection();
	            connection.setRequestMethod("GET");
	            connection.connect();

	            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) 
	            {
	                isR = new InputStreamReader(connection.getInputStream());
	                bfR = new BufferedReader(isR);
					line = bfR.readLine();
	                
	            } 
	            else 
	            {
	                System.out.printf("Fail %s", connection.getResponseCode());
	            }
	        }
	        catch (IOException e) 
        	{
            e.printStackTrace();
        	} 
	        return line;
	}
}
