package instatistics.model;

import java.util.ArrayList;
/**
 * <b>Classe</b> che permette di elaborare statistiche sui post
 * in relazione all'anno di pubblicazione.
 * @author Micheli Elisa 
 * @author Mattioli Sara
 */

public class TimeStamp implements Field{
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
	public TimeStamp (ArrayList<Post> allPost) {
		this.allPost=allPost;
	}
	/**
     * <b>Metod</b> che conta il numero di post di un certo anno.
     * @param YearOfInterest L'anno di cui si vuole sapere il numero di post.
     * @return Il numero di ripetizioni convertito in stringa.
     */
	public String NumberOfRepetition(String YearOfInterest) {
		int cont=0;
		for(int i=0;i<allPost.size();i++) {
			if(allPost.get(i).timestamp.contains(YearOfInterest)) {cont++;
			}
		}
		return Integer.toString(cont);
	}
	/**
	 *<b>Metod</b> che calcola l'anno in cui si è pubblicato di piu'.
	 *@param input Stringa di input.
	 *@return L'anno piu' usato.
	 */
	public String Ranking(String[] input) {
		
		int winnerpast =0;
		int winnerpresent =0;
		int contpresent =0;
		int contpast =0;
		TimeStamp tt=new TimeStamp(allPost);
		for ( int i =1; i<input.length; i++) {
			if (Integer.valueOf(tt.NumberOfRepetition(input [i-1]))>Integer.valueOf(tt.NumberOfRepetition(input [i]))) {
				winnerpresent = Integer.valueOf(tt.NumberOfRepetition(input [i-1]));
			 contpresent =i-1;}
			else {
				winnerpresent = Integer.valueOf(tt.NumberOfRepetition(input [i]));
				contpresent = i;
				}
			if (winnerpresent > winnerpast) {
				winnerpast = winnerpresent;
				contpast = contpresent;
			}
		}
		String result = "L'anno in cui hai pubblicato più è " +input[contpast] + " con " +Integer.toString(winnerpast) +" post" ;
	    return result ;
	}
	

}
