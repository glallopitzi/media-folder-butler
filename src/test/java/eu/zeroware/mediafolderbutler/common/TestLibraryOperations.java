package eu.zeroware.mediafolderbutler.common;

import static org.junit.Assert.*;

import org.junit.Test;

import eu.zeroware.mediafolderbutler.MediaFolderButlerTestBase;
import eu.zeroware.mediafolderbutler.entity.Creation;
import eu.zeroware.mediafolderbutler.entity.Library;

public class TestLibraryOperations extends MediaFolderButlerTestBase {
	
	@Test
//	@Ignore
	public void testEmptyLibraryCreation(){
		Library library = new Library();
		assertNotNull(library);
		assertNotNull(library.getArtists());
		assertNotNull(library.getCollections());
		assertNotNull(library.getCreations());
		assertNotNull(library.getGenres());
		assertNotNull(library.getDuplicatedMediaElements());
		assertNotNull(library.getUnknownMediaElements());
	}
	
	@Test
//	@Ignore
	public void testAddMediaElementToLibrary(){
		Library library = new Library();
		assertNotNull(library);
		
		Creation creation = new Creation(helper.DUMMY_CREATION_NAME);
		library.addMediaElementsToLibrary(creation);
		assertEquals(library.getCreations().size(), 1);
		assertEquals(library.getCollections().size(), 1);
		assertEquals(library.getArtists().size(), 1);
		
		library.addMediaElementsToLibrary(creation);
		assertEquals(library.getCreations().size(), 1);
		assertEquals(library.getCollections().size(), 1);
		assertEquals(library.getArtists().size(), 1);
		assertEquals(library.getDuplicatedMediaElements().size(), 1);
	}
	
	
}
