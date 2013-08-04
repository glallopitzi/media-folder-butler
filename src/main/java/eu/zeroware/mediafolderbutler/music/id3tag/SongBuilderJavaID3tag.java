package eu.zeroware.mediafolderbutler.music.id3tag;

import java.io.File;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.farng.mp3.MP3File;
import org.farng.mp3.id3.AbstractID3v2;
import org.farng.mp3.id3.ID3v1;

import eu.zeroware.mediafolderbutler.music.entity.Song;

public class SongBuilderJavaID3tag implements SongBuilder {

	private static Logger logger = LogManager.getLogger(SongBuilderJavaID3tag.class);
	
	public Song fromFile(File sourceFile) {
		MP3File mp3file = null;
		ID3v1 id3v1Tag = null;
		AbstractID3v2 id3v2Tag = null;
		
		try {
			mp3file = new MP3File(sourceFile);
		} catch (Exception e1) {
			logger.error(sourceFile.getName() + " skipped, add it to skipped list", e1);
		}
		
		if(mp3file != null){
			id3v1Tag = mp3file.getID3v1Tag();
			id3v2Tag = mp3file.getID3v2Tag();
			
			if (id3v1Tag != null) {
				try {
					return createNewSong(sourceFile, id3v1Tag);
				} catch (Exception e) {
					logger.error("Some error during song initialization, add file to skipped list", e);
				}
				
				
			}else if(id3v2Tag != null){
				try {
					return createNewSong(sourceFile, id3v2Tag);
				} catch (Exception e) {
					logger.error("Some error during song initialization, add file to skipped list", e);
				}
				
				
			}else{
				logger.info("Neither id3v1 nor id3v2 tag found for " + sourceFile.getName() + ", add file to skipped list");
			}			
		}
		
		return null;
	}
	
	private Song createNewSong(File file, AbstractID3v2 id3v2Tag) {
		Song newSong = new Song(file);
		newSong.setAudioFileType(StringUtils.substringAfterLast(file.getName(), "."));
		newSong.setName((id3v2Tag.getSongTitle() != null) ? id3v2Tag.getSongTitle() : "");
		newSong.setNumber((id3v2Tag.getTrackNumberOnAlbum() != null) ? id3v2Tag
				.getTrackNumberOnAlbum() : "");
		newSong.setAlbum((id3v2Tag.getAlbumTitle() != null) ? id3v2Tag
				.getAlbumTitle() : "");
		newSong.setArtist((id3v2Tag.getLeadArtist() != null) ? id3v2Tag.getLeadArtist()
				: "");
		newSong.setYear((id3v2Tag.getYearReleased() != null) ? id3v2Tag.getYearReleased() : "");
		return newSong;
	}

	private Song createNewSong(File file, ID3v1 id3v1Tag) {
		Song newSong = new Song(file);
		newSong.setAudioFileType(StringUtils.substringAfterLast(file.getName(), "."));
		newSong.setName((id3v1Tag.getTitle() != null) ? id3v1Tag.getTitle() : "");
		newSong.setNumber((id3v1Tag.getTrackNumberOnAlbum() != null) ? id3v1Tag
				.getTrackNumberOnAlbum() : "");
		newSong.setAlbum((id3v1Tag.getAlbumTitle() != null) ? id3v1Tag
				.getAlbumTitle() : "");
		newSong.setArtist((id3v1Tag.getArtist() != null) ? id3v1Tag.getArtist()
				: "");
		newSong.setYear((id3v1Tag.getYear() != null) ? id3v1Tag.getYear() : "");
		return newSong;
	}

	public File toFile(Song song) {
		// TODO Auto-generated method stub
		return null;
	}

}
