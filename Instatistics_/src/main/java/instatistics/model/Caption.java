package instatistics.model;

import java.util.ArrayList;
import org.json.simple.JSONObject;

public class Caption extends FieldSuggest{
	private JSONObject json = new JSONObject();
	ArrayList <Post> array = new ArrayList <Post>();
	public Caption (ArrayList<Post> array) {
		this.array=array;
	}
	
	public String NumberOfRepetition(String ObjectOfInterest) {
		int cont=0;
		for(int	i=0;i<array.size();i++) {
			String s = array.get(i).getCaption(); //captin del post numero i
			if(s.contains(ObjectOfInterest)) { //se la stringa s contiene l'hastag aumento il contatore
			cont++;
			}
		}
		return Integer.toString(cont); 
	
	}
	@Override
	public String Ranking() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String Suggestion() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
