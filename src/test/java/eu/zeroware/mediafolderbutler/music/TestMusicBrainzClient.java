package eu.zeroware.mediafolderbutler.music;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import eu.zeroware.mediafolderbutler.MediaFolderButlerTestBase;
import eu.zeroware.mediafolderbutler.music.entity.Album;
import eu.zeroware.mediafolderbutler.music.entity.Artist;
import eu.zeroware.mediafolderbutler.music.entity.Song;
import eu.zeroware.mediafolderbutler.utils.rest.MusicBrainzClient;
import eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.MusicBrainzFinder;

public class TestMusicBrainzClient extends MediaFolderButlerTestBase{
	
	private MusicBrainzClient client;
	
	private String artistNameToTest = "Caparezza";
	private String albumTitleToTest = "an awesome wave";
	
	@Before
	public void init() {
		if (client == null)
			client = injector.getInstance(MusicBrainzClient.class);
	}
	
	
	@Test
	@Ignore
	public void testSearchForArtistByName(){
		
		MusicBrainzFinder finder = client.getBrainzFinder();
		assertNotNull(finder);
		
		Artist searchForArtistByName = finder.searchForArtistByName(artistNameToTest);
		assertNotNull(searchForArtistByName);
		assertEquals(artistNameToTest.toLowerCase(), searchForArtistByName.getName().toLowerCase());
		assertNotNull(searchForArtistByName.getAlbums());
		
		System.out.println(searchForArtistByName);
		for (Album album : searchForArtistByName.getAlbums()) {
			System.out.println(album);
		}
	}
	
	@Test
//	@Ignore
	public void testGetAlbumDetailByTitle(){
		
		MusicBrainzFinder finder = client.getBrainzFinder();
		assertNotNull(finder);
		
		Album album = finder.searchForAlbumByName(albumTitleToTest);
		assertNotNull(album);
		
		for (Song song : album.getTracks()) {
			System.out.println("song: " + song.getName());
		}
		
	}
	
}
