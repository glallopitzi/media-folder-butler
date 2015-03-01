package eu.zeroware.mediafolderbutler.music;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import eu.zeroware.mediafolderbutler.Enhancer;
import eu.zeroware.mediafolderbutler.utils.rest.LastfmClient;
import eu.zeroware.mediafolderbutler.utils.rest.MusicBrainzClient;


public class MusicLibraryEnhancer extends MusicLibraryWorker implements Enhancer {
	
	private static final Logger logger = Logger.getLogger(MusicLibraryEnhancer.class);
	
	@Autowired
	private MusicBrainzClient musicBrainzClient;
	@Autowired
	private LastfmClient lastfmClient;
	
	private List<File> skippedFiles;
	
	
	public void enhance(){
		logger.info("in enhanceLibrary");
		
		// enforce library with all current available information
		strenghtenLibrary();
		
		// take the skipped files list and try to get information about from external services, in other words: do the magic 
		addSkippedFilesListToLibrary();
		
	}
	
	
	private void strenghtenLibrary(){
		logger.info("strenghtenLibrary");
		
		// TODO merge artist
//		for (Artist artist : library.getArtists()) {
//			StringUtils.getLevenshteinDistance(artist.getName(), arg1, arg2)i
//		}
		
//		for (Artist artist : library.getArtists()) {
//			for (Album album : artist.getAlbums()) {
//				for (Song song : album.getTracks()) {
//					// TODO do the magic
//				}
//			}
//		}
	}
	
	private void addSkippedFilesListToLibrary(){
		logger.info("addSkippedFilesListToLibrary");
		for (File file : skippedFiles) {
			logger.info("Try to get some informaion for: " + file.getName());
			// TODO do the magic
		}
	}
	
	public void print() {
		logger.info(library.toString());
	}

	
	
	
	
	
	
	// getters and setters
	public void setMusicBrainzClient(MusicBrainzClient musicBrainzClient) {
		this.musicBrainzClient = musicBrainzClient;
	}

	public MusicBrainzClient getMusicBrainzClient() {
		return musicBrainzClient;
	}

	public void setLastfmClient(LastfmClient lastfmClient) {
		this.lastfmClient = lastfmClient;
	}

	public LastfmClient getLastfmClient() {
		return lastfmClient;
	}

	public void setSkippedFiles(List<File> skippedFiles) {
		this.skippedFiles = skippedFiles;
	}

	public List<File> getSkippedFiles() {
		return skippedFiles;
	}
}
