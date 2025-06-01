package org.testWork.locators;

import org.openqa.selenium.By;

public class HomeLocators {
    public static final By HOME_LINK = By.cssSelector("a[data-test='nav-home']");
    public static final By GOODS = By.className("card");
    public static final By PLIERS = By.xpath("/html/body/app-root/div/app-overview/div[3]/div[2]/div[1]/a[2]");
    public static final By ADD_TO_CART = By.cssSelector("button[data-test='add-to-cart']");
    public static final By N_ADD_TO_CART = By.cssSelector("div.toast-message");
}
