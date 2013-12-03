package eu.zeroware.mediafolderbutler.book.entity;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class Library extends eu.zeroware.mediafolderbutler.entity.Library {

	private static Logger logger = LogManager.getLogger(Library.class);
	
	@Override
	public String toString() {
		logger.debug("Book library toString");
		String toString = super.toString();
		return toString;
	}

}
