package instatistics.service;
//import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;

public interface InstatisticsService {
	public abstract JSONObject getDataUser(String field); 
	public abstract JSONObject getAllUser();
	
	public abstract JSONObject getDataPost(String field); 
	public abstract JSONObject getAllPost();
}
