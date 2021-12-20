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
/**
 * <b>Classe</b> che descrive i servizi dell'API.
 * Estende l'interfaccia Service.
 * @author Micheli Elisa 
 * @author Mattioli Sara
 */
@Service
public class InstatisticsServiceImpl implements InstatisticsService {
	/**
	 * token dell'utente
	 */
	private String token=""; //da inserire
	/**
	 * id del post per getAllPost e getDataPost
	 */
	private String idPost ="";//inserire
    /**
     * url per gestire richieste al profilo
     */
	private String urlUtente="https://graph.instagram.com/me/media?fields=";
	/**
	 * url per gestire richieste al post
	 */
	private String urlPost="https://graph.instagram.com/";
	/**
	 *<b>Metodo</b> permette di ottenere informazioni su tutti i post dell'utente 
	 * il tipo di informazione è definita dalla variabile fields.
	 * @param field oggetto del post su cui ottenere l'informazione.
	 */
	public JSONObject getDataUser(String field) {
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
       
			data_user=(JSONObject) JSONValue.parseWithException(data);
		}catch (IOException e ) {System.out.println("Errore");}
		catch (Exception e) {System.out.println("Errore");}
		return data_user;
	}
	/**
	 *<b>Metodo</b> permette di ottenere tutte le info possibili
	 *da tutti i post dell'utente
	 */
	public JSONObject getAllUser() {
	
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
	/**
	 *<b>Metodo</b> permette di ottenere informazioni su un post dell'utente 
	 *il tipo di informazione è definita dalla variabile fields.
	 * @param field oggetto del post su cui ottenere l'informazione.
	 */
    public JSONObject getDataPost(String field) {
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
    /**
	 *<b>Metodo</b> permette di ottenere tutte le info possibili da un
	 *solo post dell'utente
	 */	
	public JSONObject getAllPost() {
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
    /**
     * <b>Metodo</b> che prende il JSON che ritorna l'api di instagram e lo mette in un ArrayList.
     * Serve come metodo di collegamento tra i dati e le sattistiche.
     */
	public ArrayList<Post>  JsonReading() {
		ArrayList <Post> postList = new ArrayList<Post>();
		JSONObject file = getAllUser();
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
	/**
	 *<b>Metodo</b> che permette di ottenere le statistiche sul tipo di post.
	 */	
	@SuppressWarnings("unchecked")
	public JSONObject getMedia(String filter,String metod,String field) {
		JSONObject JsonReturn = new JSONObject();
		String [] filterInfo = filter.split(","); //filter continene il tipo  di filtro e la specifica
		                                          //del filtro in una sola stringa. Con lo split divido le due informazioni.
		if(filterInfo[0].equals("null") || filterInfo[0].equals("yearFilter") || filterInfo[0].equals("mediaFilter")) {
			if (metod.equals("NumberOfRepetition") || metod.equals("Suggestion") || metod.equals("Ranking")) {
				ArrayList<Post> allPost=new ArrayList<Post>();
                switch (filterInfo[0]) {
                case("null"):
				allPost=JsonReading();
                break;
                case("yearFilter"):
    				allPost=getFilterYear(filterInfo[1]);
                break;
                case("mediaFilter"):
    				allPost=getFilterMediaType(filterInfo[1]);
                break;
                }
				MediaType mediatype=new MediaType(allPost);
				switch(metod) {
				case ("NumberOfRepetition"):
					if (field.equals("IMAGE") || field.equals("VIDEO") || field.equals("CAROUSEL_ALBUM")) {
						JsonReturn.put("Numero ripetizioni", mediatype.NumberOfRepetition(field));
					}
					else {JsonReturn.put("Errore: ", "field non valido");}	
				break;
				case ("Ranking"):
					JsonReturn.put("Ranking", mediatype.Ranking(null));
				break;
				case ("Suggestion"):
					JsonReturn.put("Suggestion", mediatype.Suggestion(null));
				break;
				}
			}
			else {JsonReturn.put("Errore: ", "metod non valido");}
		}
		else {JsonReturn.put("Errore: ", "filter non valido");}
		return JsonReturn;
	}
	/**
	 *<b>Metodo</b> che permette di ottenere le statistiche sulla data dei post.
	 */	
	@SuppressWarnings("unchecked")
	public JSONObject getTimestamp(String metod,String field) {
		JSONObject JsonReturn = new JSONObject();
		if (metod.equals("NumberOfRepetition") || metod.equals("Ranking")) {
		    ArrayList<Post> allPost=new ArrayList<Post>();
			allPost=JsonReading();
			TimeStamp timestamp=new TimeStamp(allPost);
			switch(metod) {
			case ("NumberOfRepetition"):
				if (field.length() == 4) {
				JsonReturn.put("Numero ripetizioni", timestamp.NumberOfRepetition(field));
				}
				else {JsonReturn.put("Errore: ", "field non valido");}	
			break;
			case ("Ranking"):
				String [] input= field.split(",");
	     	JsonReturn.put("Più usato",timestamp.Ranking(input));
			break;
			
		   }
		}
		else {JsonReturn.put("Errore: ", "metod non valido");}
		return JsonReturn;
	}
	/**
	 *<b>Metodo</b> che permette di ottenere le statistiche sulla didascalia del post.
	 */	
	@SuppressWarnings("unchecked")
	public JSONObject getCaption(String metod, String theme) {
		JSONObject JsonReturn=new JSONObject();
		
		if (metod.equals("NumberOfRepetition") || metod.equals("Suggestion") || metod.equals("Ranking")) {
			ArrayList<Post> allPost=new ArrayList<Post>();
			allPost=JsonReading();
			Caption caption=new Caption (allPost);
			switch (metod){
			case ("Suggestion"):
				if (theme.equals("sport") || theme.equals("cerimonia") || theme.equals("insieme")) {
					JsonReturn.put("Hashtag consigliato",caption.Suggestion(theme));
				}
				else {JsonReturn.put("Errore: ", "inserire un tema a scelta tra: sport, insieme o cerimonia");}
			break;
			case ("NumberOfRepetition"):
				if (theme.equals("null")){JsonReturn.put("Errore: ","inserire field");}
				else {JsonReturn.put("Ripetuto",caption.NumberOfRepetition(theme));}
				
		    break;
			case("Ranking"):
				String [] input= theme.split(",");
		     	JsonReturn.put("Più usato",caption.Ranking(input));
		    break;
			}
		}
		else {JsonReturn.put("Errore: ", "metod non valido");}
		return JsonReturn;
	}
	/**
	 *<b>Metodo</b> che implementa il filtro annuale.
	 */	
	@SuppressWarnings("unchecked")
	public ArrayList<Post> getFilterYear(String year) {
		ArrayList<Post> filtratedPost= new ArrayList<Post>();
		JSONObject JsonReturn=new JSONObject();
		if (year.length() == 4) {
		ArrayList<Post> allPost=new ArrayList<Post>();
		allPost=JsonReading();
		FiltroAnno YearFilter=new FiltroAnno(allPost);
		
		filtratedPost = YearFilter.post_annuali(year);
		}
		else {
		JsonReturn.put("Errore", "inserire un anno valido");
		}
		return filtratedPost;
	}
	/**
	 *<b>Metodo</b> che implementa il filtro giornaliero.
	 */	
	@SuppressWarnings("unchecked")
	public JSONObject getFilterPostforDate(String data) {
		
		ArrayList<Post> allPost=new ArrayList<Post>();
		allPost=JsonReading();
		FilterPostforDate DateFilter=new FilterPostforDate(allPost);
		
		JSONObject JsonReturn = new JSONObject();
		JsonReturn .put("Post", DateFilter.getPostforDate(data));

		return JsonReturn;
	}
	/**
	 *<b>Metodo</b> che implementa il filtro di tipo.
	 */	
	@SuppressWarnings("unchecked")
	public ArrayList<Post> getFilterMediaType(String MediaType) {
		ArrayList<Post> filtratedPost= new ArrayList<Post>();
		if(MediaType.equals("IMAGE") || MediaType.equals("VIDEO") || MediaType.equals("CAROUSEL_ALBUM")) {
		ArrayList<Post> allPost= new ArrayList<Post>();
		allPost=JsonReading();
		
		FiltroMediaType MediaFilter=new FiltroMediaType(allPost);
		
		filtratedPost = MediaFilter.tipi_di_post(MediaType);
		}else {
		System.out.println("Errore: Inserire un formato valido: IMAGE,VIDEO o CAROUSEL_ALBUM");
		}
		return filtratedPost;
	}
}

		