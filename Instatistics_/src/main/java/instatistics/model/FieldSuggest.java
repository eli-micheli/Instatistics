package instatistics.model;

import java.util.ArrayList;

import org.json.simple.JSONObject;

public abstract class FieldSuggest implements Field{
	@SuppressWarnings("unused")
	private JSONObject json = new JSONObject();
	public ArrayList <String> array = new ArrayList <String>();
	//public abstract JSONObject NumberOfRepetition(String ObjectOfInterest) ;
    //public abstract JSONObject Ranking();
	//public abstract JSONObject Suggestion();
}
