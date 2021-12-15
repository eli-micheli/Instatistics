package instatistics.model;

import java.util.ArrayList;

import org.json.simple.JSONObject;

public abstract class FieldSuggest implements Field{
	@SuppressWarnings("unused")
	private JSONObject json = new JSONObject();
	public ArrayList <Post> array = new ArrayList <Post>();
	public abstract String NumberOfRepetition(String ObjectOfInterest) ;
    public abstract String Ranking();
	public abstract String Suggestion();
}
