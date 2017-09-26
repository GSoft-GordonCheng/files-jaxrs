package gordon.files.dto;

import java.io.Serializable;
import java.util.ArrayList;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

/**
* @author Gordon
*/
public class ErrorListDTO extends ArrayList<ErrorDTO>  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ErrorListDTO() {
		super();
	}
	public ErrorListDTO(ErrorDTO item) {
		this.add(item);
	}
	
}
