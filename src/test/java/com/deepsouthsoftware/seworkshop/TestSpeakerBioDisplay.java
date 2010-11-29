package com.deepsouthsoftware.seworkshop;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestSpeakerBioDisplay extends SeleneseTestBase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8080/");
		selenium.start();
	}

	@Test
	public void testSpeakerBioDisplay() throws Exception {
		selenium.open("/fluffbox-rwx/speaker/find");
		verifyFalse(selenium.isVisible("speakerInfo-3"));
		selenium.mouseOver("speakerImage-3");
		Thread.sleep(2000);
		verifyTrue(selenium.isVisible("speakerInfo-3"));
		selenium.mouseOut("speakerImage-3");
		Thread.sleep(2000);
		verifyFalse(selenium.isVisible("speakerInfo-3"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
