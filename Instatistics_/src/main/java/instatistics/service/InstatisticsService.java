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
	
    public abstract ArrayList<Post> JsonReading();
    
    public abstract JSONObject getMedia(String metod,String field);
    public abstract JSONObject getTimestamp(String metod,String field);
    public abstract JSONObject getCaption(String metod,String theme);
    
    public abstract JSONObject getFilterYear(String year);
    
}
