package eu.zeroware.mediafolderbutler.common;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import eu.zeroware.mediafolderbutler.MediaFolderButlerTestBase;
import eu.zeroware.mediafolderbutler.entity.Artist;
import eu.zeroware.mediafolderbutler.entity.Creation;

public class TestEntitiesOperations extends MediaFolderButlerTestBase {
	
	private String dummyArtistName = "kurt cobain";
	private String dummyCreationName = "come as you are";
	
	@Test
//	@Ignore
	public void testCreationCreation(){
		Creation creation = new Creation();
		assertNotNull(creation);
		
		Creation creationWithName = new Creation(dummyCreationName);
		assertNotNull(creationWithName);
		assertEquals(dummyCreationName, creationWithName.getName());
	}
	
	@Test
//	@Ignore
	public void testArtistCreation(){
		Artist artist = new Artist();
		assertNotNull(artist);
		
		Artist artistWithName = new Artist(dummyArtistName);
		assertNotNull(artistWithName);
		assertEquals(dummyArtistName, artistWithName.getName());
		
		Creation dummyCreation = new Creation(dummyCreationName);
		Artist artistWithCreation = new Artist(dummyCreation);
		assertNotNull(artistWithCreation);
		assertNotNull(artistWithCreation.getCreations());
	}

}
