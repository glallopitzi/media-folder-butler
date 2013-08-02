package eu.zeroware.mediafolderbutler.movie.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class Library {

	private static Logger logger = LogManager.getLogger(Library.class);
	
	private List<Director> directors;
	private List<Album> albums;
	private List<Movie> movies;
	
	private List<String> genres;
	private List<String> tags;

	private List<Movie> duplicateTracks;
	private List<Movie> unknowTracks;
	
	public Library() {
		directors = new ArrayList<Director>();
		albums = new ArrayList<Album>();
		movies = new ArrayList<Movie>();
		duplicateTracks = new ArrayList<Movie>();
		unknowTracks = new ArrayList<Movie>();
	}

	
	public void addTrackToLibrary(Movie movie) {
		addSongToLibrary(movie);
		addAlbumToLibrary(movie);
		addArtistToLibrary(movie);
	}

	
	
	private void addSongToLibrary(Movie movie) {
		if(!movies.contains(movie)){
			movies.add(movie);
			logger.info("Song: " + movie.getName() + " added to Library");

			
		}else{
			duplicateTracks.add(movie);
		}
	}

	private void addArtistToLibrary(Movie movie) {
		Director director = new Director(movie);
		if (!directors.contains(director)) {
			directors.add(director);
			logger.info("Artist: " + director.getName() + " added to Library");
			
			
		}else{
			directors.get(directors.indexOf(director)).addSong(movie);
		}
	}

	private void addAlbumToLibrary(Movie movie) {
		Album album = new Album(movie);
		if (!albums.contains(album)) {
			albums.add(album);
			logger.info("Album: " + album.getName() + " added to Library");
			
			
		}else{
			albums.get(albums.indexOf(album)).addSong(movie);
		}
	}

	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nLibrary details:\n");
		sb.append(" - artists found: " + directors.size() + "\n");
		for (Director director : directors) {
			sb.append(director);
		}
		sb.append("\n=======\n");
		
		sb.append(" - albums found: " + albums.size() + "\n");
		for (Album album : albums) {
			sb.append(album);
		}
		return sb.toString();
	}

	
	
	
	
	
	
	
	
	// getters and setters
	public List<Director> getArtists() {
		return directors;
	}

	public void setArtists(List<Director> directors) {
		this.directors = directors;
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

	public void setSongs(List<Movie> movies) {
		this.movies = movies;
	}

	public List<Movie> getSongs() {
		return movies;
	}

	public void setDuplicateTracks(List<Movie> duplicateTracks) {
		this.duplicateTracks = duplicateTracks;
	}

	public List<Movie> getDuplicateTracks() {
		return duplicateTracks;
	}

	public void setUnknowTracks(List<Movie> unknowTracks) {
		this.unknowTracks = unknowTracks;
	}

	public List<Movie> getUnknowTracks() {
		return unknowTracks;
	}

}
