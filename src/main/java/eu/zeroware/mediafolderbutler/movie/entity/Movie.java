package eu.zeroware.mediafolderbutler.movie.entity;

import java.io.File;

import org.apache.log4j.Logger;

import eu.zeroware.mediafolderbutler.entity.Creation;

public class Movie extends Creation {

	private static final Logger logger = Logger.getLogger(Movie.class);
	
	public Movie() {logger.debug("new Movie");}
	
	public Movie(File file) {
		super(file);
		logger.debug("new Movie, file: " + file.getName());
	}
	
	public Movie(File file, String fileType, String name, String number,
			String album, String artist, String year) {
		super(file, fileType, name, number, album, artist, year);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Movie info" + "\n");
		builder.append("------------" + "\n");
		builder.append("Name: " + getName() + "\n");
		builder.append("Number: " + getNumber() + "\n");
		builder.append("Album: " + getCollection() + "\n");
		builder.append("Artist: " + getArtist() + "\n");
		builder.append("Year: " + getYear() + "\n");
		if( getFile() != null )
			builder.append("File: " + getFile().getName() + "\n");
		else
			builder.append("File: NOT PRESENT\n");
		builder.append("------------" + "\n");
		return builder.toString();
	}
	
}
