package eu.zeroware.mediafolderbutler;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.google.inject.Inject;


public class LibraryFlusher extends LibraryWorker implements Flusher {
	
	private static Logger logger = LogManager.getLogger(LibraryFlusher.class);	
	
	@Inject private eu.zeroware.mediafolderbutler.music.LibraryFlusher musicLibraryFlusher;
	@Inject private eu.zeroware.mediafolderbutler.movie.MovieLibraryFlusher movieLibraryFlusher;
	@Inject private eu.zeroware.mediafolderbutler.book.BookLibraryFlusher bookLibraryFlusher;
	
	public void flush(){
		logger.info("in flushLibrary");
			// TODO
	}

}
