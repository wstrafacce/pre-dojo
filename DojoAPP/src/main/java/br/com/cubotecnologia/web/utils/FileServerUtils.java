package br.com.cubotecnologia.web.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import br.com.cubotecnologia.utils.FileUtils;

public class FileServerUtils extends FileUtils{
	
	private static final Logger lgLOGGER = LoggerFactory.getLogger(FileServerUtils.class);	
	private static final String sSYSTEM_PROPERTY = "catalina.home";
	private static final String sDIR = "tmpFiles";
	private static final String sFILE = "dojo.log";
	
	public static File uploadFileOnServer(MultipartFile mfFile) {
		
		File serverFile = null;
		
		if (!mfFile.isEmpty()) {
			try {
				byte[] bytes = mfFile.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty(sSYSTEM_PROPERTY);
				File dir = new File(rootPath + File.separator + sDIR);
				if (!dir.exists())
					dir.mkdirs();
				
				// Create the file on server
				serverFile = new File(dir.getAbsolutePath()
						+ File.separator + sFILE);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				lgLOGGER.info("Server File Location="
						+ serverFile.getAbsolutePath());

			} catch (Exception e) {
				lgLOGGER.error("Failed to upload => " + e);
			}
		} else {
			lgLOGGER.error("Failed to upload because the file was empty.");
		}
		
		return serverFile;
	}

}
