package eu.zeroware.mediafolderbutler.book.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class Library {

	private static Logger logger = LogManager.getLogger(Library.class);
	
	private List<Writer> writers;
	private List<Album> albums;
	private List<Book> books;
	
	private List<String> genres;
	private List<String> tags;

	private List<Book> duplicateTracks;
	private List<Book> unknowTracks;
	
	public Library() {
		writers = new ArrayList<Writer>();
		albums = new ArrayList<Album>();
		books = new ArrayList<Book>();
		duplicateTracks = new ArrayList<Book>();
		unknowTracks = new ArrayList<Book>();
	}

	
	public void addTrackToLibrary(Book book) {
		addSongToLibrary(book);
		addAlbumToLibrary(book);
		addArtistToLibrary(book);
	}

	
	
	private void addSongToLibrary(Book book) {
		if(!books.contains(book)){
			books.add(book);
			logger.info("Song: " + book.getName() + " added to Library");

			
		}else{
			duplicateTracks.add(book);
		}
	}

	private void addArtistToLibrary(Book book) {
		Writer writer = new Writer(book);
		if (!writers.contains(writer)) {
			writers.add(writer);
			logger.info("Artist: " + writer.getName() + " added to Library");
			
			
		}else{
			writers.get(writers.indexOf(writer)).addSong(book);
		}
	}

	private void addAlbumToLibrary(Book book) {
		Album album = new Album(book);
		if (!albums.contains(album)) {
			albums.add(album);
			logger.info("Album: " + album.getName() + " added to Library");
			
			
		}else{
			albums.get(albums.indexOf(album)).addSong(book);
		}
	}

	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nLibrary details:\n");
		sb.append(" - artists found: " + writers.size() + "\n");
		for (Writer writer : writers) {
			sb.append(writer);
		}
		sb.append("\n=======\n");
		
		sb.append(" - albums found: " + albums.size() + "\n");
		for (Album album : albums) {
			sb.append(album);
		}
		return sb.toString();
	}

	
	
	
	
	
	
	
	
	// getters and setters
	public List<Writer> getArtists() {
		return writers;
	}

	public void setArtists(List<Writer> writers) {
		this.writers = writers;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setSongs(List<Book> books) {
		this.books = books;
	}

	public List<Book> getSongs() {
		return books;
	}

	public void setDuplicateTracks(List<Book> duplicateTracks) {
		this.duplicateTracks = duplicateTracks;
	}

	public List<Book> getDuplicateTracks() {
		return duplicateTracks;
	}

	public void setUnknowTracks(List<Book> unknowTracks) {
		this.unknowTracks = unknowTracks;
	}

	public List<Book> getUnknowTracks() {
		return unknowTracks;
	}

}
