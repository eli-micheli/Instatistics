package instatistics.filters;

import java.util.ArrayList;

import org.json.simple.JSONObject;

import instatistics.model.Post;

public class FiltroMediaType {
	
	public ArrayList<Post> array=new ArrayList<Post>();
	JSONObject jj=new JSONObject();
	ArrayList<Post> appoggio=new ArrayList<Post>();
	public FiltroMediaType(ArrayList<Post> array) {
		this.array=array;
	}
	
	
	public ArrayList<Post> tipi_di_post(String media_type) {
		for(int i=0;i<array.size();i++) {
			if(array.get(i).getMedia_type().contains(media_type))
			{
				appoggio.add(array.get(i));
			}
			
		}
		
		return appoggio;
	}
	

}
