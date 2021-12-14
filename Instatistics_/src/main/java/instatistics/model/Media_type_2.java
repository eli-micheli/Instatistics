package instatistics.model;

import java.util.ArrayList;

public class Media_type_2 {
	private ArrayList<Post> pp=new ArrayList<Post>();
	private int cont_album=0;
	private int cont_image=0;
	private int cont_video=0;
	public Media_type_2(ArrayList<Post> pp) {
		this.pp=pp;
	}
	public int getCount_album() {
		for(int i=0;i<pp.size();i++) {
			if(pp.get(i).getMedia_type().equals("CAROUSEL_ALBUM")) {
			 cont_album++;
				
			}
		}
		return cont_album;
		
		
	}
	public int getCount_image() {
		for(int i=0;i<pp.size();i++) {
			if(pp.get(i).getMedia_type().equals("IMAGE")) {
			 cont_image++;
				
			}
		}
		return cont_image;
	}
	public int getCount_video() {
		for(int i=0;i<pp.size();i++) {
			if(pp.get(i).getMedia_type().equals("VIDEO")) {
			 cont_video++;
				
			}
		}
		return cont_video;
	}
}
