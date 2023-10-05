import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Main {
	
	public static void main(String args[])
	     {
		

		  Scanner in = new Scanner(System.in);
		  System.out.print("Введите запрос: ");
		  String ask =in.nextLine(); 
		  String urlAddress = "https://ru.wikipedia.org/w/api.php?action=query&list=search&utf8=&format=json&srsearch="+ URLEncoder.encode(ask, StandardCharsets.UTF_8);
		  String line="";
		 
	      line= Get_response.response_api(urlAddress);
	      JsonObject stobj= JsonParser.parseString(line).getAsJsonObject();
	      String pageid[]=Parsing.output(stobj);
	         int j=0;
	         try 
	            {
                j =in.nextInt();
	            }
	            
	            catch(InputMismatchException ex)
	            {
	            	System.out.print("\nВы ввели не число, повторите запрос!\n");
	            	return;
	            }
	            
	         if(j>0&&j<pageid.length+1)
	         {
	          String adding = pageid[j-1];
              in.close(); 
              Results.show_browse(adding);
	         }
	         else
	        	 System.out.print("\nВаше число выходит за границы заданного диапазона, повторите запрос!\n");
	     }
}
