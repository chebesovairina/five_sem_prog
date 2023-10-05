import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Parsing {

	static String[] output(JsonObject stobj) 
	{
		 JsonObject dataobj = stobj.getAsJsonObject("query");
         JsonArray search = dataobj.getAsJsonArray("search");
         String[] pageid =new String[search.size()];
         
         System.out.print("\nВыберите нужную статью, введя ее номер: \n");
         for(int i=0;i<search.size();i++)
         {
         	JsonObject temp = search.get(i).getAsJsonObject();
         	System.out.printf("Статья (%d): %s\n",i+1, temp.getAsJsonPrimitive("title").toString());
         	pageid[i]= temp.getAsJsonPrimitive("pageid").toString();
         }
      return pageid;   
	}
}
