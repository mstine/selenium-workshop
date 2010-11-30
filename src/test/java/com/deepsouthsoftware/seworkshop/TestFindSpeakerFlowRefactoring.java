package com.deepsouthsoftware.seworkshop;

import com.deepsouthsoftware.seworkshop.pageobjects.*;
import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.SeleneseTestBase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestFindSpeakerFlowRefactoring extends SeleneseTestBase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8080/");
		selenium.start();
	}

	@Test
	public void testFindSpeakerFlow() throws Exception {
        FluffboxHomePage homePage = new FluffboxHomePage(selenium);
        homePage.to();
        assertTrue(homePage.at());

        FindASpeakerPage findASpeakerPage = homePage.findASpeaker();
        assertTrue(findASpeakerPage.at());

        SpeakerDetailsPage speakerDetailsPage = findASpeakerPage.getSpeakerDetails("Alex Miller");
        assertTrue(speakerDetailsPage.at());

        KiosksForSpeakerPage kiosksForSpeakerPage = speakerDetailsPage.findThisSpeaker();
        assertTrue(kiosksForSpeakerPage.at());

        SpeakerRentalPage speakerRentalPage = kiosksForSpeakerPage.rentNow();
        assertTrue(speakerRentalPage.at());

        LoginPage loginPage = speakerRentalPage.continueToSignOn();
        assertTrue(loginPage.at());

        loginPage.username("joeuser");
        loginPage.password("password");
        PaymentPage paymentPage = loginPage.login();

        assertTrue(paymentPage.at());
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
