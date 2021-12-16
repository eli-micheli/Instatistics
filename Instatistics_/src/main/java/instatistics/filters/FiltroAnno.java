package instatistics.filters;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import instatistics.model.*;
public class FiltroAnno {
	public ArrayList<Post> array=new ArrayList<Post>();
	JSONObject jj=new JSONObject();
	ArrayList<Post> appoggio=new ArrayList<Post>();
	public FiltroAnno(ArrayList<Post> array) {
		this.array=array;
	}
	
	
	public ArrayList<Post> post_annuali(String anno) {
		for(int i=0;i<array.size();i++) {
			if(array.get(i).getTimestamp().contains(anno))
			{
				appoggio.add(array.get(i));
			}
			
		}
		
		return appoggio;
	}
	


}