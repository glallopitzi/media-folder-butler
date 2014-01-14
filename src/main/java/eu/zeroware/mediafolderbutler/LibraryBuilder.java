package eu.zeroware.mediafolderbutler;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.google.inject.Inject;

public class LibraryBuilder extends LibraryWorker{
	
	private static Logger logger = LogManager.getLogger(LibraryBuilder.class);
	
	@Inject private eu.zeroware.mediafolderbutler.music.LibraryBuilder musicLibraryBuilder;
	@Inject private eu.zeroware.mediafolderbutler.movie.MovieLibraryBuilder movieLibraryBuilder;
	@Inject private eu.zeroware.mediafolderbutler.book.BookLibraryBuilder bookLibraryBuilder;
	
	public void build(){
		logger.info("in buildLibrary");

	}
	
}
