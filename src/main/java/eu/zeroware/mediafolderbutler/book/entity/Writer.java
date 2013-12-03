package eu.zeroware.mediafolderbutler.book.entity;

import eu.zeroware.mediafolderbutler.entity.Artist;

public class Writer extends Artist {
	
	public Writer() {}

	public Writer(Book book) {
		super(book);
	}
	
	public Writer(String name) {
		super(name);
	}

	public void addBook(Book book){
		super.addCreation(book);
	}
	
	
	@Override
	public String toString() {
		String toString = super.toString();
		// TODO replace something here?
		return toString;
	}

}
