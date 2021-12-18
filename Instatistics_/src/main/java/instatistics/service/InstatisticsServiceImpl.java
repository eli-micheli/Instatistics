package instatistics.service;

import instatistics.filters.*;
import instatistics.model.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.JSONArray;

import org.springframework.stereotype.Service;
@Service
public class InstatisticsServiceImpl implements InstatisticsService {
	
	private String token="IGQVJXZAlI3QnhaMUFXanp6SVVhckE2VWU4NTdmaUEyd1BXaFdpMTRtRjJLSFY5NTcxTTdMWENGVEhGSXJiY3YzWm1XTGVJNWlNOU4yR3VWXzRzRUc1Vnk3dkwyVDRmaXJva0lTM1E0ZADhSalBIdlE0MQZDZD"; //da inserire
	private String idPost ="17893061450319032";//inserire

	private String urlUtente="https://graph.instagram.com/me/media?fields=";
	//url per gestire richieste al profilo
	private String urlPost="https://graph.instagram.com/";
	//url per gestire richieste al post
	
	@Override
	public JSONObject getDataUser(String field) {
	//permette di ottenere informazioni su tutti i post dell'utente 
	//il tipo di informazione è definita dalla variabile fields
		JSONObject data_user=null;

		try {
			URLConnection openConnection=new URL(urlUtente+field+"&access_token="+token).openConnection();
			InputStream in=openConnection.getInputStream();

			String data="";
			String line="";
			try {
				InputStreamReader inR= new InputStreamReader(in);
				BufferedReader buf= new BufferedReader(inR);
				while((line=buf.readLine()) != null) {
					data+=line;
				}

			}finally {in.close();}
        //String[] fields = field.split(","); per èassare gli argomenti di req param ai metodi
       
			data_user=(JSONObject) JSONValue.parseWithException(data);
		}catch (IOException e ) {System.out.println("Errore");}
		catch (Exception e) {System.out.println("Errore");}
		return data_user;
	}
	
	@Override
	public JSONObject getAllUser() {
	//permette di ottenere tutte le info possibili da tutti
	//i post dell'utente
		JSONObject all_user=null;

		try {
			URLConnection openConnection=new URL(urlUtente+"media_type,caption,timestamp"+"&access_token="+token).openConnection();
			InputStream in=openConnection.getInputStream();

			String data="";
			String line="";
			try {
				InputStreamReader inR= new InputStreamReader(in);
				BufferedReader buf= new BufferedReader(inR);
				while((line=buf.readLine()) != null) {
					data+=line;
				}

			}finally {in.close();}

			all_user=(JSONObject) JSONValue.parseWithException(data);
		}catch (IOException e ) {System.out.println("Errore");}
		catch (Exception e) {System.out.println("Errore");}
		return all_user;
	}
	
	@Override
    public JSONObject getDataPost(String field) {
		//permette di ottenere informazioni su un post dell'utente 
		//il tipo di informazione è definita dalla variabile fields
			JSONObject data_post=null;
			                     
			try {
				URLConnection openConnection=new URL(urlPost+idPost+"/?fields="+field+"&access_token="+token).openConnection();
				InputStream in=openConnection.getInputStream();

				String data="";
				String line="";
				try {
					InputStreamReader inR= new InputStreamReader(in);
					BufferedReader buf= new BufferedReader(inR);
					while((line=buf.readLine()) != null) {
						data+=line;
					}

				}finally {in.close();}

				data_post=(JSONObject) JSONValue.parseWithException(data);
			}catch (IOException e ) {System.out.println("Errore");}
			catch (Exception e) {System.out.println("Errore");}
			return data_post;
		}
		
	@Override
	public JSONObject getAllPost() {
		//permette di ottenere tutte le info possibili da un
		//solo post dell'utente
		JSONObject all_post=null;

		try {
			URLConnection openConnection=new URL(urlPost+idPost+"/?fields=media_type,caption,timestamp"+"&access_token="+token).openConnection();
			InputStream in=openConnection.getInputStream();

			String data="";
			String line="";
			try {
				InputStreamReader inR= new InputStreamReader(in);
				BufferedReader buf= new BufferedReader(inR);
				while((line=buf.readLine()) != null) {
					data+=line;
				}

			}finally {in.close();}

			all_post=(JSONObject) JSONValue.parseWithException(data);
		}catch (IOException e ) {System.out.println("Errore");}
		catch (Exception e) {System.out.println("Errore");}
		return all_post;
	}

	public ArrayList<Post>  JsonReading() {
		//prende il JSON che ritorna l'api di instagram
		//e lo mette in un ArrayList
		ArrayList <Post> postList = new ArrayList<Post>();
		JSONObject file =getAllUser();
		//Ottengo il jsonArray che contiene la lista di tutti dati di tutti post
        JSONArray jsonArrayPost = (JSONArray) file.get("data");
        //Per ogni oggetto del JSONArray prendo i value e
        //li salvo in un oggetto Post
        for (int i=0;i<jsonArrayPost.size(); i++) {
        	String caption=(((JSONObject) jsonArrayPost.get(i)).get("caption")).toString();
        	String id=(((JSONObject) jsonArrayPost.get(i)).get("id")).toString();
        	String timestamp=(((JSONObject) jsonArrayPost.get(i)).get("timestamp")).toString();
        	String media_type=(( (JSONObject) jsonArrayPost.get(i)).get("media_type")).toString();
        	
        	Post post = new Post (media_type,caption,id,timestamp);
        
        	postList.add(i, post);
        }
        return postList;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject getMedia(String metod,String field) {
		JSONObject jj = new JSONObject();
		if (metod.equals("NumberOfRepetition") || metod.equals("Suggestion") || metod.equals("Ranking")) {
		    ArrayList<Post> pp=new ArrayList<Post>();
			pp=JsonReading();
			MediaType mt=new MediaType(pp);
			switch(metod) {
			case ("NumberOfRepetition"):
				if (field.equals("IMAGE") || field.equals("VIDEO") || field.equals("CAROUSEL_ALBUM")) {
				jj.put("Numero ripetizioni", mt.NumberOfRepetition(field));
				}
				else {jj.put("Errore: ", "field non valido");}	
			break;
			case ("Ranking"):
			    jj.put("Ranking", mt.Ranking(null));
			break;
			case ("Suggestion"):
				jj.put("Suggestion", mt.Suggestion(null));
			break;
			}
		}
		else {jj.put("Errore: ", "metod non valido");}
		return jj;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject getTimestamp(String metod,String field) {
		JSONObject jj = new JSONObject();
		if (metod.equals("NumberOfRepetition") || metod.equals("Ranking")) {
		    ArrayList<Post> pp=new ArrayList<Post>();
			pp=JsonReading();
			TimeStamp mt=new TimeStamp(pp);
			switch(metod) {
			case ("NumberOfRepetition"):
				if (field.length() == 4) {
				jj.put("Numero ripetizioni", mt.NumberOfRepetition(field));
				}
				else {jj.put("Errore: ", "field non valido");}	
			break;
			case ("Ranking"):
				String [] input= field.split(",");
	     	jj.put("Più usato",mt.Ranking(input));
			break;
			
		   }
		}
		else {jj.put("Errore: ", "metod non valido");}
		return jj;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject getCaption(String metod, String theme) {
		JSONObject jj=new JSONObject();
		
		if (metod.equals("NumberOfRepetition") || metod.equals("Suggestion") || metod.equals("Ranking")) {
			ArrayList<Post> pp=new ArrayList<Post>();
			pp=JsonReading();
			Caption cc=new Caption (pp);
			switch (metod){
			case ("Suggestion"):
				if (theme.equals("sport") || theme.equals("cerimonia") || theme.equals("insieme")) {
					jj.put("Hashtag consigliato",cc.Suggestion(theme));
				}
				else {jj.put("Errore: ", "inserire un tema a scelta tra: sport, insieme o cerimonia");}
			break;
			case ("NumberOfRepetition"):
				if (theme.equals("null")){jj.put("Errore: ","inserire field");}
				else {jj.put("Ripetuto",cc.NumberOfRepetition(theme));}
				
		    break;
			case("Ranking"):
				String [] input= theme.split(",");
		     	jj.put("Più usato",cc.Ranking(input));
		    break;
			}
		}
		else {jj.put("Errore: ", "metod non valido");}
		return jj;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject getFilterYear(String year) {
		JSONObject jj=new JSONObject();
		if (year.length() == 4) {
		ArrayList<Post> pp=new ArrayList<Post>();
		pp=JsonReading();
		FiltroAnno fa=new FiltroAnno(pp);
		
		jj.put("Post", fa.post_annuali(year));
		}
		else {
		String error = "Errore, inserire un anno valido";
		jj.put("Post", error );
		}
		return jj;
	}
	public JSONObject getFilterPost(String data) {
		ArrayList<Post> pp=new ArrayList<Post>();
		pp=JsonReading();
		FilterPost fp=new FilterPost(pp);
		JSONObject jj=new JSONObject();
		jj=fp.getPost(data);
		return jj;
		
		
}
	
	public JSONObject getFilterMediaType(String MediaType) {
		
		JSONObject jj=new JSONObject();
		if(MediaType.equals("IMAGE") || MediaType.equals("VIDEO") || MediaType.equals("CAROUSEL_ALBUM")) {
		ArrayList<Post> pp= new ArrayList();
		pp=JsonReading();
		
		FiltroMediaType fm=new FiltroMediaType(pp);
		
		jj.put("Post", fm.tipi_di_post(MediaType));
		}else {
		jj.put("Inserire un formato valido","IMAGE,VIDEO o CAROUSEL_ALBUM");
		}
		
		
		
		return jj;
		
	}

}

		