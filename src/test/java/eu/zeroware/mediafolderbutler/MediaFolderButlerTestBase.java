package eu.zeroware.mediafolderbutler;

import org.junit.Before;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class MediaFolderButlerTestBase {
	
	protected Injector injector;
	protected MediaFolderButlerTestHelper helper;
	
	@Before
	public void testInit(){
		if(injector == null)
			injector = Guice.createInjector(new MediaFolderButlerTestModule());
		
		if(helper == null)
			helper = injector.getInstance(MediaFolderButlerTestHelper.class);
	}
	
}
