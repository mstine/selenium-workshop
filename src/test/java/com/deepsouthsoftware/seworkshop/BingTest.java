package com.deepsouthsoftware.seworkshop;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BingTest {
	private Selenium selenium;
	
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://www.bing.com/");
		selenium.start();
	}

	@Test
	public void testCheese() throws Exception {
		selenium.open("/");
		selenium.type("sb_form_q", "Cheese");
		selenium.click("sb_form_go");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Cheese - everything you want to know about it."));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
