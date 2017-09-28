# File Upload
|1| build.gradle  |
|2| web.xml  |
|3| code  |
## build.gradle
dependencies {
	compile group: 'org.glassfish.jersey.media', name: 'jersey-media-multipart', version: '2.25.1'
}
## web.xml
<servlet>
  <init-param>
    <param-name>jersey.config.server.provider.classnames</param-name>
    <param-value>org.glassfish.jersey.media.multipart.MultiPartFeature</param-value>
  </init-param>
</servlet>
## code
@Path("/")
public class resources {
	
	@POST
	@Path("/")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response upload(
			@FormDataParam("file") InputStream isFile,
			@FormDataParam("file") FormDataContentDisposition fileContent)
	{
		String fileName = (null!=fileContent) ? ResFile.generateName(fileContent.getFileName()) : "";
    // TODO: Open/Save File...
    return Response
                .ok()
                .build();
	}
}
