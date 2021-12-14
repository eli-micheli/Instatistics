package instatistics.model;

import java.util.ArrayList;

public class PostList {
	ArrayList <Post> pp = new ArrayList <Post>();
	
	public PostList (ArrayList <Post> pp) {
		this.pp = pp;
	}

	public MediaType mediaConverter() {
		MediaType mArray = new MediaType();
		for ( int i=0; i<pp.size(); i++) {
			mArray.array.add(i,pp.get(i).media_type);
		}
		return mArray;
	}
	
	public Caption captionConverter() {
		Caption cArray = new Caption();
		for ( int i=0; i<pp.size(); i++) {
			Caption.array.add(i,pp.get(i).caption);
		}
		return cArray;
	}
	
	public Id idConverter() {
		Id mId=new Id();
		for(int i=0;i<pp.size();i++) {
			mId.array.add(i,pp.get(i).id);
		}
		
	public Timestamp timestampConverter() {
			Timestamp mTimestamp=new Timestamp();
			for(int i=0;i<pp.size();i++) {
				mTimestamp.array.add(i,pp.get(i).timestamp);
			}
	}
	
	
	
	
	
	
}
