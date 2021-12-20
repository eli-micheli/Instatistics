package instatistics.filters;
import java.util.ArrayList;

import org.json.simple.JSONObject;

import instatistics.model.*;
public class FilterPostforDate {
  ArrayList<Post> array=new ArrayList<Post>();
  Post result=new Post(null,null,null,null);
  public FilterPostforDate(ArrayList<Post> array) {
	  this.array=array;
  }
  
  @SuppressWarnings("unchecked")
public JSONObject getPostforDate(String data){
	  String[] split=null;
	  JSONObject jj=new JSONObject();
	  Boolean trovato=false;
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
					   jj.put("Post", result);
					   trovato=true;
				   }
			   }
			   if(trovato==false) {
				   jj.put("Risultato","Post non trovato");
				   }
		  
	  }else {
		  jj.put("Risultato","Inserire formato corretto della data:AAAA-MM-GG");
		  
	  }
	  }
	  else {
		  jj.put("Risultato","Inserire formato corretto della data:AAAA-MM-GG");}
	  
  
  
  return jj;
  
  
  
  
  }
  










}