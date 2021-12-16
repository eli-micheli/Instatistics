package instatistics.model;

import java.util.ArrayList;
import java.util.Random;


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
	

	public String Ranking(String[] input) {
		Caption cc = new Caption(array);
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
	
		
	
		
	@Override
	public String Suggestion(String input) {
		String [] sport = {"#nopainnogain", "#sport", "#giornatainmovimento"};
		String [] insieme = {"#giornatacongliamici", "#ritrovarsi", "#amicizia"};
		String [] cerimonia = {"#congratulazioni", "#auguri", "#complimenti"};
		String [] 
		int i = (int) (Math.random()*3);
		String result = null;
		switch(input) {
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
