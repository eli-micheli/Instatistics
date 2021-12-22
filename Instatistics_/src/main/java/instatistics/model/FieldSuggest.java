package instatistics.model;

/**
 * <b>Classe</b> che estende l'interfaccia Field aggiungendo un metodo
 * per i suggerimenti e un array di post.
 * @author Micheli Elisa 
 * @author Mattioli Sara
 */
public abstract class FieldSuggest implements Field{
	
	public abstract String NumberOfRepetition(String ObjectOfInterest);
    public abstract String Ranking(String [] input);
	public abstract String Suggestion(String input);
}
