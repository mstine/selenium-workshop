package com.deepsouthsoftware.seworkshop.pageobjects;

import com.thoughtworks.selenium.Selenium;

/**
 * Created by IntelliJ IDEA.
 * User: mstine
 * Date: Nov 29, 2010
 * Time: 11:01:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class KiosksForSpeakerPage extends Page {
    @Override
    public void to() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean at() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public KiosksForSpeakerPage(Selenium selenium) {
        super(selenium);
    }

    public SpeakerRentalPage rentNow() {
        selenium.click("link=RENT NOW");
		selenium.waitForPageToLoad("30000");
        return new SpeakerRentalPage(selenium);
    }
}
