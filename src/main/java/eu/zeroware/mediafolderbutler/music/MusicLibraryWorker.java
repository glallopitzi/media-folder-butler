package eu.zeroware.mediafolderbutler.music;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import eu.zeroware.mediafolderbutler.LibraryWorker;
import eu.zeroware.mediafolderbutler.music.entity.Library;

public abstract class MusicLibraryWorker extends LibraryWorker{
		
	// config hardcoded
	@Value("music.audio.files.extentions") 
	protected String AUDIO_EXT_STRING;
	@Value("music.audio.compilation.extensions") 
	protected String COMPILATION_EXT_STRING;
	@Value("music.audio.other.extensions") 
	protected String OTHER_EXT_STRING;
	@Value("musicRootFolder") 
	protected String BASE_MUSIC_FOLDER;
	
	protected Library library;	
	
	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}
	
	public String[] getAudioExtenstionStringArray(){
		return StringUtils.split(AUDIO_EXT_STRING, ",");
	}
	
	
}
