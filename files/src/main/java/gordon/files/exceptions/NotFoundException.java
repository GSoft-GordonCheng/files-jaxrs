package gordon.files.exceptions;
/**
* @author Gordon
*/

import static javax.ws.rs.core.Response.Status.NOT_FOUND;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


public class NotFoundException extends WebApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public NotFoundException() {
		super(Response.status(NOT_FOUND)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build());		
	}
}
