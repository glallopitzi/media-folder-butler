package eu.zeroware.mediafolderbutler.book.entity;

import java.util.ArrayList;
import java.util.List;

import org.farng.mp3.id3.ID3v1;

public class Album {
	private Writer writer;
	private String name;
	private String year;
	private List<Book> books;

	private List<String> genres;
	private List<String> tags;

	private String mbid;
	
	public Album() {}

	public Album(Book book) {
		this.writer = new Writer(book.getArtist());
		this.name = book.getAlbum();
		this.year = book.getYear();
		this.books = new ArrayList<Book>();
		books.add(book);
	}
	
	public Album(String name) {
		this.name = name;
	}
	
	public Album(String name, String artist) {
		this.name = name;
		this.writer = new Writer(artist);
	}
	
	public Album(ID3v1 id3v1Tag) {
		this.name = id3v1Tag.getAlbum();
		this.year = id3v1Tag.getYear();
	}
	
	public void addSong(Book book){
		this.books.add(book);
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Album info" + "\n");
		builder.append("------------" + "\n");
		builder.append("Name: " + name + "\n");
		if (writer != null)
			builder.append("Artist: " + writer.getName() + "\n");
		if (year != null)
			builder.append("Year: " + year + "\n");
		builder.append("Songs number: " + books.size() + "\n");
		builder.append("------------" + "\n");
		return builder.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		Album album = (Album) obj;
		try {
			return this.name.equals(album.getName()) && this.writer.getName().equals(album.getArtist().getName());
		} catch (Exception e) {
			// logger.warn
			return false;
		} 
	}

	

	public Writer getArtist() {
		return writer;
	}

	public void setArtist(Writer writer) {
		this.writer = writer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public List<Book> getTracks() {
		return books;
	}

	public void setTracks(List<Book> books) {
		this.books = books;
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

	public void setMbid(String mbid) {
		this.mbid = mbid;
	}

	public String getMbid() {
		return mbid;
	}
}
