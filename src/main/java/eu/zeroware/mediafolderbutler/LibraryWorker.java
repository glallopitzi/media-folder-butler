package eu.zeroware.mediafolderbutler;

import org.springframework.beans.factory.annotation.Value;

public abstract class LibraryWorker {
	
	@Value("builder.book:false") 
	protected boolean builderBook;
	@Value("builder.movie:false") 
	protected boolean builderMovie;
	@Value("builder.music:false") 
	protected boolean builderMusic;
	
	@Value("debug:true") 
	protected Boolean debug;
	
	protected final String FOLDER_SEPARATOR = System.getProperty("file.separator");
		
	public void outlnSeparetor(){
		outln("\n\n============================");
	}
	
	public void outln(String msg){
		System.out.println(msg);
	}
	
	public void print() {
		// TODO Auto-generated method stub
	}
	
}
