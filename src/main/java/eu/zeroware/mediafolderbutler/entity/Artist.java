package eu.zeroware.mediafolderbutler.entity;

import java.util.ArrayList;
import java.util.List;

import eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.search.ArtistSearchResultItem;

public class Artist {
	private String name;
	private List<Collection> collections;
	private List<Creation> creations;
	
	private List<String> genres;
	private List<String> tags;
	
	private String mbid;
	
	public Artist() {
	}

	public Artist(Creation creation) {
		this.name = creation.getArtist();
		creations = new ArrayList<Creation>();
		creations.add(creation);
		collections = new ArrayList<Collection>();
		collections.add(new Collection(creation.getAlbum(), creation.getArtist()));
	}
	
	public Artist(String name) {
		this.name = name;
	}

	public Artist(ArtistSearchResultItem artistSearchResultItem) {
		this.name = artistSearchResultItem.getName();
	}

	public void addSong(Creation creation){
		if(!creations.contains(creation)){
			creations.add(creation);
		}
		
		addAlbum(creation);
	}
	
	public void addAlbum(Creation creation){
		Collection collection = new Collection(creation.getAlbum(), creation.getArtist());
		if(!collections.contains(collection)){
			collections.add(collection);
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
		if(collections != null)
			builder.append("Albums number: " + collections.size() + "\n");
		builder.append("------------" + "\n");
		return builder.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Collection> getAlbums() {
		return collections;
	}

	public void setAlbums(List<Collection> collections) {
		this.collections = collections;
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

	public void setSongs(List<Creation> creations) {
		this.creations = creations;
	}

	public List<Creation> getSongs() {
		return creations;
	}
}
