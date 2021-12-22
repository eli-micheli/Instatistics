package instatistics.service;

import java.util.ArrayList;
import org.json.simple.*;

import instatistics.exception.fieldNotFound;
import instatistics.exception.metodNotFound;
import instatistics.model.Post;
/**
 * <b>Interfaccia</b> che definisce i servizi dell'API
 * @author Micheli Elisa 
 * @author Mattioli Sara
 */

public interface InstatisticsService {
	 
	public abstract JSONObject getAllUser();
	
    public abstract ArrayList<Post> JsonReading();
    
    public abstract JSONObject getMedia(String filter,String metod,String field) throws fieldNotFound,metodNotFound;
    public abstract JSONObject getTimestamp(String metod,String field)throws fieldNotFound,metodNotFound;
    public abstract JSONObject getCaption(String metod,String theme)throws fieldNotFound,metodNotFound;
    
    public abstract ArrayList<Post> getFilterYear(String year)throws fieldNotFound;
    public abstract JSONObject getFilterPostforDate(String data);
    public abstract ArrayList<Post> getFilterMediaType(String MediaType)throws fieldNotFound;
}
