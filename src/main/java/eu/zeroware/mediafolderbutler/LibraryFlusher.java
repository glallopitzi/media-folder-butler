package eu.zeroware.mediafolderbutler;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import eu.zeroware.mediafolderbutler.entity.Collection;
import eu.zeroware.mediafolderbutler.entity.Artist;
import eu.zeroware.mediafolderbutler.entity.Creation;


public class LibraryFlusher extends LibraryWorker{
	
	private static Logger logger = LogManager.getLogger(LibraryFlusher.class);
	private final String NEW_ROOT_FOLDER = FOLDER_SEPARATOR + "newroot";
	
	
	@Inject
	public LibraryFlusher(@Named("debug") Boolean debug, @Named("musicRootFolder") String musicRootFolder) {
		super(debug, musicRootFolder);
	}
	
	public void flush(){
		// TODO
	}
	
	public void print() {
		logger.info(library.toString());
	}
	
	
	

	private boolean makeAlbumFolder(Artist artist, Collection album){
		return makeFolder(getAlbumFolderName(artist, album));
	}
	
	private String getAlbumFolderName(Artist artist, Collection album){
		return getArtistFolderName(artist) + FOLDER_SEPARATOR + artist.getName() + " - " + album.getName() + " (" + album.getYear() + ")";
	}
	
	
	
	private boolean makeArtistFolder(Artist artist){
		return makeFolder(getArtistFolderName(artist));
	}
	
	private String getArtistFolderName(Artist artist){
		return getNewDestinationFolderName() + FOLDER_SEPARATOR + artist.getName();
	}
	
	
	
	private boolean makeNewDestinationFolder(){
		return makeFolder(getNewDestinationFolderName());
	}
	
	private String getNewDestinationFolderName(){
		return BASE_MUSIC_FOLDER + NEW_ROOT_FOLDER;
	}
	
	
	
	private boolean makeFile(String fileToCreate){
		File newFolder = new File(fileToCreate);
		try {
			FileUtils.touch(newFolder);
			logger.info("New file created on: " + newFolder.getAbsolutePath());
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	private boolean makeFolder(String folderToCreate){
		File newFolder = new File(folderToCreate);
		try {
			newFolder.mkdir();
			FileUtils.touch(newFolder);
			logger.info("New folder created on: " + newFolder.getAbsolutePath());
		} catch (IOException e) {
			return false;
		}
		return true;
	}

}
