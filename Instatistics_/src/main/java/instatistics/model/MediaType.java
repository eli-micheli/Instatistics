package instatistics.model;

import java.util.ArrayList;
import org.json.simple.*;

public class MediaType extends FieldSuggest{
    
	ArrayList <Post> array = new ArrayList <Post>();
	public MediaType (ArrayList <Post> array) {
		this.array=array;
	}
	@SuppressWarnings("unchecked")
	public String NumberOfRepetition(String ObjectOfInterest) {
		int cont=0;
		for(int	i=0;i<array.size();i++) {
			if(array.get(i).getMedia_type().equals(ObjectOfInterest)) {
			cont++;
			}
		}
		return Integer.toString(cont); 
	}

	public String Ranking() {
		int contImage=0;
		int contAlbum =0;
		int contVideo=0;
		
		String p = null;
		for(int	i=0;i<array.size();i++) {
			switch (array.get(i).getMedia_type()) {
			case "IMAGE":
				contImage++;
			break;
			case "CAROUSEL_ALBUM":
				contAlbum++;
			break;
			case "VIDEO":
				contVideo++;
			break;
			}
			
			if(contImage>=contAlbum && contImage>=contAlbum) {
			    p ="Maggiore" +" "+contImage +" "+"Tipo più frequente" +" "+"IMAGE";
			
			}
			else {
				if(contAlbum>=contVideo) {
				p = "Maggiore" +" "+contAlbum +" "+"Tipo più frequente" +" "+"ALBUM";
				}
				else {
					p= "Maggiore" +" "+contVideo +" "+"Tipo più frequente"+" " +"VIDEO";
				}   
			}
		}
		return p;

	}
    Genova 
	//@Override
	public String Suggestion() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
