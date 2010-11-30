package com.deepsouthsoftware.seworkshop;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestFindKioskFlowRefactored extends SeleneseTestBase {
    @Before
    public void setUp() throws Exception {
        selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8080/");
        selenium.start();
    }

    @Test
    public void testFindKioskFlow() throws Exception {
        goToFluffboxHomePage();
        findAFluffbox();
        searchForKiosksIn("Ft. Lauderdale");
        findSpeakersAtFirstKiosk();
        viewDetailsFor("Aleksandar Seovic");
        rentNow();
        continueToPayment();
    }

    private void continueToPayment() throws Exception {
        selenium.click("link=Continue");
        selenium.waitForPageToLoad("30000");
        Thread.sleep(10000);
        assertTrue("Should be on payment page!", selenium.isTextPresent("This concludes your fake rental experience!"));
    }

    private void rentNow() {
        selenium.click("link=RENT NOW!");
        selenium.waitForPageToLoad("30000");
    }

    private void viewDetailsFor(String speaker) {
        selenium.click("link=" + speaker);
        selenium.waitForPageToLoad("30000");
    }

    private void findSpeakersAtFirstKiosk() throws Exception {
        waitForElementPresent("link=Find Speakers Here");
        selenium.click("link=Find Speakers Here");
        selenium.waitForPageToLoad("30000");
    }

    private void searchForKiosksIn(String location) {
        selenium.type("searchCriteria", location);
        selenium.click("searchButton");
    }

    private void findAFluffbox() {
        selenium.click("//a[contains(@href, '/fluffbox-rwx/kiosk/find')]");
        selenium.waitForPageToLoad("30000");
    }

    private void goToFluffboxHomePage() {
        selenium.open("/fluffbox-rwx/");
    }

    private void waitForElementPresent(String locator) throws Exception {
        for (int second = 0; ; second++) {
            if (second >= 60)
                fail("timeout");
            try {
                if (selenium.isElementPresent(locator))
                    break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }
    }

    @After
    public void tearDown() throws Exception {
        selenium.stop();
    }
}
