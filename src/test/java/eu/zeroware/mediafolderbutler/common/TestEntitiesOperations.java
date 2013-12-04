package eu.zeroware.mediafolderbutler.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import eu.zeroware.mediafolderbutler.MediaFolderButlerTestBase;
import eu.zeroware.mediafolderbutler.entity.Artist;
import eu.zeroware.mediafolderbutler.entity.Collection;
import eu.zeroware.mediafolderbutler.entity.Creation;

public class TestEntitiesOperations extends MediaFolderButlerTestBase {
	
	
	@Test
//	@Ignore
	public void testCreationCreation(){
		Creation creation = new Creation();
		assertNotNull(creation);
		
		Creation creationWithName = new Creation(helper.DUMMY_CREATION_NAME);
		assertNotNull(creationWithName);
		assertEquals(helper.DUMMY_CREATION_NAME, creationWithName.getName());
	}
	
	@Test
//	@Ignore
	public void testCollectionCreation(){
		Collection collection = new Collection();
		assertNotNull(collection);
		
		Collection collectionWithName = new Collection(helper.DUMMY_COLLECTION_NAME);
		assertNotNull(collectionWithName);
		assertEquals(helper.DUMMY_COLLECTION_NAME, collectionWithName.getName());
		
		Creation dummyCreation = new Creation(helper.DUMMY_CREATION_NAME);
		Collection collectionWithCreation = new Collection(dummyCreation);
		assertNotNull(collectionWithCreation);
		assertNotNull(collectionWithCreation.getCreations());
		
		Collection collectionWithNameAndArtist = new Collection(helper.DUMMY_COLLECTION_NAME, helper.DUMMY_ARTIST_NAME);
		assertNotNull(collectionWithNameAndArtist);
		assertEquals(collectionWithNameAndArtist.getArtist().getName(), helper.DUMMY_ARTIST_NAME);
	}
	
	
	@Test
//	@Ignore
	public void testArtistCreation(){
		Artist artist = new Artist();
		assertNotNull(artist);
		
		Artist artistWithName = new Artist(helper.DUMMY_ARTIST_NAME);
		assertNotNull(artistWithName);
		assertEquals(helper.DUMMY_ARTIST_NAME, artistWithName.getName());
		
		Creation dummyCreation = new Creation(helper.DUMMY_CREATION_NAME);
		Artist artistWithCreation = new Artist(dummyCreation);
		assertNotNull(artistWithCreation);
		assertNotNull(artistWithCreation.getCreations());
	}

}
