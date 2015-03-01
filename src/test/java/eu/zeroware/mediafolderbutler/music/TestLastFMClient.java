package eu.zeroware.mediafolderbutler.music;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import eu.zeroware.mediafolderbutler.MediaFolderButlerTestBase;
import eu.zeroware.mediafolderbutler.music.entity.Artist;
import eu.zeroware.mediafolderbutler.music.entity.Song;
import eu.zeroware.mediafolderbutler.utils.rest.LastfmClient;
import eu.zeroware.mediafolderbutler.utils.rest.lastfm.LastfmFinder;

public class TestLastFMClient extends MediaFolderButlerTestBase {

	private static final String TEST_SONG_NAME = "come as you are";
	private static final String TEST_ARTIST_NAME = "Madonna";
	
	@Autowired
	private LastfmClient client;
	
	@Test
	public void testSearchForArtistByName(){
		final LastfmFinder finder = client.getLastfmFinder();
		assertNotNull(finder);
		
		final List<Artist> searchForArtistByName = finder.searchForArtistByName(TEST_ARTIST_NAME);
		assertNotNull(searchForArtistByName);
		assertTrue(searchForArtistByName.size() > 0);
	}
	
	@Test
	@Ignore
	public void testSearchForSongByName(){
		final LastfmFinder finder = client.getLastfmFinder();
		assertNotNull(finder);

		final List<Song> searchForSongByName = finder.searchForSongByName(TEST_SONG_NAME);
		assertNotNull(searchForSongByName);
		assertTrue(searchForSongByName.size() > 0);
	}
	
}
