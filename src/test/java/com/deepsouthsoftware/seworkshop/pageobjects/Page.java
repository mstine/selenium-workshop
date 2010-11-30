package com.deepsouthsoftware.seworkshop.pageobjects;

import com.thoughtworks.selenium.Selenium;

/**
 * Created by IntelliJ IDEA.
 * User: mstine
 * Date: Nov 29, 2010
 * Time: 10:43:08 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Page {
    protected Selenium selenium;

    public Page(Selenium selenium) {
        this.selenium = selenium;
    }

    public abstract void to();

    public abstract boolean at();
}
