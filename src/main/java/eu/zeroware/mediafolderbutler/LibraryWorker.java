package eu.zeroware.mediafolderbutler;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public abstract class LibraryWorker {
	
	@Inject @Named("builder.book") protected boolean builderBook;
	@Inject @Named("builder.movie") protected boolean builderMovie;
	@Inject @Named("builder.music") protected boolean builderMusic;
	
	@Inject @Named("debug") protected Boolean debug;
	@Inject @Named("musicRootFolder") protected String BASE_MUSIC_FOLDER;
	
	protected final String FOLDER_SEPARATOR = System.getProperty("file.separator");
		
	public abstract void print();
	
	public void outlnSeparetor(){
		outln("\n\n============================");
	}
	
	public void outln(String msg){
		System.out.println(msg);
	}
	
}
