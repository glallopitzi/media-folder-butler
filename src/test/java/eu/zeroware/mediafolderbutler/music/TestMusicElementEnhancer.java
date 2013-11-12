package eu.zeroware.mediafolderbutler.music;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import eu.zeroware.mediafolderbutler.MediaFolderButlerTestBase;
import eu.zeroware.mediafolderbutler.utils.rest.LastfmClient;
import eu.zeroware.mediafolderbutler.utils.rest.MusicBrainzClient;
import eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.MusicBrainzFinder;

public class TestMusicElementEnhancer extends MediaFolderButlerTestBase {
	
	private LastfmClient lastfmClient;
	private MusicBrainzClient musicBrainzClient;
	
	
	@Before
	public void init() {
		if (musicBrainzClient == null)
			musicBrainzClient = injector.getInstance(MusicBrainzClient.class);
		if (lastfmClient == null)
			lastfmClient = injector.getInstance(LastfmClient.class);
	}
	
	
	@Test
	@Ignore
	public void testSingleFileEnhancement(){
		
		// take a file from the file system
		// build the Song element from info from file
		// search for missing info and write them to the file
		
		MusicBrainzFinder finder = musicBrainzClient.getBrainzFinder();
		assertNotNull(finder);
		
	}
	
}
