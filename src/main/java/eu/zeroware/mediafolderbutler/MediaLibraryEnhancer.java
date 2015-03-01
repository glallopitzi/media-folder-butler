package eu.zeroware.mediafolderbutler;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import eu.zeroware.mediafolderbutler.book.BookLibraryEnhancer;
import eu.zeroware.mediafolderbutler.movie.MovieLibraryEnhancer;
import eu.zeroware.mediafolderbutler.music.MusicLibraryEnhancer;


public class MediaLibraryEnhancer extends LibraryWorker implements Enhancer {
	
	private static final Logger logger = Logger.getLogger(MediaLibraryEnhancer.class);	
	
	@Autowired 
	private MusicLibraryEnhancer musicLibraryEnhancer;
	@Autowired	
	private MovieLibraryEnhancer movieLibraryEnhancer;
	@Autowired	
	private BookLibraryEnhancer bookLibraryEnhancer;
	
	public void enhance(){
		logger.info("in enhanceLibrary");
		if(builderMusic) musicLibraryEnhancer.enhance();
		if(builderMovie) movieLibraryEnhancer.enhance();
		if(builderBook) bookLibraryEnhancer.enhance();
	}
	
}
