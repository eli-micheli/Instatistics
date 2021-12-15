package instatistics.model;

import java.util.ArrayList;
import org.json.simple.JSONObject;

public class Caption extends FieldSuggest{
	private JSONObject json = new JSONObject();
	ArrayList <String> array = new ArrayList <String>();
	ArrayList<String> hastag=new ArrayList<String>();
	public Caption (ArrayList<String> array) {
		this.array=array;
	}
	public ArrayList<String> getHashtag(){
		for(int i=0;i<array.size();i++) {
			for(int j=0;j<array.get(i).length();j++) {
				if(array.get(j).charAt(i) =='#') {hastag.get(j).substring(array.get(j).lastIndexOf('#')+1);
			}
		}
	
		
		}
		return hastag;
	}
/*	public String NumberOfRipetitionHas() {
		int cont=0;
		for(int	i=0;i<array.size();i++) {
			if(array.get(i).getCaption().toChar('#')) {
			cont++;
			}
		}
		return Integer.toString(cont); 
	}
	*/
	@Override
	public String NumberOfRepetition(String ObjectOfInterest) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String Ranking() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String Suggestion() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
