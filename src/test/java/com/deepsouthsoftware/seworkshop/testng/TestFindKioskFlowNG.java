

package com.deepsouthsoftware.seworkshop.testng;

import com.thoughtworks.selenium.*;
import org.testng.annotations.*;

public class TestFindKioskFlowNG extends SeleneseTestBase {			
	@BeforeClass
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*firefox", "http://localhost:8080/");
		selenium.start();
	}

	@Test
	public void testFindKioskFlow() throws Exception {
		selenium.open("/fluffbox-rwx/");
		selenium.click("//a[contains(@href, '/fluffbox-rwx/kiosk/find')]");
		selenium.waitForPageToLoad("30000");
		selenium.type("searchCriteria", "Ft. Lauderdale");
		selenium.click("searchButton");
		
		for (int second = 0;; second++) {
			if (second >= 60) 
				fail("timeout");
			try { 
				if (selenium.isElementPresent("link=Find Speakers Here"))
				 break; 
				} catch (Exception e) {}
			Thread.sleep(1000);
		}
		selenium.click("link=Find Speakers Here");
		
		
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Aleksandar Seovic");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=RENT NOW!");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Continue");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isTextPresent("This concludes your fake rental experience!"));
	}

	@AfterClass
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
