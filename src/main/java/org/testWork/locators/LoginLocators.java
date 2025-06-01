package org.testWork.locators;

import org.openqa.selenium.By;

public class LoginLocators {
    public static final By SING_IN_LINK = By.linkText("Sign in");
    public static final By FORM_LABEL = By.tagName("label");
    public static final By EMAIL = By.id("email");
    public static final By PASSWORD = By.id("password");
    public static final By CONFIRM = By.cssSelector("input[type='submit']");

}
