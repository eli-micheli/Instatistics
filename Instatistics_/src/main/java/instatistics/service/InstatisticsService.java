package instatistics.service;

import java.util.ArrayList;
import org.json.simple.*;
import instatistics.model.Post;
/**
 * <b>Interfaccia</b> che definisce i servizi dell'API
 * @author Micheli Elisa 
 * @author Mattioli Sara
 */

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
    public abstract JSONObject getFilterPost(String data);
    public abstract JSONObject getFilterMediaType(String MediaType);
}
