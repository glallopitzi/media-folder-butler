package eu.zeroware.mediafolderbutler.book.entity;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import eu.zeroware.mediafolderbutler.entity.MediaFileType;


public class Library extends eu.zeroware.mediafolderbutler.entity.Library {

	private static Logger logger = LogManager.getLogger(Library.class);
	
	public Library() {
		super();
		setLibraryType(MediaFileType.BOOK);
	}
	

	@Override
	public String toString() {
		logger.debug("Book library toString");
		String toString = super.toString();
		return toString;
	}

}
