package eu.zeroware.mediafolderbutler.music;

import org.apache.commons.lang3.StringUtils;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import eu.zeroware.mediafolderbutler.LibraryWorker;
import eu.zeroware.mediafolderbutler.music.entity.Library;

public abstract class MediaLibraryWorker extends LibraryWorker{
		
	// config hardcoded
	@Inject @Named("music.audio.files.extentions") protected String AUDIO_EXT_STRING;
	@Inject @Named("music.audio.compilation.extensions") protected String COMPILATION_EXT_STRING;
	@Inject @Named("music.audio.other.extensions") protected String OTHER_EXT_STRING;
	@Inject @Named("musicRootFolder") protected String BASE_MUSIC_FOLDER;
	
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
