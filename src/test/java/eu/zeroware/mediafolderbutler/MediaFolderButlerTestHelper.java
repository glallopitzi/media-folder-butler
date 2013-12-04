package eu.zeroware.mediafolderbutler;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class MediaFolderButlerTestHelper {
	
	@Inject @Named("single.music.element.toenhance") public String SINGLE_MUSIC_ELEMENT_TO_ENHANCE;
	
	@Inject @Named("entities.dummy.artist.name") public String DUMMY_ARTIST_NAME;
	@Inject @Named("entities.dummy.creation.name") public String DUMMY_CREATION_NAME;
	@Inject @Named("entities.dummy.collection.name") public String DUMMY_COLLECTION_NAME;
	
	public void initializeTestEnvironment(){}
	public void cleanTestEnvironment(){}
	
}
