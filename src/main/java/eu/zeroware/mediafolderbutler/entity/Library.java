package eu.zeroware.mediafolderbutler.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class Library {

	private static Logger logger = LogManager.getLogger(Library.class);
	
	private List<Artist> artists;
	private List<Collection> collections;
	private List<Creation> creations;
	
	private List<String> genres;
	private List<String> tags;

	private List<Creation> duplicatedMediaElements;
	private List<Creation> unknownMediaElements;
	
	public Library() {
		artists = new ArrayList<Artist>();
		collections = new ArrayList<Collection>();
		creations = new ArrayList<Creation>();
		duplicatedMediaElements = new ArrayList<Creation>();
		unknownMediaElements = new ArrayList<Creation>();
	}

	
	public void addMediaElementsToLibrary(Creation creation) {
		addCreationToLibrary(creation);
		addCollectionToLibrary(creation);
		addArtistToLibrary(creation);
	}

	
	
	private void addCreationToLibrary(Creation creation) {
		if(!creations.contains(creation)){
			creations.add(creation);
			logger.info("Creation: " + creation.getName() + " added to Library");
		}else{
			duplicatedMediaElements.add(creation);
		}
	}

	private void addArtistToLibrary(Creation creation) {
		Artist artist = new Artist(creation);
		if (!artists.contains(artist)) {
			artists.add(artist);
			logger.info("Artist: " + artist.getName() + " added to Library");
		}else{
			artists.get(artists.indexOf(artist)).addCreation(creation);
		}
	}

	private void addCollectionToLibrary(Creation creation) {
		Collection collection = new Collection(creation);
		if (!collections.contains(collection)) {
			collections.add(collection);
			logger.info("Collection: " + collection.getName() + " added to Library");
		}else{
			collections.get(collections.indexOf(collection)).addCreation(creation);
		}
	}

	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nLibrary details:\n");
		
		sb.append("\n=======\n");
		sb.append(" - total artists found: " + artists.size() + "\n");
		for (Artist artist : artists) {
			sb.append(artist.toString());
		}
		
		sb.append("\n=======\n");
		sb.append(" - total collections found: " + collections.size() + "\n");
		for (Collection collection : collections) {
			sb.append(collection.toString());
		}
		
		sb.append("\n=======\n");
		sb.append(" - total creations found: " + creations.size() + "\n");
		for (Creation creation : creations) {
			sb.append(creation.toString());
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

	public List<Collection> getAlbums() {
		return collections;
	}

	public void setAlbums(List<Collection> collections) {
		this.collections = collections;
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

	public void setSongs(List<Creation> creations) {
		this.creations = creations;
	}

	public List<Creation> getSongs() {
		return creations;
	}

	public void setDuplicateTracks(List<Creation> duplicateTracks) {
		this.duplicatedMediaElements = duplicateTracks;
	}

	public List<Creation> getDuplicateTracks() {
		return duplicatedMediaElements;
	}

	public void setUnknowTracks(List<Creation> unknowTracks) {
		this.unknownMediaElements = unknowTracks;
	}

	public List<Creation> getUnknowTracks() {
		return unknownMediaElements;
	}

}
