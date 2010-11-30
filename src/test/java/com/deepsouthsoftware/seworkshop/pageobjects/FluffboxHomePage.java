package com.deepsouthsoftware.seworkshop.pageobjects;

import com.thoughtworks.selenium.Selenium;

/**
* Created by IntelliJ IDEA.
* User: mstine
* Date: Nov 29, 2010
* Time: 10:35:01 PM
* To change this template use File | Settings | File Templates.
*/
public class FluffboxHomePage extends Page {
    public FluffboxHomePage(Selenium selenium) {
        super(selenium);
    }

    @Override
    public void to() {
        selenium.open("/fluffbox-rwx/");
    }

    @Override
    public boolean at() {
        return "Fluffbox".equals(selenium.getTitle());
    }

    public FindASpeakerPage findASpeaker() {
        selenium.click("//a[contains(@href, '/fluffbox-rwx/speaker/find')]");
        selenium.waitForPageToLoad("30000");
        return new FindASpeakerPage(selenium);
    }
}
