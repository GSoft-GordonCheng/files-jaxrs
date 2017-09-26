package gordon.files.dto;

import java.io.Serializable;

/**
* @author Gordon
*/
public class ErrorDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String code;
	private String message;
	private String field;
	
	public ErrorDTO() {
		this(null, null, null);
	}
	public ErrorDTO(String code, String msg) {
		this(code, msg, null);
	}
	public ErrorDTO(String code, String msg, String field) {
		this.code = code;
		this.message = msg;
		this.field = field;
	}
	public String getCode() {
		return this.code;
	}
	public void setCode(String value) {
		this.code = value;
	}
	public String getMessage() {
		return this.message;
	}
	public void setMessage(String value) {
		this.message = value;
	}
	public String getField() {
		return this.field;
	}
	public void setField(String value) {
		this.field = value;
	}
	
}