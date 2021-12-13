package instatistics.model;

import java.util.ArrayList;

import org.json.simple.JSONObject;

public class MediaType extends FieldSuggest {
    String[] API={"VIDEO","MEDIA","CAROUSEL_ALBUM"};
    JSONObject json = new JSONObject();
	@SuppressWarnings("unchecked")
	@Override
	public JSONObject NumberOfRepetition(String ObjectOfInterest) {
		int cont=0;
		for(int	i=0;i<API.length;i++) {
			if(API [i] == ObjectOfInterest) {
			cont++;
			}
		}
		
		json.put("Numero ripetizioni", cont);
		return json; 
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject Ranking() {
		int contImage=0;//x
		int contAlbum =0;//y
		int contVideo=0;//z
		//int max;
		for(int	i=0;i<API.length;i++) {
			switch (API [i]) {
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
				json.put("Maggiore", contImage);
				json.put("Tipo più frequente","IMAGE");
			}
			else if(contAlbum>=contVideo) {
				json.put("Maggiore", contAlbum);
				json.put("Tipo più frequente","ALBUM");}
			else json.put("Maggiore",contVideo);
			json.put("Tipo più frequente","VIDEO");
		}
	
		return json;
	}

	@Override
	public JSONObject Suggestion() {
		// TODO Auto-generated method stub
		return null;
	}

}
