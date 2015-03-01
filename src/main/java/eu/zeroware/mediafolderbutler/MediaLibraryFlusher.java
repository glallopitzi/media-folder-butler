package eu.zeroware.mediafolderbutler;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import eu.zeroware.mediafolderbutler.book.BookLibraryFlusher;
import eu.zeroware.mediafolderbutler.movie.MovieLibraryFlusher;
import eu.zeroware.mediafolderbutler.music.MusicLibraryFlusher;


public class MediaLibraryFlusher extends LibraryWorker implements Flusher {
	
	private static Logger logger = LogManager.getLogger(MediaLibraryFlusher.class);	
	
	@Autowired
	private MusicLibraryFlusher musicLibraryFlusher;
	@Autowired
	private MovieLibraryFlusher movieLibraryFlusher;
	@Autowired 
	private BookLibraryFlusher bookLibraryFlusher;
	
	public void flush(){
		logger.info("in flushLibrary");
		if(builderMusic) musicLibraryFlusher.flush();
		if(builderMovie) movieLibraryFlusher.flush();
		if(builderBook) bookLibraryFlusher.flush();
	}

}
