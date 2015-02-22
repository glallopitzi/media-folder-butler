package eu.zeroware.mediafolderbutler;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.google.inject.Inject;


public class LibraryEnhancer extends LibraryWorker implements Enhancer {
	
	private static Logger logger = LogManager.getLogger(LibraryEnhancer.class);	
	
	@Inject private eu.zeroware.mediafolderbutler.music.LibraryEnhancer musicLibraryEnhancer;
	@Inject private eu.zeroware.mediafolderbutler.movie.MovieLibraryEnhancer movieLibraryEnhancer;
	@Inject private eu.zeroware.mediafolderbutler.book.BookLibraryEnhancer bookLibraryEnhancer;
	
	public void enhance(){
		logger.info("in enhanceLibrary");
		// TODO		
	}
	
}
