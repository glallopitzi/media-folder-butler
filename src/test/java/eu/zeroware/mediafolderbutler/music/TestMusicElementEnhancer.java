package eu.zeroware.mediafolderbutler.music;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import eu.zeroware.mediafolderbutler.MediaFolderButlerTestBase;
import eu.zeroware.mediafolderbutler.music.entity.Song;
import eu.zeroware.mediafolderbutler.music.id3tag.SongBuilder;
import eu.zeroware.mediafolderbutler.utils.MediaFilesReader;
import eu.zeroware.mediafolderbutler.utils.rest.LastfmClient;
import eu.zeroware.mediafolderbutler.utils.rest.MusicBrainzClient;
import eu.zeroware.mediafolderbutler.utils.rest.musicbrainz.MusicBrainzFinder;

public class TestMusicElementEnhancer extends MediaFolderButlerTestBase {
	
	@Autowired
	private LastfmClient lastfmClient;
	@Autowired
	private MusicBrainzClient musicBrainzClient;
	@Autowired
	private SongBuilder songBuilder;
	
//	@Inject @Named("single.music.element.toenhance") private String SINGLE_MUSIC_ELEMENT_TO_ENHANCE;
	
	
	
	@Test
	@Ignore
	public void testSingleFileEnhancement(){
		
		// take a file from the file system
		
		MusicBrainzFinder finder = musicBrainzClient.getBrainzFinder();
		assertNotNull(finder);
		
//		MediaFilesReader mediaFilesReader = injector.getInstance(MediaFilesReader.class);
//		assertNotNull(mediaFilesReader);
//		
//		File file = mediaFilesReader.getMediaFileByPath(helper.SINGLE_MUSIC_ELEMENT_TO_ENHANCE);
//		assertTrue(file.length() > 0);
//
//		// build the Song element from info from file
//
//		Song song = songBuilder.fromFile(file);
//		assertNotNull(song);
//		
//		System.out.println(song);

		// search for missing info and write them to the file

		
	}
	
}
