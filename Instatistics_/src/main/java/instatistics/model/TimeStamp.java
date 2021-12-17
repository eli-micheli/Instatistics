package instatistics.model;

import java.util.ArrayList;


public class TimeStamp implements Field{
	
	ArrayList <Post> array = new ArrayList <Post>();
	public TimeStamp (ArrayList<Post> array) {
		this.array=array;
	}
	@Override
	public String NumberOfRepetition(String YearOfInterest) {
		int cont=0;
		for(int i=0;i<array.size();i++) {
			if(array.get(i).timestamp.contains(YearOfInterest)) {cont++;
			}
		}
		return Integer.toString(cont);
	}
	@Override
	public String Ranking(String[] input) {
		
		int winnerpast =0;
		int winnerpresent =0;
		int contpresent =0;
		int contpast =0;
		TimeStamp tt=new TimeStamp(array);
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
