package com.deepsouthsoftware.seworkshop;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.matchers.JUnitMatchers.*;
import static org.junit.Assert.*;

public class TestGmapPopup {	
	private WebDriver driver;
			
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.get("http://localhost:8080/fluffbox-rwx");
	}

	@Test
	public void testFindKioskFlow() throws Exception {
		driver.findElement(By.xpath("//a[contains(@href, '/fluffbox-rwx/kiosk/find')]"))
					.click();
		driver.findElement(By.id("searchCriteria"))
					.sendKeys("Ft. Lauderdale");
		driver.findElement(By.id("searchButton")).click();
		
		WebElement walgreensInsideLink = null;
		
		for (int second = 0;; second++) {
			if (second >= 60) 
				fail("timeout");
			try { 
				 walgreensInsideLink = driver.findElement(By.linkText("Walgreens (Inside)"));
				 break; 
			} catch (Exception e) {}
			Thread.sleep(1000);
		}
		
		walgreensInsideLink.click();
	
		WebElement gMapInfoWindow = null;
		
		for (int second = 0;; second++) {
			if (second >= 60) 
				fail("timeout");
			try { 
				 gMapInfoWindow = driver.findElement(By.cssSelector("div.gmnoprint > div.gmnoprint > div > div"));
				 break; 
			} catch (Exception e) {}
			Thread.sleep(1000);
		}
		
		assertThat(gMapInfoWindow.getText(), containsString("3895 W Broward Blvd"));
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
