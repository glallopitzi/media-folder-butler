package eu.zeroware.mediafolderbutler.music;

import static org.junit.Assert.assertNotNull;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import eu.zeroware.mediafolderbutler.MediaFolderButlerTestBase;
import eu.zeroware.mediafolderbutler.utils.rest.LastfmClient;
import eu.zeroware.mediafolderbutler.utils.rest.MusicBrainzClient;
import eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.MusicBrainzFinder;

public class TestMusicElementEnhancer extends MediaFolderButlerTestBase {
	
	private LastfmClient lastfmClient;
	private MusicBrainzClient musicBrainzClient;
	
	
	@Inject @Named("single.music.element.toenhance") private String SINGLE_MUSIC_ELEMENT_TO_ENHANCE;
	
	@Before
	public void init() {
		if (musicBrainzClient == null)
			musicBrainzClient = injector.getInstance(MusicBrainzClient.class);
		if (lastfmClient == null)
			lastfmClient = injector.getInstance(LastfmClient.class);
	}
	
	
	@Test
//	@Ignore
	public void testSingleFileEnhancement(){
		
		// take a file from the file system
		// build the Song element from info from file
		// search for missing info and write them to the file
		
		MusicBrainzFinder finder = musicBrainzClient.getBrainzFinder();
		assertNotNull(finder);
		
//		File file = FileUtils.getFile(SINGLE_MUSIC_ELEMENT_TO_ENHANCE);
		File file = FileUtils.getFile("~/Documents/Work/tmp/newtesttmp/05 slow hands.mp3");
		assertNotNull(file);
		
	}
	
}
