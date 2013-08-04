package eu.zeroware.mediafolderbutler;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import eu.zeroware.mediafolderbutler.entity.Library;

public abstract class LibraryWorker {
	
	@Inject @Named("builder.book") protected boolean builderBook;
	@Inject @Named("builder.movie") protected boolean builderMovie;
	@Inject @Named("builder.music") protected boolean builderMusic;
	
	@Inject @Named("debug") protected Boolean debug;
	@Inject @Named("musicRootFolder") protected String BASE_MUSIC_FOLDER;
	
	protected final String FOLDER_SEPARATOR = System.getProperty("file.separator");
	
	// config hardcoded
	protected final String[] AUDIO_EXT 			= { "mp3", "m4a" };
	protected final String[] COMPILATION_EXT 	= { "m3u", "nfo" };
	protected final String[] OTHER_EXT 			= { "jpg", "jpeg", "db", "url", "txt", "pdf"};
	
	protected Library library;
	
	
	public abstract void print();
	
	public void outlnSeparetor(){
		outln("\n\n============================");
	}
	
	public void outln(String msg){
		System.out.println(msg);
	}
	
	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}
	
	
}
