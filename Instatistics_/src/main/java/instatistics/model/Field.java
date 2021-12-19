package instatistics.model;
/**
 * @author Mattioli Sara
 * @author Micheli ELisa
 *
 *<b>Interfaccia</b> descrive in maniera generica una caratteristica del
 *post da analizzare. Le classi FieldSuggestion e TimeStamp sono sue 
 *estensioni.
 */
public interface Field {
	
	public String NumberOfRepetition (String ObjectOfInterest);
	public String Ranking(String[] input);
    
}
