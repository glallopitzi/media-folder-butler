package eu.zeroware.mediafolderbutler.common;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.google.inject.Inject;

import eu.zeroware.mediafolderbutler.LibraryBuilder;
import eu.zeroware.mediafolderbutler.MediaFolderButlerTestBase;

public class TestLibraryBuilder extends MediaFolderButlerTestBase {
	
	@Inject private LibraryBuilder libraryBuilder;
	
	@Before
	public void init() {
		if (libraryBuilder == null)
			libraryBuilder = injector.getInstance(LibraryBuilder.class);
	}
	
	@Test
	@Ignore
	public void testLibraryBuild(){
		
	}
	
}
