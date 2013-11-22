package eu.zeroware.mediafolderbutler.utils;

import java.io.File;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class MediaFilesReader {
	
	private static Logger logger = LogManager.getLogger(MediaFilesReader.class);
	
	public Collection<File> getAllMediaFilesInFolder(String root, String[] allowedFilesExtension){
		logger.info("getAllMediaFilesInFolder");
		
		logger.info("Try to build library from: " + root);
		File rootFolder = new File(root);
		boolean recursive = true;
		Collection<File> listFiles = FileUtils.listFiles(rootFolder, allowedFilesExtension, recursive);
		logger.info(listFiles.size() + " media files found");
		
		return listFiles;
	}
	
	public File getMediaFileByPath(String filepath){
		logger.info("getMediaFileByPath");
		File file = FileUtils.getFile(filepath);
		logger.info("file found, size: " + file.length());
		return file;
	}
	
}
