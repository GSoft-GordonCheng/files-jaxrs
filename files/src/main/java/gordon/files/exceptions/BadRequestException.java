package gordon.files.exceptions;
/**
* @author Gordon
*/

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import gordon.files.dto.ErrorDTO;
import gordon.files.dto.ErrorListDTO;

public class BadRequestException extends WebApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BadRequestException(String code, String msg){
		this(new ErrorListDTO(new ErrorDTO(code, msg)));
	}
	public BadRequestException(String code, String msg, String field){
		this(new ErrorListDTO(new ErrorDTO(code, msg, field)));
	}
	public BadRequestException(ErrorListDTO dto){
		super(Response.status(BAD_REQUEST)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity(new Gson().toJson(dto)).encoding("UTF-8")
                .build());		
	}
}
