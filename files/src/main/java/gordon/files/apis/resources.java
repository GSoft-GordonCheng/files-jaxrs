package gordon.files.apis;

import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import com.google.gson.Gson;

import gordon.files.dto.FileDTO;

/**
* @author Gordon
*/
@Path("/")
public class resources {
	
	@POST
	@Path("/")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response upload(
			@FormDataParam("file") InputStream fileStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail) throws IOException
	{
		String fileName = fileDetail.getFileName();
		FileDTO dto = new FileDTO(fileName);
		return Response.ok()
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity(new Gson().toJson(dto)).encoding("UTF-8")
                .build();	
	}
}
