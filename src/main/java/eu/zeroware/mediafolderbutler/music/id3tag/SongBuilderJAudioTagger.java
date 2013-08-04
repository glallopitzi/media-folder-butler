package eu.zeroware.mediafolderbutler.music.id3tag;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.TagField;
import org.jaudiotagger.tag.vorbiscomment.VorbisCommentFieldKey;
import org.jaudiotagger.tag.vorbiscomment.VorbisCommentTag;

import eu.zeroware.mediafolderbutler.music.entity.Song;

public class SongBuilderJAudioTagger implements SongBuilder {

	private static Logger logger = LogManager.getLogger(SongBuilderJAudioTagger.class);
	
	public Song fromFile(File sourceFile) {
		String fileExt = StringUtils.substringAfterLast(sourceFile.getName(), ".");
		
		if("mp3".equals(fileExt)){
			return createSongFromMP3(sourceFile);
			
			
		}else if("m4a".equals(fileExt)){
			return createSongFromM4A(sourceFile);
			
			
		}else if("ogg".equals(fileExt)){
			return createSongFromOGG(sourceFile);
			
			
		}else{
			logger.debug("No audio file found on: " + sourceFile.getAbsolutePath());
			return null;
		}
	}

	private Song createSongFromOGG(File sourceFile) {
		logger.debug("ogg audio file found on: " + sourceFile.getAbsolutePath());
		AudioFile f = null;
		try {
			f = AudioFileIO.read(sourceFile);
		} catch (CannotReadException e) {
			logger.error("CannotReadException", e);
		} catch (IOException e) {
			logger.error("IOException", e);
		} catch (TagException e) {
			logger.error("TagException", e);
		} catch (ReadOnlyFileException e) {
			logger.error("ReadOnlyException", e);
		} catch (InvalidAudioFrameException e) {
			logger.error("InvalidAudioFrameException", e);
		}
		
		if (f != null){
			VorbisCommentTag ovtag = (VorbisCommentTag) f.getTag();
			List<TagField> list = ovtag.get(VorbisCommentFieldKey.PRODUCTNUMBER);
			for(TagField field : list)
			{
				System.out.println(field);
			}				
			
		}
		return null;
	}

	private Song createSongFromM4A(File sourceFile) {
		logger.debug("m4a audio file found on: " + sourceFile.getAbsolutePath());
		AudioFile f = null;
		
		try {
			f = AudioFileIO.read(sourceFile);
		} catch (CannotReadException e) {
			logger.error("CannotReadException", e);
		} catch (IOException e) {
			logger.error("IOException", e);
		} catch (TagException e) {
			logger.error("TagException", e);
		} catch (ReadOnlyFileException e) {
			logger.error("ReadOnlyException", e);
		} catch (InvalidAudioFrameException e) {
			logger.error("InvalidAudioFrameException", e);
		}
		
		if(f != null){
			Song newSong = new Song(sourceFile);
			Tag tag = f.getTag();
			
			newSong.setName(tag.getFirst(FieldKey.TITLE));
			newSong.setArtist(tag.getFirst(FieldKey.ARTIST));
			newSong.setAlbum(tag.getFirst(FieldKey.ALBUM));
			newSong.setYear(tag.getFirst(FieldKey.YEAR));
			newSong.setNumber(tag.getFirst(FieldKey.TRACK));
			newSong.setMbid(tag.getFirst(FieldKey.MUSICBRAINZ_TRACK_ID));
			
			return newSong;
			
		}
		return null;
	}

	private Song createSongFromMP3(File sourceFile) {
		logger.debug("mp3 audio file found on: " + sourceFile.getAbsolutePath());
		AudioFile f = null;
		
		try {
			f = AudioFileIO.read(sourceFile);
		} catch (CannotReadException e) {
			logger.error("CannotReadException", e);
		} catch (IOException e) {
			logger.error("IOException", e);
		} catch (TagException e) {
			logger.error("TagException", e);
		} catch (ReadOnlyFileException e) {
			logger.error("ReadOnlyException", e);
		} catch (InvalidAudioFrameException e) {
			logger.error("InvalidAudioFrameException", e);
		}
		
		if(f != null){
			Song newSong = new Song(sourceFile);
			
			Tag tag = f.getTag();
			newSong.setName(tag.getFirst(FieldKey.TITLE));
			newSong.setArtist(tag.getFirst(FieldKey.ARTIST));
			newSong.setAlbum(tag.getFirst(FieldKey.ALBUM));
			newSong.setYear(tag.getFirst(FieldKey.YEAR));
			newSong.setNumber(tag.getFirst(FieldKey.TRACK));
			newSong.setMbid(tag.getFirst(FieldKey.MUSICBRAINZ_TRACK_ID));
			
			return newSong;
		}
		return null;
	}

	public File toFile(Song song) {
		// TODO Auto-generated method stub
		return null;
	}
}
