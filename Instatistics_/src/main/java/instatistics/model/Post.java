package instatistics.model;
/**
 * <b>Classe</b> che descrive un post di Instagram.
 * @author Micheli Elisa 
 * @author Mattioli Sara
 */
public class Post {
	public String media_type;
	public String caption;
	public String id;
	public String timestamp;
	/**
	 * <b>Constructor</b> 
	 * @param media_type descrive il tipo di post.
	 * Puo' essere di tipo CAROUSEL_ALBUM,VIDEO o IMAGE.
	 * @param caption contiene la didascalia del post.
	 * @param id descrive l'id del post.
	 * @param timestamp contiene la data del post in formato ISO 8601
	 */
	public Post(String media_type,String caption,String id,String timestamp) {
		this.caption=caption;
		this.media_type=media_type;
		this.id=id;
		this.timestamp=timestamp;
	}
	/**
	 * <b>Metod</b> restituisce in stringa la classe.
	 * @return La classe sotto forma di stringa.
	 */
	public String toString() {
		return media_type +id +timestamp +caption;
	}
	/**
	 * <b>Metod</b> restituisce il tipo di post.
	 * @return Il tipo di post.
	 */
	public String getMedia_type() {
		return media_type;
	}
	/**
	 * <b>Metod</b> permette di modificare il tipo di post.
	 * @param media_type il nuovo tipo di post.
	 */
	public void setMedia_type(String media_type) {
		this.media_type = media_type;
	}
	/**
	 * <b>Metod</b> restituisce la didascalia del post.
	 * @return La didascalia del post.
	 */
	public String getCaption() {
		return caption;
	}
	/**
	 * <b>Metod</b> permette di modificare la didascalia del post.
	 * @param caption la nuova didascalia del post. 
	 */
	public void setCaption(String caption) {
		this.caption = caption;
	}
	/**
	 * <b>Metod</b> restituisce l'id del post.
	 * @return L'id del post.
	 */
	public String getId() {
		return id;
	}
	/**
	 * <b>Metod</b> permette di modificare l'id del post.
	 * @param id il nuovo id del post. 
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * <b>Metod</b> restituisce la data del post.
	 * @return La data del post.
	 */
	public String getTimestamp() {
		return timestamp;
	}
	/**
	 * <b>Metod</b> permette di modificare la data del post.
	 * @param timestamp la nuova data del post. 
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	}


