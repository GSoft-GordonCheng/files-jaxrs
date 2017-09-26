package gordon.files;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

/**
* @author Gordon
*/
public class ResFile {
	static public String generateName(String source) {
		if (null==source || "".equals(source)) {
			return "";
		}
		UUID uuid = UUID.randomUUID();
		String fid = uuid.toString();
		String[] extNames = source.split("\\.");
		if (extNames.length>1) {
			fid += "." + extNames[extNames.length-1];
		}        
		return fid;
	}
	// save uploaded file to new location
	static public void writeToFile(InputStream isFile, String name) throws Exception {
		try {
			OutputStream out = new FileOutputStream(new File(name));
			int read = 0;
			byte[] bytes = new byte[1024];
			out = new FileOutputStream(new File(name));
			while ((read = isFile.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}
}
