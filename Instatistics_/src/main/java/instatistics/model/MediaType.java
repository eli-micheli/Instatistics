package instatistics.model;

import java.util.ArrayList;
/**
 * <b>Classe</b> che permette di elaborare statistiche sul tipo di post
 * @author Micheli Elisa 
 * @author Mattioli Sara
 */
public class MediaType extends FieldSuggest{
    /**
     * ArrayList di oggetti di tipo Post che contiene
     * tutti i post dell'utente eventualmente filtrati
     */
	ArrayList <Post> allPost = new ArrayList <Post>(); 
	/**
	 * <b>Constructor</b> 
	 * @param allPost ArrayList di oggetti di tipo Post che contiene
     * tutti i post dell'utente eventualmente filtrati
	 */
	public MediaType (ArrayList <Post> allPost) { 
		this.allPost = allPost;
	}
    /**
     * <b>Metod</b> che conta il numero di post di un certo tipo.
     * i tipi possono essere: IMAGE,VIDEO o CAROUSEL_ALBUM
     * @param TypeOfPost Tipo di post che si vuole contare
     * @return Il numero di ripetizioni convertito in stringa
     */
	public String NumberOfRepetition(String TypeOfPost) {
		int cont=0;
		for(int	i=0;i<allPost.size();i++) {
			if(allPost.get(i).getMedia_type().equals(TypeOfPost)) {
			cont++;
			}
		}
		return Integer.toString(cont); 
	}
	/**
	 *<b>Metod</b> che calcola il tipo di post piu' utilizzato
	 *@param input Stringa di input
	 *@return Il tipo di post piu' usato
	 */
	public String Ranking(String[] input) {
		int contImage=0;
		int contAlbum =0;
		int contVideo=0;
		
		String result = null;
		
		for(int	i=0;i<allPost.size();i++) {
			switch (allPost.get(i).getMedia_type()) {
			case "IMAGE":
				contImage++;
				break;
			case "CAROUSEL_ALBUM":
				contAlbum++;
				break;
			case "VIDEO":
				contVideo++;
				break;
			}
			if(contImage>=contAlbum && contImage>=contAlbum) {
				result = "IMAGE";
			}
			else {
				if(contAlbum>=contVideo) {result = "CAROUSEL_ALBUM";}
				else {result = "VIDEO";}   
			}
		}
		return result;
	}
	/**
	 *<b>Metod</b> che suggerire il tipo di post da fare in base 
	 *al piu' usato e all'ultimo tipo di post
	 *@param input Stringa di input
	 *@return Il tipo di post suggerito
	 */
	public String Suggestion(String input) {
		MediaType mediaRanking = new MediaType(allPost);
		String mostUsed=mediaRanking.Ranking(null);
		String lastUsed=allPost.get(0).getMedia_type(); 
		
		String result = null;
		if (mostUsed.equals(lastUsed)) {
			switch (mostUsed) {
			case("VIDEO"):
				result = "IMAGE";
			break;
			case ("CAROUSEL_ALBUM"):
				result = "VIDEO";
			break;
			case ("IMAGE"):
				result = "CAROUSEL_ALBUM";
			break;
			}
		}
		
		else {
			switch (mostUsed) {
			case("VIDEO"):
				if (lastUsed == "CAROUSEL_ALBUM") {
				result = "IMAGE";
				}
				else  {
				result = "CAROUSEL_ALBUM";
				}
			break;
			case ("CAROUSEL_ALBUM"):
				if (lastUsed == "VIDEO") {
				result = "IMAGE";
			    }
				else{
		    	result = "VIDEO";
			    }
			    
			break;
			case ("IMAGE"):
				if (lastUsed.equals("CAROUSEL_ALBUM")) {
					result = "VIDEO";
					}
				else  {
					result = "CAROUSEL_ALBUM";
					}
				break;
			}
		}
		String toReturn = "Dato che il media piu' usato è " +mostUsed +" e l'ultimo media è " +lastUsed +" ti suggeriamo di pubblicare un " +result;
		return toReturn;
	}
}

	

