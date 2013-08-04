package eu.zeroware.mediafolderbutler.music;

import eu.zeroware.mediafolderbutler.music.entity.Library;

public abstract class LibraryWorker {
	
	// config from properties
	protected final Boolean debug;
	protected final String BASE_MUSIC_FOLDER;
	protected final String FOLDER_SEPARATOR;
	
	// config hardcoded
	protected final String[] AUDIO_EXT 			= { "mp3", "m4a" };
	protected final String[] COMPILATION_EXT 	= { "m3u", "nfo" };
	protected final String[] OTHER_EXT 			= { "jpg", "jpeg", "db", "url", "txt", "pdf"};
	
	protected Library library;
	
	public LibraryWorker(Boolean debug, String musicRootFolder){
		this.debug = debug;
		this.BASE_MUSIC_FOLDER = musicRootFolder;
		this.FOLDER_SEPARATOR = System.getProperty("file.separator");
	}
	
	
	public void outlnSeparetor(){
		outln("\n\n============================");
	}
	
	public void outln(String msg){
		MusicFolderUtil.outln(msg);
	}
	
	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}
	
	
}
