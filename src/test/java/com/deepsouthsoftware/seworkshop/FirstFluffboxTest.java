package com.mattstine.seworkshop;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class FirstFluffboxTest {
	private Selenium selenium;
	
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8080/");
		selenium.start();
	}

	@Test
	public void testFirstFluffbox() throws Exception {
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
		selenium.type("username", "joeuser");
		selenium.type("password", "password");
		selenium.click("loginButton");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("This concludes your fake rental experience!"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
