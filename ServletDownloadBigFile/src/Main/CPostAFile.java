package Main;

import java.io.File;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

//import org.apache.commons.httpclient.HttpClient;
//import org.apache.commons.httpclient.methods.PostMethod;

public class CPostAFile {

	
	final static String url = "http://localhost:8080";

	final static String _FILE_PATH = "/home/sirlordt/Descargas/";
	final static String _FILE_NAME = "eclipse-jee-luna-SR1-linux-gtk-x86_64.tar.gz";

	public static void main(String[] args) throws IOException {

	    CloseableHttpClient client = HttpClients.createDefault();
	    HttpPost httpPost = new HttpPost( url );
	 
	    MultipartEntityBuilder builder = MultipartEntityBuilder.create();
	    builder.addBinaryBody( "file", new File( _FILE_PATH + _FILE_NAME ), ContentType.APPLICATION_OCTET_STREAM, _FILE_NAME );
	    HttpEntity multipart = builder.build();
	 
	    httpPost.setEntity( multipart );
	 
	    CloseableHttpResponse response = client.execute( httpPost );
	    //assertThat(response.getStatusLine().getStatusCode(), equalTo(200));
	    
	    System.out.println( response.getStatusLine().getStatusCode() );
	    
	    client.close();
	    
	}
       
}
