package eu.zeroware.mediafolderbutler;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.google.inject.Inject;


public class MediaLibraryFlusher extends LibraryWorker implements Flusher {
	
	private static Logger logger = LogManager.getLogger(MediaLibraryFlusher.class);	
	
	@Inject private eu.zeroware.mediafolderbutler.music.MusicLibraryFlusher musicLibraryFlusher;
	@Inject private eu.zeroware.mediafolderbutler.movie.MovieLibraryFlusher movieLibraryFlusher;
	@Inject private eu.zeroware.mediafolderbutler.book.BookLibraryFlusher bookLibraryFlusher;
	
	public void flush(){
		logger.info("in flushLibrary");
			// TODO
	}

}
