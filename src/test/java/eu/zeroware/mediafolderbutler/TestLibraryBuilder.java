package eu.zeroware.mediafolderbutler;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.google.inject.Inject;

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
