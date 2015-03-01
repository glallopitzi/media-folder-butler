package eu.zeroware.mediafolderbutler.book.entity;

import java.io.File;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import eu.zeroware.mediafolderbutler.entity.Creation;

public class Book extends Creation {

	private static final Logger logger = Logger.getLogger(Book.class);
	
	public Book() {}
	
	public Book(File file) {
		super(file);
		logger.debug("new Book, file: " + file.getName());
	}
	
	@Override
	public boolean isComplete() {
		return (StringUtils.isNotBlank(getName())) 
				&& (StringUtils.isNotBlank(getArtist())) 
				&& (StringUtils.isNotBlank(getYear()));
	}

	
	
	@Override
	public String toString() {
		logger.debug("Book toString");
		String toString = super.toString();
		return toString;
	}


}
