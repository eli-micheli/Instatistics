package instatistics.filters;

import java.util.ArrayList;
import instatistics.model.Post;
/**
 *<b>Classe</b> che permette di filtrare una lista di post in base al tipo di post.
 *@author Micheli Elisa
 *@author Mattioli Sara
 */
public class FiltroMediaType {
	
	public ArrayList<Post> array=new ArrayList<Post>();
	ArrayList<Post> Return=new ArrayList<Post>(); 
	/**
	 * <b>Constructor</b>
	 * @param array lista di post da filtrare
	 */
	public FiltroMediaType(ArrayList<Post> array) {
		this.array=array;
	}
	 /**
	   * <b>Metod</b> che implementa la funzione del filtro.
	   * @param media_type Il tipo di post per cui filtrare i post.
	   * @return json contentente la lista di post filtarta.
	   */
	public ArrayList<Post> tipi_di_post(String media_type) {
		for(int i=0;i<array.size();i++) {
			if(array.get(i).getMedia_type().equals(media_type))
			{
				Return.add(array.get(i));
			}
			
		}
		
		return Return;
	}
	

}
