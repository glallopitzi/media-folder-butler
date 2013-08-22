package eu.zeroware.mediafolderbutler.music;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import eu.zeroware.mediafolderbutler.music.entity.Library;
import eu.zeroware.mediafolderbutler.music.entity.Song;
import eu.zeroware.mediafolderbutler.music.id3tag.SongBuilder;

public class LibraryBuilder extends MediaLibraryWorker{
	
	private static Logger logger = LogManager.getLogger(LibraryBuilder.class);
	
	@Inject private SongBuilder songBuilder;
	
	private List<Song> foundTracks;
	private List<File> skippedFiles;
	
	public void build(){
		buildTracksArray();
		buildLibraryFromTracksArray();
	}
	
	public void buildTracksArray()	 {
		File root = new File(BASE_MUSIC_FOLDER);
		logger.info("Try to build library from: " + BASE_MUSIC_FOLDER);
		
		boolean recursive = true;
		Collection<File> listFiles = FileUtils.listFiles(root, getAudioExtenstionStringArray(), recursive);
		logger.info(listFiles.size() + " audio files found");

		foundTracks = new ArrayList<Song>();
		skippedFiles = new ArrayList<File>();
		
		for (File sourceFile : listFiles) {
			Song songToAdd = songBuilder.fromFile(sourceFile);
			if(songToAdd != null){
				foundTracks.add(songToAdd);
				
				
			}else{
				skippedFiles.add(sourceFile);
			}
		}
		
		logger.info(foundTracks.size() + " tracks created");
		logger.info(skippedFiles.size() + " files skipped");
		logger.info("Accuracy (tracks found / files found): "
				+ ((float) foundTracks.size() * 100.0 / (float) listFiles.size()) + " %"
				+ "\n");
	}

	
	public void buildLibraryFromTracksArray() {
		if (foundTracks != null && foundTracks.size() > 0) {
			library = new Library();
			for (Song song : foundTracks) {
				library.addTrackToLibrary(song);
			}
		}
	}

	
	
	
	
	public void print() {

		logger.info(library.toString());

		if(skippedFiles != null && skippedFiles.size() > 0){
			logger.info("Skipped files list:");
			for (File file : skippedFiles) {
				logger.info(file.getName());
			}			
		}else{
			logger.info("Skipped files list is empty");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	// getters and setters
	public List<Song> getFoundTracks() {
		return foundTracks;
	}

	public void setFoundTracks(List<Song> foundTracks) {
		this.foundTracks = foundTracks;
	}

	public List<File> getSkippedFiles() {
		return skippedFiles;
	}

	public void setSkippedFiles(List<File> skippedFiles) {
		this.skippedFiles = skippedFiles;
	}

}
