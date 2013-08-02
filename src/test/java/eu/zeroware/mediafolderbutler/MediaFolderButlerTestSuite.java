package eu.zeroware.mediafolderbutler;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ 
	
})
public class MediaFolderButlerTestSuite {

	private static Logger logger = LogManager.getLogger(MediaFolderButlerTestSuite.class);
	
	
	@BeforeClass 
    public static void setUpClass() {      
        System.out.println("setup");
//        Injector injector = Guice.createInjector(new ExperimentManagerTestModule());
//        ExperimentManagerTestHelper helper = injector.getInstance(ExperimentManagerTestHelper.class);
//        helper.createConfiguration();
    }

    @AfterClass public static void tearDownClass() { 
        System.out.println("tearDown");
//        Injector injector = Guice.createInjector(new ExperimentManagerTestModule());
//        ExperimentManagerTestHelper helper = injector.getInstance(ExperimentManagerTestHelper.class);
//        helper.deleteConfiguration();
    }
	
}
