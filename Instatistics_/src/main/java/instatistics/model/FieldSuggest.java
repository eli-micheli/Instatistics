package instatistics.model;

import java.util.ArrayList;
/**
 * <b>Classe</b> che estende l'interfaccia Field aggiungendo un metodo
 * per i suggerimenti e un array di post.
 * @author Micheli Elisa 
 * @author Mattioli Sara
 */
public abstract class FieldSuggest implements Field{
	public ArrayList <Post> allPost = new ArrayList <Post>();
	
	public FieldSuggest(ArrayList <Post> allPost) {
		this.allPost = allPost;
	}
	public abstract String NumberOfRepetition(String ObjectOfInterest);
    public abstract String Ranking(String [] input);
	public abstract String Suggestion(String input);
}
