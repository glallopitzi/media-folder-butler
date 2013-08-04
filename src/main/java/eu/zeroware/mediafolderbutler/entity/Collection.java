package eu.zeroware.mediafolderbutler.entity;

import java.util.ArrayList;
import java.util.List;

import org.farng.mp3.id3.ID3v1;

public class Collection {
	private Artist artist;
	private String name;
	private String year;
	private List<Creation> creations;

	private List<String> genres;
	private List<String> tags;

	private String mbid;
	
	public Collection() {}

	public Collection(Creation creation) {
		this.artist = new Artist(creation.getArtist());
		this.name = creation.getAlbum();
		this.year = creation.getYear();
		this.creations = new ArrayList<Creation>();
		creations.add(creation);
	}
	
	public Collection(String name) {
		this.name = name;
	}
	
	public Collection(String name, String artist) {
		this.name = name;
		this.artist = new Artist(artist);
	}
	
	public Collection(ID3v1 id3v1Tag) {
		this.name = id3v1Tag.getAlbum();
		this.year = id3v1Tag.getYear();
	}
	
	public void addSong(Creation creation){
		this.creations.add(creation);
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Album info" + "\n");
		builder.append("------------" + "\n");
		builder.append("Name: " + name + "\n");
		if (artist != null)
			builder.append("Artist: " + artist.getName() + "\n");
		if (year != null)
			builder.append("Year: " + year + "\n");
		builder.append("Songs number: " + creations.size() + "\n");
		builder.append("------------" + "\n");
		return builder.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		Collection collection = (Collection) obj;
		try {
			return this.name.equals(collection.getName()) && this.artist.getName().equals(collection.getArtist().getName());
		} catch (Exception e) {
			// logger.warn
			return false;
		} 
	}

	

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
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

	public List<Creation> getTracks() {
		return creations;
	}

	public void setTracks(List<Creation> creations) {
		this.creations = creations;
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
