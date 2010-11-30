package com.deepsouthsoftware.seworkshop.pageobjects;

import com.thoughtworks.selenium.Selenium;

/**
 * Created by IntelliJ IDEA.
 * User: mstine
 * Date: Nov 29, 2010
 * Time: 11:12:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class PaymentPage extends Page {

    public PaymentPage(Selenium selenium) {
        super(selenium);
    }

    @Override
    public void to() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean at() {
        return selenium.isTextPresent("This concludes your fake rental experience!");
    }
}
