
		package com.deepsouthsoftware.seworkshop.testng;

		import com.thoughtworks.selenium.*;
		import org.testng.annotations.*;

		public class TestFindSpeakerFlowNG extends SeleneseTestBase {			
			@BeforeClass
			public void setUp() throws Exception {
				selenium = new DefaultSelenium("localhost", 4444, "*firefox",
				 															 "http://localhost:8080/");
				selenium.start();
			}

			@Test
			public void testFindSpeakerFlow() throws Exception {
				selenium.open("/fluffbox-rwx/");
				selenium.click("//a[contains(@href, '/fluffbox-rwx/speaker/find')]");
				selenium.waitForPageToLoad("30000");
				selenium.click("link=Alex Miller");
				selenium.waitForPageToLoad("30000");
				selenium.click("link=Find this Speaker");
				
				
				selenium.waitForPageToLoad("30000");
				selenium.click("link=RENT NOW");
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
