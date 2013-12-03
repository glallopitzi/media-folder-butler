package eu.zeroware.mediafolderbutler.movie.entity;

import eu.zeroware.mediafolderbutler.entity.Artist;

public class Director extends Artist {
		
	public Director() {}

	public Director(Movie movie) {
		super(movie);
	}
	
	public Director(String name) {
		super(name);
	}

	public void addSong(Movie movie){
		super.addCreation(movie);
	}
	
	public void addAlbum(Movie movie){
		super.addCollection(movie);
	}
	
	
	@Override
	public String toString() {
		String toString = super.toString();
		// TODO replace Artist with Director and Collections with ??
		return toString;
	}

}
