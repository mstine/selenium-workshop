package com.deepsouthsoftware.seworkshop.pageobjects;

import com.thoughtworks.selenium.Selenium;

/**
 * Created by IntelliJ IDEA.
 * User: mstine
 * Date: Nov 29, 2010
 * Time: 11:04:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class SpeakerRentalPage extends Page {

    public SpeakerRentalPage(Selenium selenium) {
        super(selenium);
    }

    @Override
    public void to() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean at() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public LoginPage continueToSignOn() {
        selenium.click("link=Continue");
		selenium.waitForPageToLoad("30000");
        return new LoginPage(selenium);
    }
}
