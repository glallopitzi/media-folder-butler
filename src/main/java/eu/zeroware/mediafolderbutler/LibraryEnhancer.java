package eu.zeroware.mediafolderbutler;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.name.Named;


public class LibraryEnhancer extends LibraryWorker{
	
	private static Logger logger = LogManager.getLogger(LibraryEnhancer.class);	
	
	@Inject
	public LibraryEnhancer(@Named("debug") Boolean debug, @Named("musicRootFolder") String musicRootFolder) {
		super(debug, musicRootFolder);
	}
	
	public void enhance(){
		logger.info("in enhanceLibrary");
		// TODO		
	}
	
	
	
	
	public void print() {
		logger.info(library.toString());
	}

}
