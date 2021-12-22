package instatistics.filters;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import instatistics.model.*;
/**
 *<b>Classe</b> che permette di filtrare una lista di post in base alla data.
 *@author Micheli Elisa
 *@author Mattioli Sara
 */
public class FilterPostforDate {
  ArrayList<Post> array=new ArrayList<Post>(); 
  /**
   * <b>Constructor</b>
   * @param array lista di post da filtrare
   */
  Post result=new Post(null,null,null,null);
  public FilterPostforDate(ArrayList<Post> array) {
	  this.array=array;
  }
  /**
   * <b>Metod</b> che implementa la funzione del filtro.
   * @param data La data per cui filtrare i post.
   * @return json contentente la lista di post filtarta.
   */
  @SuppressWarnings("unchecked")
public JSONObject getPostforDate(String data){
	  String[] split=null;
	  JSONObject JsonReturn=new JSONObject();
	  Boolean flag=false;
	  if(data.length()==10) {
	  split=data.substring(0,10).split("-");
	  
	  if(split[0].length()==4 && Integer.parseInt(split[1])<13 && Integer.parseInt(split[2])<=31  ){
			   for(int i=0;i<array.size();i++) {
				   if(array.get(i).getTimestamp().contains(data)) 
				   {
					   result.setCaption(array.get(i).getCaption());
					   result.setMedia_type(array.get(i).getMedia_type());
					   result.setId(array.get(i).getId());
					   result.setTimestamp(array.get(i).getTimestamp());
					   JsonReturn.put("Post", result);
					   flag=true;
				   }
			   }
			   if(flag==false) {
				   JsonReturn.put("Risultato","Post non trovato");
				   }
		  
	  }else {
		  JsonReturn.put("Risultato","Inserire formato corretto della data:AAAA-MM-GG");
		  
	  }
	  }
	  else {
		  JsonReturn.put("Risultato","Inserire formato corretto della data:AAAA-MM-GG");}
	
  return JsonReturn;
  
  
  
  
  }
  










}