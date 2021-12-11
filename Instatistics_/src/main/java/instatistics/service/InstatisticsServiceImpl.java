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
	private String url="https://graph.instagram.com/me/media?fields=";
    
	@Override
	public JSONObject getMedia_type(String word) {
		JSONObject media=null;
		
		try {
			URLConnection openConnection=new URL(url+word+"&access_token="+token).openConnection();
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
