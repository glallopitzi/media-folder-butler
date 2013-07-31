package eu.zeroware.mediafolderbutler;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;


public class MusicFolderOrganizer {

	private static Logger logger = LogManager.getLogger(MusicFolderOrganizer.class);
	
	@Inject private LibraryBuilder libraryBuilder;
	@Inject private LibraryEnhancer libraryEnhancer;
	@Inject private LibraryFlusher libraryFlusher;
	
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

	
	
	
	
	
	
	
	
	
	////////////////////////////////////////////////////////////
	// MAIN METHOD
	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new MusicFolderOrganizerModule());
		MusicFolderOrganizer organizer = injector.getInstance(MusicFolderOrganizer.class);
		organizer.buildLibrary();
		organizer.enhanceLibrary();
		organizer.flushLibrary();
	}
}
