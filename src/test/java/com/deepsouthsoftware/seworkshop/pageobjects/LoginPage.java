package com.deepsouthsoftware.seworkshop.pageobjects;

import com.thoughtworks.selenium.Selenium;

/**
 * Created by IntelliJ IDEA.
 * User: mstine
 * Date: Nov 29, 2010
 * Time: 11:07:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginPage extends Page {

    public LoginPage(Selenium selenium) {
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

    public void username(String username) {
        selenium.type("username", username);
    }

    public void password(String password) {
        selenium.type("password", "password");
    }

    public PaymentPage login() {
        selenium.click("remember_me");
		selenium.click("loginButton");
        selenium.waitForPageToLoad("30000");
        return new PaymentPage(selenium);
    }
}
