package instatistics.model;

import java.util.ArrayList;

import org.json.simple.JSONObject;

public abstract class FieldSuggest implements Field{
	
	public ArrayList <Post> array = new ArrayList <Post>();
	public abstract String NumberOfRepetition(String ObjectOfInterest);
    public abstract String Ranking(String [] input);
	public abstract String Suggestion(String input);
}
