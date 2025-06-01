package org.testWork.locators;

import org.openqa.selenium.By;

public class RegisterLocators {
    public static final By SING_IN_LINK = By.linkText("Sign in");
    public static final By REGISTER_LINK = By.linkText("Register your account");
    public static final By FORM_LABEL = By.tagName("label");
    public static final By FIRST_NAME = By.id("first_name");
    public static final By LAST_NAME = By.id("last_name");
    public static final By DATE_OF_BIRTH = By.id("dob");
    public static final By STREET = By.id("street");
    public static final By CITY = By.id("city");
    public static final By STATE = By.id("state");
    public static final By POSTAL_CODE = By.id("postal_code");
    public static final By EMAIL = By.id("email");
    public static final By PHONE = By.id("phone");
    public static final By PASSWORD = By.id("password");
    public static final By COUNTRY = By.id("country");
    public static final By CONFIRM = By.xpath("/html/body/app-root/div/app-register/div/div/div/form/div/button");
}


