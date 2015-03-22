package Main;

import java.io.File;
import java.net.URL;

import org.apache.commons.io.FileUtils;

public class CDownloadAFile {

	final static String url = "http://localhost:8080";
	
	final static String _FILE_PATH = "/tmp/";
	final static String _FILE_NAME = "eclipse-jee-luna-SR1-linux-gtk-x86_64.tar.gz";
	
	public static void main(String[] args) {

		try {
			
			FileUtils.copyURLToFile( new URL( url ), new File( _FILE_PATH + _FILE_NAME ) );
		
		} 
		catch ( Exception e ) {

			e.printStackTrace();
		}
		
	}

}
