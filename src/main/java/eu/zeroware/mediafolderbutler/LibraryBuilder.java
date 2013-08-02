package eu.zeroware.mediafolderbutler;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class LibraryBuilder extends LibraryWorker{
	
	private static Logger logger = LogManager.getLogger(LibraryBuilder.class);
	
	@Inject
	public LibraryBuilder(@Named("debug") Boolean debug, @Named("musicRootFolder") String musicRootFolder) {
		super(debug, musicRootFolder);
	}
	
	public void build(){
		logger.info("in buildLibrary");
		// TODO
	}	
	
	public void print() {
		logger.info(library.toString());
	}

}
