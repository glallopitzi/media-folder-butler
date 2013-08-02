package eu.zeroware.mediafolderbutler.music.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class Library {

	private static Logger logger = LogManager.getLogger(Library.class);
	
	private List<Artist> artists;
	private List<Album> albums;
	private List<Song> songs;
	
	private List<String> genres;
	private List<String> tags;

	private List<Song> duplicateTracks;
	private List<Song> unknowTracks;
	
	public Library() {
		artists = new ArrayList<Artist>();
		albums = new ArrayList<Album>();
		songs = new ArrayList<Song>();
		duplicateTracks = new ArrayList<Song>();
		unknowTracks = new ArrayList<Song>();
	}

	
	public void addTrackToLibrary(Song song) {
		addSongToLibrary(song);
		addAlbumToLibrary(song);
		addArtistToLibrary(song);
	}

	
	
	private void addSongToLibrary(Song song) {
		if(!songs.contains(song)){
			songs.add(song);
			logger.info("Song: " + song.getName() + " added to Library");

			
		}else{
			duplicateTracks.add(song);
		}
	}

	private void addArtistToLibrary(Song song) {
		Artist artist = new Artist(song);
		if (!artists.contains(artist)) {
			artists.add(artist);
			logger.info("Artist: " + artist.getName() + " added to Library");
			
			
		}else{
			artists.get(artists.indexOf(artist)).addSong(song);
		}
	}

	private void addAlbumToLibrary(Song song) {
		Album album = new Album(song);
		if (!albums.contains(album)) {
			albums.add(album);
			logger.info("Album: " + album.getName() + " added to Library");
			
			
		}else{
			albums.get(albums.indexOf(album)).addSong(song);
		}
	}

	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nLibrary details:\n");
		sb.append(" - artists found: " + artists.size() + "\n");
		for (Artist artist : artists) {
			sb.append(artist);
		}
		sb.append("\n=======\n");
		
		sb.append(" - albums found: " + albums.size() + "\n");
		for (Album album : albums) {
			sb.append(album);
		}
		return sb.toString();
	}

	
	
	
	
	
	
	
	
	// getters and setters
	public List<Artist> getArtists() {
		return artists;
	}

	public void setArtists(List<Artist> artists) {
		this.artists = artists;
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

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setDuplicateTracks(List<Song> duplicateTracks) {
		this.duplicateTracks = duplicateTracks;
	}

	public List<Song> getDuplicateTracks() {
		return duplicateTracks;
	}

	public void setUnknowTracks(List<Song> unknowTracks) {
		this.unknowTracks = unknowTracks;
	}

	public List<Song> getUnknowTracks() {
		return unknowTracks;
	}

}
