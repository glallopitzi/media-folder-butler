package eu.zeroware.mediafolderbutler.common;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.google.inject.Inject;

import eu.zeroware.mediafolderbutler.MediaLibraryBuilder;
import eu.zeroware.mediafolderbutler.MediaFolderButlerTestBase;

public class TestLibraryBuilder extends MediaFolderButlerTestBase {
	
	@Inject private MediaLibraryBuilder libraryBuilder;
	
	@Before
	public void init() {
		if (libraryBuilder == null)
			libraryBuilder = injector.getInstance(MediaLibraryBuilder.class);
	}
	
	@Test
	@Ignore
	public void testLibraryBuild(){
		
	}
	
}
