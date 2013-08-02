package eu.zeroware.mediafolderbutler;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import eu.zeroware.mediafolderbutler.music.entity.Artist;
import eu.zeroware.mediafolderbutler.music.entity.Song;
import eu.zeroware.mediafolderbutler.utils.rest.LastfmClient;
import eu.zeroware.mediafolderbutler.utils.rest.lastfm.LastfmFinder;

public class TestLastFMClient extends MediaFolderButlerTestBase {

	private LastfmClient client;
	
	@Before
	public void init() {
		if (client == null)
			client = injector.getInstance(LastfmClient.class);
		
	}
	
	
	@Test
	public void testSearchForArtistByName(){
		
		LastfmFinder finder = client.getLastfmFinder();
		assertNotNull(finder);
		List<Artist> searchForArtistByName = finder.searchForArtistByName("Madonna");
		assertNotNull(searchForArtistByName);
	}
	
	@Test
	public void testSearchForSongByName(){
		LastfmFinder finder = client.getLastfmFinder();
		assertNotNull(finder);
		List<Song> searchForSongByName = finder.searchForSongByName("come as you are");
		assertNotNull(searchForSongByName);
	}
	
}
