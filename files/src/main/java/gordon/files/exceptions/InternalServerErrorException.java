package gordon.files.exceptions;

import static javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import gordon.files.dto.ErrorListDTO;
import gordon.files.dto.ErrorDTO;

/**
* @author Gordon
*/
public class InternalServerErrorException extends WebApplicationException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InternalServerErrorException(){
		this(new ErrorListDTO(new ErrorDTO("SE9999", "unknown")));
	}
	public InternalServerErrorException(String code, String msg){
		this(new ErrorListDTO(new ErrorDTO(code, msg)));
	}
	public InternalServerErrorException(ErrorListDTO dto){
		super(Response.status(INTERNAL_SERVER_ERROR)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity(new Gson().toJson(dto)).encoding("UTF-8")
                .build());		
	}
	
	/*
	 * 測試錯誤碼DTO約定格式
	ErrorListDTO dto = new ErrorListDTO();
	ErrorItemDTO e1 = new ErrorItemDTO("CE8888", "create token error");
	ErrorFieldDTO e2 = new ErrorFieldDTO("CE5555", "create token error", "title");
	dto.add(e1);
	dto.add(e2);
	 */	
}