package gordon.files.dto;

import java.io.Serializable;

/**
* @author Gordon
*/
public class FileDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	
	public FileDTO() {
		
	}
	
	public FileDTO(String id) {
		this.id = id;
	}
	
	public String getId() {
		return this.id;
	}
	
	public void getId(String value) {
		this.id = value;
	}
}
