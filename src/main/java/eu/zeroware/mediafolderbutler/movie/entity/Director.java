package eu.zeroware.mediafolderbutler.movie.entity;

import java.util.ArrayList;
import java.util.List;

import eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.search.ArtistSearchResultItem;

public class Director {
	private String name;
	private List<Album> albums;
	private List<Movie> movies;
	
	private List<String> genres;
	private List<String> tags;
	
	private String mbid;
	
	public Director() {
	}

	public Director(Movie movie) {
		this.name = movie.getArtist();
		movies = new ArrayList<Movie>();
		movies.add(movie);
		albums = new ArrayList<Album>();
		albums.add(new Album(movie.getAlbum(), movie.getArtist()));
	}
	
	public Director(String name) {
		this.name = name;
	}

	public Director(ArtistSearchResultItem artistSearchResultItem) {
		this.name = artistSearchResultItem.getName();
	}

	public void addSong(Movie movie){
		if(!movies.contains(movie)){
			movies.add(movie);
		}
		
		addAlbum(movie);
	}
	
	public void addAlbum(Movie movie){
		Album album = new Album(movie.getAlbum(), movie.getArtist());
		if(!albums.contains(album)){
			albums.add(album);
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		Director o = (Director) obj;
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

	public void setSongs(List<Movie> movies) {
		this.movies = movies;
	}

	public List<Movie> getSongs() {
		return movies;
	}
}
