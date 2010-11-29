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
		
		WebElement walgreensInsideLink = waitForDynamicElement(By.linkText("Walgreens (Inside)"));
		walgreensInsideLink.click();
	
		WebElement gMapInfoWindow = waitForDynamicElement(By.cssSelector("div.gmnoprint > div.gmnoprint > div > div"));
		assertThat(gMapInfoWindow.getText(), containsString("3895 W Broward Blvd"));
		
		WebElement winnDixieOutsideLink = waitForDynamicElement(By.linkText("Winn Dixie (Outside)"));
		winnDixieOutsideLink.click();
		
		gMapInfoWindow = waitForDynamicElement(By.cssSelector("div.gmnoprint > div.gmnoprint > div > div"));
		assertThat(gMapInfoWindow.getText(), containsString("1531 N State Road 7"));
	}
	
	private WebElement waitForDynamicElement(By locator) throws Exception {
		WebElement dynamicElement = null;
		
		for (int second = 0;; second++) {
			if (second >= 60) 
				fail("timeout");
			try { 
				 dynamicElement = driver.findElement(locator);
				 break; 
			} catch (Exception e) {}
			Thread.sleep(1000);
		}
		
		return dynamicElement;
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
