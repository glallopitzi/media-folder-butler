package eu.zeroware.mediafolderbutler.entity;

import java.io.File;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Creation {

	private static Logger logger = LogManager.getLogger(Creation.class);
	
	private String id;
	
	private File file;
	private String filename;
	private String foldername;
	private String fileType;
	
	private String name;
	
	private String number;

	private String collection;
	private String artist;
	private String year;
	private String genre;
	
	public Creation() {}
	
	public Creation(String name) {
		this.name = name;
		this.file = null;
	}
	
	public Creation(File file) {
		this.file = file;
		this.filename = file.getName();
		this.foldername = file.getParentFile().getName();
		this.fileType = StringUtils.substringAfterLast(file.getName(), ".");
	}
	
	public Creation(File file, String fileType, String name, String number,
			String collection, String artist, String year) {
		super();
		this.file = file;
		this.fileType = fileType;
		this.name = name;
		this.number = number;
		this.collection = collection;
		this.artist = artist;
		this.year = year;
	}

	public boolean isComplete() {
		return (StringUtils.isNotBlank(name)) 
				&& (StringUtils.isNotBlank(number))
				&& (StringUtils.isNotBlank(artist)) 
				&& (StringUtils.isNotBlank(collection))
				&& (StringUtils.isNotBlank(year));
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Creation info" + "\n");
		builder.append("------------" + "\n");
		builder.append("Name: " + name + "\n");
		builder.append("Number: " + number + "\n");
		builder.append("Collection: " + collection + "\n");
		builder.append("Artist: " + artist + "\n");
		builder.append("Year: " + year + "\n");
		if(file!=null)
			builder.append("File: " + file.getName() + "\n");
		else
			builder.append("File: NOT PRESENT\n");
		builder.append("------------" + "\n");
		return builder.toString();
	}
	
	
	@Override
	public boolean equals(Object obj) {
		Creation creation = (Creation) obj;
		try {
			return this.name.equals(creation.getName());
		} catch (Exception e) {
			logger.error("Some error during creation comparison", e);
			return false;
		}
	}

	
	
	
	
	
	// getters and setters
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getYear() {
		return year;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getGenre() {
		return genre;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFilename() {
		return filename;
	}

	public void setFoldername(String foldername) {
		this.foldername = foldername;
	}

	public String getFoldername() {
		return foldername;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileType() {
		return fileType;
	}

}
