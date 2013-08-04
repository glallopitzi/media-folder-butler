package eu.zeroware.mediafolderbutler;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import eu.zeroware.mediafolderbutler.music.entity.Album;
import eu.zeroware.mediafolderbutler.utils.rest.MusicBrainzClient;
import eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.MusicBrainzFinder;

public class TestMusicBrainzClient extends MediaFolderButlerTestBase{
	
	private MusicBrainzClient client;
	
	@Before
	public void init() {
		if (client == null)
			client = injector.getInstance(MusicBrainzClient.class);
	}
	
	@Test
	public void testGenericSearch(){
	
		MusicBrainzFinder finder = client.getBrainzFinder();
		assertNotNull(finder);
		
		Album searchForAlbumByName = finder.searchForAlbumByName("The fragile");
		assertNotNull(searchForAlbumByName);
		
	}
	
}
