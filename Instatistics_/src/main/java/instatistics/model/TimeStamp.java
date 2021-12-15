package instatistics.model;

import java.util.ArrayList;
import org.json.simple.JSONObject;

public class TimeStamp extends FieldSuggest{
	
	ArrayList <Post> array = new ArrayList <Post>();
	public TimeStamp (ArrayList<Post> array) {
		this.array=array;
	}
	@Override
	public String NumberOfRepetition(String ObjectOfInterest) {
		int cont=0;
		for(int i=0;i<array.size();i++) {
			if(array.get(i).timestamp.contains(ObjectOfInterest)) {cont++;
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
