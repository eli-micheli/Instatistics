package instatistics.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.stereotype.Service;
@Service
public class InstatisticsServiceImpl implements InstatisticsService {
	
	private String token=""; //da inserire
	private String idPost ="";//inserire
	private String urlUtente="https://graph.instagram.com/me/media?fields=";
	//url per gestire richieste al profilo
	private String urlPost="https://graph.instagram.com/";
	//url per gestire richieste al post
	@Override
	public JSONObject getDataUser(String field) {
	//permette di ottenere informazioni su tutti i post dell'utente 
	//il tipo di informazione è definita dalla variabile fields
		JSONObject media=null;

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

			media=(JSONObject) JSONValue.parseWithException(data);
		}catch (IOException e ) {System.out.println("Errore");}
		catch (Exception e) {System.out.println("Errore");}
		return media;
	}
	
	@Override
	public JSONObject getAllUser() {
	//permette di ottenere tutte le info possibili da tutti
	//i post dell'utente
		JSONObject media=null;

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

			media=(JSONObject) JSONValue.parseWithException(data);
		}catch (IOException e ) {System.out.println("Errore");}
		catch (Exception e) {System.out.println("Errore");}
		return media;
	}
	
	public JSONObject getDataPost(String field) {
		//permette di ottenere informazioni su un post dell'utente 
		//il tipo di informazione è definita dalla variabile fields
			JSONObject media=null;
			                     
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

				media=(JSONObject) JSONValue.parseWithException(data);
			}catch (IOException e ) {System.out.println("Errore");}
			catch (Exception e) {System.out.println("Errore");}
			return media;
		}
		
		@Override
		public JSONObject getAllPost() {
		//permette di ottenere tutte le info possibili da un
		//solo post dell'utente
			JSONObject media=null;

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

				media=(JSONObject) JSONValue.parseWithException(data);
			}catch (IOException e ) {System.out.println("Errore");}
			catch (Exception e) {System.out.println("Errore");}
			return media;
		}
	
	
}
