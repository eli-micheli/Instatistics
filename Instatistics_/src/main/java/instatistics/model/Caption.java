package instatistics.model;

import java.util.ArrayList;
import org.json.simple.JSONObject;

public class Caption extends FieldSuggest{
	//private JSONObject json = new JSONObject();
	ArrayList <Post> array = new ArrayList <Post>();
	public Caption (ArrayList<Post> array) {
		this.array=array;
	}
	
	public String NumberOfRepetition(String ObjectOfInterest) {
		int cont=0;
		for(int	i=0;i<array.size();i++) {
			String s = array.get(i).getCaption(); //captin del post numero i
			if(s.contains(ObjectOfInterest)) { 
			cont++;//se la stringa s contiene l'hastag aumento il contatore
			}
		}
		//String result = "Hai postato " +ObjectOfInterest +cont +"volte";
		return Integer.toString(cont); 
	}
	
	@Override
<<<<<<< Updated upstream
	public String Ranking(String [] input) {
		// TODO Auto-generated method stub
		return null;
=======
	public String Ranking(String[] input) {
		Caption cc = new Caption(array);
		int winnerpast =0;
		int winnerpresent =0;
		int contpresent =0;
		int contpast =0;
		
		//int [] valori ={Integer.valueOf(cc.NumberOfRepetition(input [i])),Integer.valueOf(cc.NumberOfRepetition(input [1])), Integer.valueOf(cc.NumberOfRepetition(input [2]))};
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
>>>>>>> Stashed changes
	}
	
		
	
		
	@Override
	public String Suggestion() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
