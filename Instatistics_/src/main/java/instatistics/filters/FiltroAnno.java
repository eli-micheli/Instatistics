package instatistics.filters;
import java.util.ArrayList;
import instatistics.model.*;
/**
 *<b>Classe</b> che permette di filtrare una lista di post in base all'anno.
 *@author Micheli Elisa
 *@author Mattioli Sara
 */
public class FiltroAnno {
	ArrayList<Post> array=new ArrayList<Post>();
	ArrayList<Post> Return =new ArrayList<Post>();  
	/**
	 * <b>Constructor</b>
	 * @param array lista di post da filtrare
	 */
	public FiltroAnno(ArrayList<Post> array) {
		this.array=array;
	}
	 /**
	   * <b>Metod</b> che implementa la funzione del filtro.
	   * @param anno L'anno per cui filtrare i post.
	   * @return json contentente la lista di post filtrata.
	   */
	public ArrayList<Post> post_annuali(String anno) {
		for(int i=0;i<array.size();i++) {
			if(array.get(i).getTimestamp().contains(anno))
			{
				Return.add(array.get(i));
			}
			
		}
		
		return Return;
	}
	


}