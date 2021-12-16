package instatistics.service;
import java.util.ArrayList;
import java.util.Vector;
import instatistics.model.*;
//import org.json.simple.parser.ParseException;
import org.json.simple.*;

import instatistics.model.Post;

public interface InstatisticsService {
	public abstract JSONObject getDataUser(String field); 
	public abstract JSONObject getAllUser();
	
	public abstract JSONObject getDataPost(String field); 
	public abstract JSONObject getAllPost();
	//public abstract JSONObject Test();
    public abstract ArrayList<Post> JsonReading();
    public abstract JSONObject getMedia(String argoument);
    public abstract JSONObject getTimestamp(String argoument);
    
}
