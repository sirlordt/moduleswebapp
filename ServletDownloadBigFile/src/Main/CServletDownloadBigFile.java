package Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * You need the eclipse plugin "runjettyrun" or "Jetty Webapp" for run easy way the servlet
 * 
 * Servlet implementation class CServletDownloadBigFile
 */
@WebServlet("/")
public class CServletDownloadBigFile extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CServletDownloadBigFile() {

    	
    
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {

		
	
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String _FILE_PATH = "/home/sirlordt/Descargas/";
		final String _FILE_NAME = "eclipse-jee-luna-SR1-linux-gtk-x86_64.tar.gz";
		
		//response.getWriter().println( "¡¡¡Hola!!!!" );
		
		File fileData = new File( _FILE_PATH + _FILE_NAME );
		FileInputStream fis = new FileInputStream(fileData);
		response.setContentType( "multipart/mixed" );
		response.setHeader( "Content-Disposition", "attachment; filename=\"" + _FILE_NAME + "\";" );
		response.setContentLength( (int) fileData.length() );
		OutputStream os = response.getOutputStream();

		try {
			
		    IOUtils.copy(fis, os);
		    
		} finally {
		    
			IOUtils.closeQuietly(fis);
		    IOUtils.closeQuietly(os);
		    
		}		
		
		/*File fileData = new File( _FILE_PATH + _FILE_NAME );
		FileInputStream fis = new FileInputStream(fileData);
		response.setContentType("multipart/mixed");
		response.setHeader( "Content-Disposition", "attachment; filename=\"" + _FILE_NAME + "\";" );
		response.setContentLength( (int) fileData.length() );
		OutputStream os = response.getOutputStream();

		try {
		    
			int byteRead = 0;
		    
			while ( ( byteRead = fis.read() ) != -1 ) {
		    
				os.write( byteRead );
		    
			}
		    
		    os.flush();
		    
		} catch ( Exception excp ) {

			excp.printStackTrace();
		    
		} finally {

			os.close();
		    fis.close();
		    
		}*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		final String _UPLOAD_PATH = "/tmp/";
		
		//process only if its multipart content
        if( ServletFileUpload.isMultipartContent( request ) ){
            
        	try {

                List<FileItem> multiparts = new ServletFileUpload( new DiskFileItemFactory() ).parseRequest( request );

                for( FileItem item : multiparts ){
                    
                	if( !item.isFormField() ){
                    
                		String name = new File( item.getName() ).getName();
                        item.write( new File( _UPLOAD_PATH + File.separator + name ) );
                 	    System.out.println( "File Uploaded Successfully on path: " + _UPLOAD_PATH + File.separator + name );
                        
                    }
                	
                }

            } 
            catch ( Exception ex ) {

         	    System.out.println( "File Upload Failed due to " + ex );

            }          
         
        }
        
	}

}
