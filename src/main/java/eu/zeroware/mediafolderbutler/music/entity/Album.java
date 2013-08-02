package eu.zeroware.mediafolderbutler.music.entity;

import java.util.ArrayList;
import java.util.List;

import org.farng.mp3.id3.ID3v1;

public class Album {
	private Artist artist;
	private String name;
	private String year;
	private List<Song> songs;

	private List<String> genres;
	private List<String> tags;

	private String mbid;
	
	public Album() {}

	public Album(Song song) {
		this.artist = new Artist(song.getArtist());
		this.name = song.getAlbum();
		this.year = song.getYear();
		this.songs = new ArrayList<Song>();
		songs.add(song);
	}
	
	public Album(String name) {
		this.name = name;
	}
	
	public Album(String name, String artist) {
		this.name = name;
		this.artist = new Artist(artist);
	}
	
	public Album(ID3v1 id3v1Tag) {
		this.name = id3v1Tag.getAlbum();
		this.year = id3v1Tag.getYear();
	}
	
	public void addSong(Song song){
		this.songs.add(song);
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
		builder.append("Songs number: " + songs.size() + "\n");
		builder.append("------------" + "\n");
		return builder.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		Album album = (Album) obj;
		try {
			return this.name.equals(album.getName()) && this.artist.getName().equals(album.getArtist().getName());
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

	public List<Song> getTracks() {
		return songs;
	}

	public void setTracks(List<Song> songs) {
		this.songs = songs;
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
