package eu.zeroware.mediafolderbutler.movie.entity;

import org.apache.log4j.Logger;


public class Library extends eu.zeroware.mediafolderbutler.entity.Library {

	private static final Logger logger = Logger.getLogger(Library.class);
	
	@Override
	public String toString() {
		logger.debug("Movie library toString");
		String toString = super.toString();
		return toString;
	}

}
