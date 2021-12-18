package instatistics.model;

import java.util.ArrayList;
public class MediaType extends FieldSuggest{
    
	ArrayList <Post> array = new ArrayList <Post>();
	public MediaType (ArrayList <Post> array) {
		this.array=array;
	}

	public String NumberOfRepetition(String ObjectOfInterest) {
		int cont=0;
		for(int	i=0;i<array.size();i++) {
			if(array.get(i).getMedia_type().equals(ObjectOfInterest)) {
			cont++;
			}
		}
		return Integer.toString(cont); 
	}

	public String Ranking(String[] input) {
		int contImage=0;
		int contAlbum =0;
		int contVideo=0;
		
		
		String q = null;
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
		
			    q = "IMAGE";
			}
			else {
				if(contAlbum>=contVideo) {
				q = "CAROUSEL_ALBUM";
				}
				else {
					
					q = "VIDEO";
				}   
			}
		}
		
		return q;

	}
    
	//@Override
	public String Suggestion(String input) {
		MediaType mm = new MediaType(array);
		String mostUsed=mm.Ranking(null);
		String lastUsed=array.get(0).getMedia_type(); 
		
		String result = null;
		if (mostUsed.equals(lastUsed)) {
			switch (mostUsed) {
			case("VIDEO"):
				result = "IMAGE";
			break;
			case ("CAROUSEL_ALBUM"):
				result = "VIDEO";
			break;
			case ("IMAGE"):
				result = "CAROUSEL_ALBUM";
			break;
			}
		}
		
		else {
			switch (mostUsed) {
			case("VIDEO"):
				if (lastUsed == "CAROUSEL_ALBUM") {
				result = "IMAGE";
				}
				else  {
				result = "CAROUSEL_ALBUM";
				}
			break;
			case ("CAROUSEL_ALBUM"):
				if (lastUsed == "VIDEO") {
				result = "IMAGE";
			    }
				else{
		    	result = "VIDEO";
			    }
			    
			break;
			case ("IMAGE"):
				if (lastUsed.equals("CAROUSEL_ALBUM")) {
					result = "VIDEO";
					}
				else  {
					result = "CAROUSEL_ALBUM";
					}
				break;
			}
		}
		
		return result;
	}
}

	

