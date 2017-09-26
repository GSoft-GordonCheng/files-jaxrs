package gordon.files.apis;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;


import gordon.files.ResFile;
import gordon.files.WebApplication;
import gordon.files.dto.FileDTO;
import gordon.files.exceptions.BadRequestException;
import gordon.files.exceptions.InternalServerErrorException;
import gordon.files.exceptions.NotFoundException;

/**
* @author Gordon
*/
@Path("/")
public class resources {
	
	@POST
	@Path("/")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public FileDTO upload(
			@FormDataParam("file") InputStream isFile,
			@FormDataParam("file") FormDataContentDisposition fileContent)
	{
		//throw new BadRequestException("CE0000","name is null");
		String filePath = WebApplication.properties.getProperty("path", "");
		String fileName = (null!=fileContent) ? ResFile.generateName(fileContent.getFileName()) : "";
		if (null == isFile || null == fileContent) {
			throw new BadRequestException("CE0000","file is null");
		}
		if ("".equals(fileName)) {
			throw new BadRequestException("CE0000","name is null");
		}
		if ("".equals(filePath)) {
			throw new InternalServerErrorException("SE0000","InternalServerError");
		}
        try {
        		String saveName = filePath + fileName;
        		System.out.println(filePath);
        		System.out.println(saveName);
			ResFile.writeToFile(isFile, saveName);
		} catch (Exception e) {
			e.printStackTrace();
			throw new InternalServerErrorException();
		}
		return new FileDTO(fileName);
	}	
	
	@GET
	@Path("/{name}")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response download(@PathParam("name")  String fileName) {
		String filePath = WebApplication.properties.getProperty("path", "");
		if ("".equals(fileName)) {
			throw new BadRequestException("CE0000","name is null");
		}
		if ("".equals(filePath)) {
			throw new InternalServerErrorException("SE0000","InternalServerError");
		}		
		StreamingOutput fileStream =  new StreamingOutput()
        {
            @Override
            public void write(java.io.OutputStream output) throws IOException, NotFoundException
            {
            		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
                try
                {	
            			System.out.println("loading..." + dateFormat.format(new Date()));
                    java.nio.file.Path path = Paths.get(filePath+fileName);
                    byte[] data = Files.readAllBytes(path);
                    output.write(data);
                    output.flush();
                }
                catch (Exception e)
                {
                    throw new NotFoundException();
                }
                finally {
        				System.out.println("loaded...." + dateFormat.format(new Date()));
                }
            }
        };		
        return Response
                .ok(fileStream, MediaType.APPLICATION_OCTET_STREAM)
                .header("content-disposition","attachment; filename = " + fileName)
                .build();
	}
}
