package eu.zeroware.mediafolderbutler.common;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import eu.zeroware.mediafolderbutler.MediaFolderButlerTestBase;
import eu.zeroware.mediafolderbutler.MediaLibraryBuilder;

public class TestLibraryBuilder extends MediaFolderButlerTestBase {
	
	@Autowired
	private MediaLibraryBuilder libraryBuilder;
	
	@Test
//	@Ignore
	public void testLibraryBuild(){
		System.out.println("here");
	}
	
}
