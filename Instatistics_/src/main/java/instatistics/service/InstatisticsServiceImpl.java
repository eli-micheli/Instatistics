package instatistics.service;
import instatistics.model.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.apache.coyote.http11.AbstractHttp11JsseProtocol;
import org.json.simple.JSONArray;

import org.springframework.stereotype.Service;
@Service
public class InstatisticsServiceImpl implements InstatisticsService {
	

	private String token="IGQVJYMjQzaVpCQ191SmswRTFBY1ZACblhUT0NBQWFvamtFYmlsQ1ZAQd3J2T19fdTVjZAjZAwcFB0TEZAadzV3dGMtOC1iS1IwRXltSDhIenhpWWktemlETDFwVy1IRkV3YU1WVC1XY05xV0JaODRTWVF0agZDZD"; //da inserire
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


	@SuppressWarnings("unchecked")
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
        //mi converte l'ArrayList in un JSONObject
      //  JSONObject jsonList = new JSONObject();
        //PostList pp=new PostList(postList);
        //jsonList.put("post", postList);
       /* for(int i=0;i<postList.size();i++) {
        	System.out.println(postList.get(i).media_type);
        }*/
        
        return postList;
	}
	/*public JSONObject Test() {	
		//creo oggetto postlist e richiamo la funzione
		//PostList pl=new PostList(null);
		PostList pl=JsonReading();
		//MediaType mm=new MediaType(pl);
		//return mm.Ranking();
		JSONObject jj=new JSONObject();
		jj.put("file", pl);
		
		System.out.println(pl.toString());
		return jj;
		
	}*/
	public JSONObject getMedia() {
		ArrayList<Post> pp=new ArrayList<Post>();
		pp=JsonReading();
		Media_type_2 mt=new Media_type_2(pp);
		
		//ArrayList<String> p1=new ArrayList<String>();
		/*for(int i=0;i<pp.size();i++) {
			p1.add(i, pp.get(i).media_type);
		}*/
		/*for(int j=0;j<p1.size();j++) {
			System.out.println(p1.get(j));
		}*/
		//MediaType mm=new MediaType(pp);
		
		
	/*	for(int i=0;i<pp.size();i++) {
			System.out.println(pp.get(i).getMedia_type());
		}*/
	/*	for(int i=0;i<pp.size();i++) {
			if(pp.get(i).getMedia_type().equals("CAROUSEL_ALBUM")) {
				cont++;
				
			}
		}*/
		
		JSONObject jj=new JSONObject();
		jj.put("CAROUSEL_ALBUM", mt.getCount_album());
		jj.put("IMAGE", mt.getCount_image());
		jj.put("VIDEO", mt.getCount_video());
		return jj;
		
		
		
	}
		













}

		