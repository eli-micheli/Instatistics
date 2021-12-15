package prova;

import java.util.ArrayList;

public class prova {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     ArrayList<String> parola=new ArrayList<String>();
     ArrayList<String> hastag=new ArrayList<String>();

     parola.add( "#ciao#hey#mare");
     parola.add("#ciao#k#unn");
     parola.add( "#ciao#,are#unn#l");
     for(int i=0;i<parola.size();i++) {
			for(int j=0;j<(parola.get(i)).length();j++) {
				
				if( parola.get(i).charAt(j)=='#') {
					hastag.add(parola.get(j).substring(j+1));
			}
			
		}
	
		
		}
     System.out.println(hastag);
	}

}
