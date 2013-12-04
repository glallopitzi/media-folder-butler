package eu.zeroware.mediafolderbutler.common;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import eu.zeroware.mediafolderbutler.MediaFolderButlerTestBase;
import eu.zeroware.mediafolderbutler.entity.Artist;
import eu.zeroware.mediafolderbutler.entity.Collection;
import eu.zeroware.mediafolderbutler.entity.Creation;

public class TestEntitiesOperations extends MediaFolderButlerTestBase {
	
	private String dummyArtistName = "kurt cobain";
	private String dummyCreationName = "come as you are";
	private String dummyCollectionName = "nevermind";
	
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
	public void testCollectionCreation(){
		Collection collection = new Collection();
		assertNotNull(collection);
		
		Collection collectionWithName = new Collection(dummyCollectionName);
		assertNotNull(collectionWithName);
		assertEquals(dummyCollectionName, collectionWithName.getName());
		
		Creation dummyCreation = new Creation(dummyCreationName);
		Collection collectionWithCreation = new Collection(dummyCreation);
		assertNotNull(collectionWithCreation);
		assertNotNull(collectionWithCreation.getCreations());
		
		Collection collectionWithNameAndArtist = new Collection(dummyCollectionName, dummyArtistName);
		assertNotNull(collectionWithNameAndArtist);
		assertEquals(collectionWithNameAndArtist.getArtist().getName(), dummyArtistName);
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
