package instatistics.model;

import org.json.simple.JSONObject;

public abstract class FieldSuggest implements Field{

	public abstract JSONObject NumberOfRepetition(String ObjectOfInterest) ;
    public abstract JSONObject Ranking();
	public abstract JSONObject Suggestion();
}
