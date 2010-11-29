package com.deepsouthsoftware.seworkshop.testng;

import com.thoughtworks.selenium.*;
import org.testng.annotations.*;


import java.util.HashMap;

public class TestWithIterationNG extends SeleneseTestBase {
	private HashMap<String, String> speakers = new HashMap<String, String>(); 

	@BeforeClass
	public void setUp() throws Exception {
		speakers.put("Aaron Bedra", "Principal at Relevance, Member Clojure/core");
		speakers.put("Aleksandar Seovic", "Software Developer and Author");
		speakers.put("Alex Miller", "Sr. Engineer with Terracotta Inc.");
		speakers.put("Andrew Glover", "Founder of easyb");

		selenium = new DefaultSelenium("localhost", 4444,
		 															 	"*firefox", "http://localhost:8080/");
		selenium.start();
	}

	@Test
	public void testWithIteration() throws Exception {
		selenium.open("/fluffbox-rwx/");

		for (String name : speakers.keySet()) {
			selenium.click("//a[contains(@href, '/fluffbox-rwx/speaker/find')]");
			selenium.waitForPageToLoad("30000");
			selenium.click("link="+name);
			selenium.waitForPageToLoad("30000");
			verifyTrue(selenium.isTextPresent(speakers.get(name)));
		}
	}

	@AfterClass
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
