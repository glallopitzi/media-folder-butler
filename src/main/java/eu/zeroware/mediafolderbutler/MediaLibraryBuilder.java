package eu.zeroware.mediafolderbutler;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.google.inject.Inject;

import eu.zeroware.mediafolderbutler.book.BookLibraryBuilder;
import eu.zeroware.mediafolderbutler.movie.MovieLibraryBuilder;
import eu.zeroware.mediafolderbutler.music.MusicLibraryBuilder;

public class MediaLibraryBuilder extends LibraryWorker implements Builder {
	
	private static Logger logger = LogManager.getLogger(MediaLibraryBuilder.class);
	
	@Inject private MusicLibraryBuilder musicLibraryBuilder;
	@Inject private MovieLibraryBuilder movieLibraryBuilder;
	@Inject private BookLibraryBuilder bookLibraryBuilder;
	
	public void build(){
		logger.info("in buildLibrary");
		if(builderMusic) musicLibraryBuilder.build();
		if(builderMovie) movieLibraryBuilder.build();
		if(builderBook) bookLibraryBuilder.build();
	}
	
}
