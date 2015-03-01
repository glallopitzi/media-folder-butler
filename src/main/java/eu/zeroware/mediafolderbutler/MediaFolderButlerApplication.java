package eu.zeroware.mediafolderbutler;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class MediaFolderButlerApplication {

	private static final Logger logger = Logger.getLogger(MediaFolderButlerApplication.class);
	
	@Autowired
	private MediaLibraryBuilder libraryBuilder;
	@Autowired
	private MediaLibraryEnhancer libraryEnhancer;
	@Autowired
	private MediaLibraryFlusher libraryFlusher;
	
	////////////////////////////////////////////////////////////	
	// BUILD STEP
	public void buildLibrary() {
		logger.info("buildLibrary - INIT");
		libraryBuilder.build();
		logger.info("buildLibrary - END");
	}

	////////////////////////////////////////////////////////////	
	// ENHANCE STEP
	public void enhanceLibrary(){
		logger.info("enhanceLibrary - INIT");
//		libraryEnhancer.setLibrary(libraryBuilder.getLibrary());
		
		libraryEnhancer.enhance();
//		libraryEnhancer.print();
		logger.info("enhanceLibrary - END");
	}
	
	////////////////////////////////////////////////////////////
	// FLUSH STEP
	private void flushLibrary() {
		logger.info("flushLibrary - INIT");
//		libraryFlusher.setLibrary(libraryEnhancer.getLibrary());
		libraryFlusher.flush();
		logger.info("flushLibrary - END");
	}
	
	
	public static void main(String[] args) {
        SpringApplication.run(MediaFolderButlerApplication.class, args);
    }
	
}
