package eu.zeroware.mediafolderbutler;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import eu.zeroware.mediafolderbutler.music.entity.Artist;
import eu.zeroware.mediafolderbutler.music.entity.Song;
import eu.zeroware.mediafolderbutler.utils.rest.LastfmClient;
import eu.zeroware.mediafolderbutler.utils.rest.lastfm.LastfmFinder;

public class TestLastFMClient extends MediaFolderButlerTestBase {

	@Test
	public void testSearchForArtistByName(){
		LastfmClient client = injector.getInstance(LastfmClient.class);
		assertNotNull(client);
		LastfmFinder finder = client.getLastfmFinder();
		assertNotNull(finder);
		List<Artist> searchForArtistByName = finder.searchForArtistByName("Madonna");
		assertNotNull(searchForArtistByName);
	}
	
	@Test
	public void testSearchForSongByName(){
		LastfmClient client = injector.getInstance(LastfmClient.class);
		assertNotNull(client);
		LastfmFinder finder = client.getLastfmFinder();
		assertNotNull(finder);
		List<Song> searchForSongByName = finder.searchForSongByName("come as you are");
		assertNotNull(searchForSongByName);
	}
	
}
