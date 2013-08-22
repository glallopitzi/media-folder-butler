package eu.zeroware.mediafolderbutler.music;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import eu.zeroware.mediafolderbutler.music.entity.Album;
import eu.zeroware.mediafolderbutler.music.entity.Artist;
import eu.zeroware.mediafolderbutler.music.entity.Song;


public class LibraryFlusher extends MediaLibraryWorker{
	
	private static Logger logger = LogManager.getLogger(LibraryFlusher.class);
	private final String NEW_ROOT_FOLDER = FOLDER_SEPARATOR + "newroot";
	private List<File> skippedFiles;
	
	
	public void flush(){
		flushLibrary();
		flushSkippedFiles();
	}
	
	
	private void flushLibrary(){
		logger.info("Flush library here..");
		if(makeNewDestinationFolder()){
			for (Artist artist : library.getArtists()) {
				if(makeArtistFolder(artist)){
					for (Album album : library.getAlbums()) {
						if(album.getArtist().getName().equals(artist.getName())){
							if(makeAlbumFolder(artist, album)){
								for (Song song : album.getTracks()) {
									String destFilename = song.getName() + "." + song.getAudioFileType();
									String absoluteDestFilePath = getAlbumFolderName(artist, album) + FOLDER_SEPARATOR + destFilename;
									logger.info("Now copy " + song.getFile().getAbsolutePath() + " to its new position: " + absoluteDestFilePath);
									
									
									if(debug){
										makeFile(absoluteDestFilePath);
										
									}else{
										File srcFile = song.getFile();
										File destFile = new File(absoluteDestFilePath);
										
										try {
											 FileUtils.moveFile(srcFile, destFile);
										} catch (IOException e) {
											logger.error("Error during copy of " + song.getFile().getAbsolutePath() + " on its new position " + absoluteDestFilePath, e);
										}	
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	private void flushSkippedFiles(){
		for (File skippedItem : getSkippedFiles()) {
			logger.info("SkippedItem: " + skippedItem.getAbsolutePath());
		}
	}
	
	
	

	private boolean makeAlbumFolder(Artist artist, Album album){
		return makeFolder(getAlbumFolderName(artist, album));
	}
	
	private String getAlbumFolderName(Artist artist, Album album){
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

	public void setSkippedFiles(List<File> skippedFiles) {
		this.skippedFiles = skippedFiles;
	}

	public List<File> getSkippedFiles() {
		return skippedFiles;
	}


	@Override
	public void print() {
		// TODO Auto-generated method stub
	}
	
}
