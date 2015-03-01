package eu.zeroware.mediafolderbutler.music;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class MusicFolderButlerApplication {

private static Logger logger = LogManager.getLogger(MusicFolderButlerApplication.class);
	
	@Autowired
	private MusicLibraryBuilder libraryBuilder;
	
	@Autowired
	private MusicLibraryEnhancer libraryEnhancer;
	
	@Autowired
	private MusicLibraryFlusher libraryFlusher;
	
	////////////////////////////////////////////////////////////	
	// BUILD STEP
	public void buildLibrary() {
		logger.info("buildLibrary - INIT");
		libraryBuilder.build();
		libraryBuilder.print();
		logger.info("buildLibrary - END");
	}

	////////////////////////////////////////////////////////////	
	// ENHANCE STEP
	public void enhanceLibrary(){
		logger.info("enhanceLibrary - INIT");
		libraryEnhancer.setLibrary(libraryBuilder.getLibrary());
		libraryEnhancer.setSkippedFiles(libraryBuilder.getSkippedFiles());
		libraryEnhancer.enhance();
		libraryEnhancer.print();
		logger.info("enhanceLibrary - END");
	}
	
	////////////////////////////////////////////////////////////
	// FLUSH STEP
	private void flushLibrary() {
		logger.info("flushLibrary - INIT");
		libraryFlusher.setLibrary(libraryEnhancer.getLibrary());
		libraryFlusher.setSkippedFiles(libraryEnhancer.getSkippedFiles());
		libraryFlusher.flush();
		logger.info("flushLibrary - END");
	}

	
	public static void main(String[] args) {
        SpringApplication.run(MusicFolderButlerApplication.class, args);
    }
}
