		
		package com.deepsouthsoftware.seworkshop;

		import com.thoughtworks.selenium.*;
		import org.junit.After;
		import org.junit.Before;
		import org.junit.Test;
		import java.util.regex.Pattern;

		public class TestFindSpeakerFlow extends SeleneseTestCase {
			@Before
			public void setUp() throws Exception {
				selenium = new DefaultSelenium("localhost", 4444, "*chrome",
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

			@After
			public void tearDown() throws Exception {
				selenium.stop();
			}
		}
