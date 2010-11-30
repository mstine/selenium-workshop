package com.deepsouthsoftware.seworkshop.pageobjects;

import com.thoughtworks.selenium.Selenium;

/**
* Created by IntelliJ IDEA.
* User: mstine
* Date: Nov 29, 2010
* Time: 10:35:47 PM
* To change this template use File | Settings | File Templates.
*/
public class FindASpeakerPage extends Page {
    public FindASpeakerPage(Selenium selenium) {
        super(selenium);
    }

    @Override
    public void to() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean at() {
        return "Find a Speaker".equals(selenium.getTitle());
    }

    public SpeakerDetailsPage getSpeakerDetails(String speaker) {
        selenium.click("link="+speaker);
		selenium.waitForPageToLoad("30000");
        return new SpeakerDetailsPage(selenium, speaker);
    }
}
