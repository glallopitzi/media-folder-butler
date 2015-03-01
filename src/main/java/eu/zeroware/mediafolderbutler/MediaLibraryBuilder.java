package eu.zeroware.mediafolderbutler;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import eu.zeroware.mediafolderbutler.book.BookLibraryBuilder;
import eu.zeroware.mediafolderbutler.movie.MovieLibraryBuilder;
import eu.zeroware.mediafolderbutler.music.MusicLibraryBuilder;

public class MediaLibraryBuilder extends LibraryWorker implements Builder {
	
	private static Logger logger = LogManager.getLogger(MediaLibraryBuilder.class);
	
	@Autowired
	private MusicLibraryBuilder musicLibraryBuilder;
	@Autowired	
	private MovieLibraryBuilder movieLibraryBuilder;
	@Autowired
	private BookLibraryBuilder bookLibraryBuilder;
	
	public void build(){
		logger.info("in buildLibrary");
		if(builderMusic) musicLibraryBuilder.build();
		if(builderMovie) movieLibraryBuilder.build();
		if(builderBook) bookLibraryBuilder.build();
	}
	
}
