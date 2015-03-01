package eu.zeroware.mediafolderbutler;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MediaFolderButlerContext.class)
public class MediaFolderButlerTestBase {
	
	@Autowired
	protected MediaFolderButlerTestHelper helper;
	
	@Before
	public void testInit(){
		System.out.println("testInit");
	}
	
}
