package instatistics.service;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;

public interface InstatisticsService {
	public abstract JSONObject getMedia_type(String word);

}
