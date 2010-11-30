package com.deepsouthsoftware.seworkshop.pageobjects;

import com.thoughtworks.selenium.Selenium;

/**
 * Created by IntelliJ IDEA.
 * User: mstine
 * Date: Nov 29, 2010
 * Time: 10:39:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class SpeakerDetailsPage extends Page {
    private String speaker;

    public SpeakerDetailsPage(Selenium selenium, String speaker) {
        super(selenium);
        this.speaker = speaker;
    }

    public KiosksForSpeakerPage findThisSpeaker() {
        selenium.click("link=Find this Speaker");
        selenium.waitForPageToLoad("30000");
        return new KiosksForSpeakerPage(selenium);
    }

    @Override
    public void to() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean at() {
        return speaker.equals(selenium.getText("//h1"));
    }
}
