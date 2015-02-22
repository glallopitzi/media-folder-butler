package eu.zeroware.mediafolderbutler;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.google.inject.Inject;

import eu.zeroware.mediafolderbutler.book.BookLibraryEnhancer;
import eu.zeroware.mediafolderbutler.movie.MovieLibraryEnhancer;
import eu.zeroware.mediafolderbutler.music.MusicLibraryEnhancer;


public class MediaLibraryEnhancer extends LibraryWorker implements Enhancer {
	
	private static Logger logger = LogManager.getLogger(MediaLibraryEnhancer.class);	
	
	@Inject private MusicLibraryEnhancer musicLibraryEnhancer;
	@Inject private MovieLibraryEnhancer movieLibraryEnhancer;
	@Inject private BookLibraryEnhancer bookLibraryEnhancer;
	
	public void enhance(){
		logger.info("in enhanceLibrary");
		// TODO		
	}
	
}
