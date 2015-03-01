package eu.zeroware.mediafolderbutler;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class MediaFolderButlerApplication implements CommandLineRunner {

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
	
	@Override
	public void run(String... args) throws Exception {
		logger.debug("run");
		
//		buildLibrary();
//		enhanceLibrary();
//		flushLibrary();
	}
	
}
