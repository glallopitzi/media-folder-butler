package eu.zeroware.mediafolderbutler.music.entity;

import java.util.ArrayList;
import java.util.List;

import eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.search.ArtistSearchResultItem;

public class Artist {
	private String name;
	private List<Album> albums;
	private List<Song> songs;
	
	private List<String> genres;
	private List<String> tags;
	
	private String mbid;
	
	public Artist() {
	}

	public Artist(Song song) {
		this.name = song.getArtist();
		songs = new ArrayList<Song>();
		songs.add(song);
		albums = new ArrayList<Album>();
		albums.add(new Album(song.getAlbum(), song.getArtist()));
	}
	
	public Artist(String name) {
		this.name = name;
	}

	public Artist(ArtistSearchResultItem artistSearchResultItem) {
		this.name = artistSearchResultItem.getName();
	}

	public void addSong(Song song){
		if(!songs.contains(song)){
			songs.add(song);
		}
		
		addAlbum(song);
	}
	
	public void addAlbum(Song song){
		Album album = new Album(song.getAlbum(), song.getArtist());
		if(!albums.contains(album)){
			albums.add(album);
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		Artist o = (Artist) obj;
		try {
			return this.name.equals(o.getName());
		} catch (Exception e) {
			// logger.warn
			return false;
		}

	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Artist info" + "\n");
		builder.append("------------" + "\n");
		builder.append("Name: " + name + "\n");
		if(albums != null)
			builder.append("Albums number: " + albums.size() + "\n");
		builder.append("------------" + "\n");
		return builder.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setMbid(String mbid) {
		this.mbid = mbid;
	}

	public String getMbid() {
		return mbid;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	public List<Song> getSongs() {
		return songs;
	}
}
