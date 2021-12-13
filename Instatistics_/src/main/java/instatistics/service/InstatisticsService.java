package instatistics.service;
//import org.json.simple.parser.ParseException;
import org.json.simple.*;

public interface InstatisticsService {
	public abstract JSONObject getDataUser(String field); 
	public abstract JSONObject getAllUser();
	
	public abstract JSONObject getDataPost(String field); 
	public abstract JSONObject getAllPost();
	
	public abstract JSONObject getStat();
}
