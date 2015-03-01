package eu.zeroware.mediafolderbutler.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import eu.zeroware.mediafolderbutler.entity.Creation;
import eu.zeroware.mediafolderbutler.music.entity.Song;

public class MediaFilesWriter {

	@Value("debug:true")
	protected Boolean debug;

	private static Logger logger = LogManager.getLogger(MediaFilesWriter.class);
	private final String FOLDER_SEPARATOR = System.getProperty("file.separator");

	public void writeSongToFolder(Song song, String folder) {

		String destFilename = song.getName() + "." + song.getAudioFileType();
		String absoluteDestFilePath = folder + FOLDER_SEPARATOR + destFilename;

		logger.info("Now copy " + song.getFile().getAbsolutePath() + " to its new position: " + absoluteDestFilePath);

		if (debug) {
			makeFile(absoluteDestFilePath);

		} else {
			File srcFile = song.getFile();
			File destFile = new File(absoluteDestFilePath);

			try {
				FileUtils.moveFile(srcFile, destFile);
			} catch (IOException e) {
				logger.error("Error during copy of " + song.getFile().getAbsolutePath() + " on its new position "
						+ absoluteDestFilePath, e);
			}
		}
	}

	public void writeMediaFileToFolder(File file, String folder) {
	}

	public void writeMediaElementToFolder(Creation mediaElement, String folder) {
	}

	public void flushSongElementToRootFolder(Song song, String rooFolder) {
		String artist = song.getArtist();
		String album = song.getAlbum();

	}

	public boolean makeFolder(String folderToCreate) {
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

	public boolean makeFile(String fileToCreate) {
		File newFolder = new File(fileToCreate);
		try {
			FileUtils.touch(newFolder);
			logger.info("New file created on: " + newFolder.getAbsolutePath());
		} catch (IOException e) {
			return false;
		}
		return true;
	}
}
