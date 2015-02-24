package eu.zeroware.mediafolderbutler.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class Library {

	private static Logger logger = LogManager.getLogger(Library.class);
	
	private MediaFileType libraryType;
	
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
		genres = new ArrayList<String>();
		tags = new ArrayList<String>();
		duplicatedMediaElements = new ArrayList<Creation>();
		unknownMediaElements = new ArrayList<Creation>();
	}

	
	public void addMediaElementsToLibrary(Creation creation) {
		if(addCreationToLibrary(creation)){
			if(addCollectionToLibrary(creation)){
				addArtistToLibrary(creation);
			}
		}
	}

	
	
	private boolean addCreationToLibrary(Creation creation) {
		if(!creations.contains(creation)){
			creations.add(creation);
			logger.info("Creation: " + creation.getName() + " added to Library");
			return true;
		}else{
			duplicatedMediaElements.add(creation);
			return false;
		}
	}

	private boolean addArtistToLibrary(Creation creation) {
		Artist artist = new Artist(creation);
		if (!artists.contains(artist)) {
			artists.add(artist);
			logger.info("Artist: " + artist.getName() + " added to Library");
			return true;
		}else{
			artists.get(artists.indexOf(artist)).addCreation(creation);
			return false;
		}
	}

	private boolean addCollectionToLibrary(Creation creation) {
		Collection collection = new Collection(creation);
		if (!collections.contains(collection)) {
			collections.add(collection);
			logger.info("Collection: " + collection.getName() + " added to Library");
			return true;
		}else{
			collections.get(collections.indexOf(collection)).addCreation(creation);
			return false;
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

	public List<Collection> getCollections() {
		return collections;
	}

	public void setCollections(List<Collection> collections) {
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

	public void setCreations(List<Creation> creations) {
		this.creations = creations;
	}

	public List<Creation> getCreations() {
		return creations;
	}

	public void setDuplicatedMediaElements(List<Creation> duplicatedMediaElements) {
		this.duplicatedMediaElements = duplicatedMediaElements;
	}

	public List<Creation> getDuplicatedMediaElements() {
		return duplicatedMediaElements;
	}

	public void setUnknownMediaElements(List<Creation> unknownMediaElements) {
		this.unknownMediaElements = unknownMediaElements;
	}

	public List<Creation> getUnknownMediaElements() {
		return unknownMediaElements;
	}


	public MediaFileType getLibraryType() {
		return libraryType;
	}


	public void setLibraryType(MediaFileType libraryType) {
		this.libraryType = libraryType;
	}

}
