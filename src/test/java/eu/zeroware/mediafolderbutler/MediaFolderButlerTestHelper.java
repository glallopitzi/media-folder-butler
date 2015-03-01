package eu.zeroware.mediafolderbutler;

import org.springframework.beans.factory.annotation.Value;

public class MediaFolderButlerTestHelper {
	
	@Value("single.music.element.toenhance") 
	public String SINGLE_MUSIC_ELEMENT_TO_ENHANCE;
	
	@Value("entities.dummy.artist.name") 
	public String DUMMY_ARTIST_NAME;
	
	@Value("entities.dummy.creation.name") 
	public String DUMMY_CREATION_NAME;
	
	@Value("entities.dummy.collection.name") 
	public String DUMMY_COLLECTION_NAME;
	
	public void initializeTestEnvironment(){}
	public void cleanTestEnvironment(){}
	
}
