package eu.zeroware.mediafolderbutler;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.google.inject.Inject;

import eu.zeroware.mediafolderbutler.book.BookLibraryFlusher;
import eu.zeroware.mediafolderbutler.movie.MovieLibraryFlusher;
import eu.zeroware.mediafolderbutler.music.MusicLibraryFlusher;


public class MediaLibraryFlusher extends LibraryWorker implements Flusher {
	
	private static Logger logger = LogManager.getLogger(MediaLibraryFlusher.class);	
	
	@Inject private MusicLibraryFlusher musicLibraryFlusher;
	@Inject private MovieLibraryFlusher movieLibraryFlusher;
	@Inject private BookLibraryFlusher bookLibraryFlusher;
	
	public void flush(){
		logger.info("in flushLibrary");
			// TODO
	}

}
