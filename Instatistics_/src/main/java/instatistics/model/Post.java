package instatistics.model;

public class Post {
	public String media_type;
	public String caption;
	public String id;
	public String timestamp;
	public Post(String media_type,String caption,String id,String timestamp) {
		this.caption=caption;
		this.media_type=media_type;
		this.id=id;
		this.timestamp=timestamp;
	}
	
	public String toString() {
		return media_type +id +timestamp +caption;
	}
	public String getMedia_type() {
		return media_type;
	}
	public void setMedia_type(String media_type) {
		this.media_type = media_type;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	//private MediaType mm = new MediaType();
	//public MediaType mediaConverter() {
		
		
	}


