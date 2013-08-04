package eu.zeroware.mediafolderbutler;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

import eu.zeroware.mediafolderbutler.music.id3tag.SongBuilder;
import eu.zeroware.mediafolderbutler.music.id3tag.SongBuilderJAudioTagger;

public class MediaFolderButlerModule extends AbstractModule{

	private static Logger logger = LogManager.getLogger(MediaFolderButlerModule.class);
	
	@Override
	protected void configure() {
		
		try {
			Properties properties = new Properties();
			String osName = System.getProperty("os.name");
			properties.load(new FileReader("src/main/java/app.properties"));
			
			if (osName.contains("Windows")){
				properties.load(new FileReader("src/main/java/app.win.properties"));
			
			} else if (osName.contains("Mac")) {
				properties.load(new FileReader("src/main/java/app.osx.properties"));
			
			} else {
				throw new RuntimeException("OS not recognized");
			}
			
			Names.bindProperties(binder(), properties);
			
		} catch (FileNotFoundException e) {
			logger.error("Properties file not found", e);
		} catch (IOException e) {
			logger.error("Some error during file reading", e);
		}
		
		bind(SongBuilder.class).to(SongBuilderJAudioTagger.class);
	}

}