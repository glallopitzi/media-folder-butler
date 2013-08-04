package eu.zeroware.mediafolderbutler.entity;

import java.io.File;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Creation {

	private static Logger logger = LogManager.getLogger(Creation.class);
	
	private File file;
	private String filename;
	private String foldername;
	private String audioFileType;
	
	private String name;
	private String number;

	private String album;
	private String artist;
	private String year;
	private String genre;
	
	private String mbid;
	
	public Creation() {}
	
	public Creation(File file) {
		this.file = file;
		this.filename = file.getName();
		this.foldername = file.getParentFile().getName();
		this.audioFileType = StringUtils.substringAfterLast(file.getName(), ".");
	}
	
	
	public Creation(File file, String audioFileType, String name, String number,
			String album, String artist, String year) {
		super();
		this.file = file;
		this.audioFileType = audioFileType;
		this.name = name;
		this.number = number;
		this.album = album;
		this.artist = artist;
		this.year = year;
	}

	
	
	
	public boolean isComplete() {
		return (StringUtils.isNotBlank(name)) 
				&& (StringUtils.isNotBlank(number))
				&& (StringUtils.isNotBlank(artist)) 
				&& (StringUtils.isNotBlank(album))
				&& (StringUtils.isNotBlank(year));
	}

	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Song info" + "\n");
		builder.append("------------" + "\n");
		builder.append("Name: " + name + "\n");
		builder.append("Number: " + number + "\n");
		builder.append("Album: " + album + "\n");
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
			logger.error("Some error during song comparison", e);
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

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
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

	public String getMbid() {
		return mbid;
	}

	public void setMbid(String mbid) {
		this.mbid = mbid;
	}

	public void setAudioFileType(String audioFileType) {
		this.audioFileType = audioFileType;
	}

	public String getAudioFileType() {
		return audioFileType;
	}

}
