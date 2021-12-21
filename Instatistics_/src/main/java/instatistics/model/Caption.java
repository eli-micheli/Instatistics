package instatistics.model;

import java.util.ArrayList;
/**
 * <b>Classe</b> che permette di elaborare statistiche sulla caption 
 * del post. In particolare la classe permette di ottenere statistiche sui tag e 
 * gli hashtag.
 * @author Micheli Elisa 
 * @author Mattioli Sara
 */
public class Caption extends FieldSuggest{
	/**
     * ArrayList di oggetti di tipo Post che contiene
     * tutti i post dell'utente eventualmente filtrati.
     */
	ArrayList <Post> allPost = new ArrayList <Post>();
	/**
	 * <b>Constructor</b> 
	 * @param array ArrayList di oggetti di tipo Post che contiene
     * tutti i post dell'utente eventualmente filtrati.
	 */
	public Caption (ArrayList<Post> allPost) {
		super(allPost);
	}
	/**
	 *<b>Metod</b> che calcola il numero di volte 
	 *che è stato utilizzato un dato tag o hashtag.
	 *@param TagHashtag tag o hashtag su cui fare la statistica.
	 *@return Il numero di volte che è stato usato. 
	 */
	public String NumberOfRepetition(String TagHashtag) {
		int cont=0;
		for(int	i=0;i<allPost.size();i++) {
			String s = allPost.get(i).getCaption();
			if(s.contains(TagHashtag)) { 
			cont++;
			}
		}
		return Integer.toString(cont); 
	}
	/**
	 *<b>Metod</b> che calcola il tag o l'hastag piu' usato
	 *tra un gruppo di hashtag o tag forniti dall'utente.
	 *@param input un array contenente gli oggetti su cui fare 
	 *la statistica.
	 *@return Il tag o l'hashtag piu' usato
	 */
	public String Ranking(String[] input) {
		Caption cc = new Caption(allPost);
		int winnerpast =0;
		int winnerpresent =0;
		int contpresent =0;
		int contpast =0;
		
		for ( int i =1; i<input.length; i++) {
			if (Integer.valueOf(cc.NumberOfRepetition(input [i-1]))>Integer.valueOf(cc.NumberOfRepetition(input [i]))) {
				winnerpresent = Integer.valueOf(cc.NumberOfRepetition(input [i-1]));
			 contpresent =i-1;}
			else {
				winnerpresent = Integer.valueOf(cc.NumberOfRepetition(input [i]));
				contpresent = i;
				}
			if (winnerpresent > winnerpast) {
				winnerpast = winnerpresent;
				contpast = contpresent;
			}
		}
		String result = "La caption più usata è " +input[contpast] + " con " +Integer.toString(winnerpast) +" ripetizioni" ;
	    return result ;
	}
	/**
	 *<b>Metod</b> che suggerisce un hashtag in base al tema 
	 *fornito dall'utente.
	 *@param input Il tema riguardo il quale si vuole l'hashtag.
	 *I temi per ora implementati sono: "sport","insieme" e "cerimonia".
	 *@return L'hashtag suggerito.
	 */
	public String Suggestion(String theme) {
		String [] sport = {"#nopainnogain", "#sport", "#giornatainmovimento"};
		String [] insieme = {"#giornatacongliamici", "#ritrovarsi", "#amicizia"};
		String [] cerimonia = {"#congratulazioni", "#auguri", "#complimenti"};
		
		int i = (int) (Math.random()*3);
		String result = null;
		switch(theme) {
			case "sport":
			 result = sport [i];
			break;
			case "insieme":
			 result = insieme[i];
			break;
			case "cerimonia":
			 result = cerimonia[i];
			break;
		}
		return result;
	}
}
