package instatistics.service;

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
	private String idPost ="";//inserire

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
	public JSONObject Test() {	
		//creo oggetto postlist e richiamo la funzione
		
		ArrayList<Post> pl=JsonReading();
		Caption mm = new Caption(pl);
		String risultato = mm.Suggestion("cerimonia");
		JSONObject jj=new JSONObject();
		jj.put("file", risultato);
	
		return jj;
		
	}
	@SuppressWarnings("unchecked")
	public JSONObject getMedia(String Argoument) {
		ArrayList<Post> pp=new ArrayList<Post>();
		pp=JsonReading();
		MediaType mt=new MediaType(pp);
		
		JSONObject jj = new JSONObject();
		jj.put("Numero ripetizioni", mt.NumberOfRepetition(Argoument));
		jj.put("Ranking", mt.Ranking(null));
		
		return jj;
	}
	
	public JSONObject getTimestamp(String Argoument) {
		ArrayList<Post> pp=new ArrayList<Post>();
		pp=JsonReading();
		TimeStamp tp=new TimeStamp(pp);
		JSONObject jj=new JSONObject();
		jj.put("Numero di post", tp.NumberOfRepetition(Argoument));
		return jj;
	}
		













}

		