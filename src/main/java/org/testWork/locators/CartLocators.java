package org.testWork.locators;

import org.openqa.selenium.By;

public class CartLocators {
    public static final By CART_LINK = By.cssSelector("a[data-test='nav-cart']");
    public static final By PRICE = By.cssSelector("span[data-test='product-price']");
    public static final By TOTAL = By.cssSelector("span[data-test='line-price']");
    public static final By QUANTITY = By.cssSelector("input[data-test='product-quantity']");
    public static final By HELLO_TEXT = By.tagName("p");
    public static final By PAYMENT_METHOD = By.id("payment-method");
    public static final By SUBMIT = By.cssSelector("button[data-test='finish']");
    public static final By ACCEPT_TEXT = By.className("help-block");

    public static By BUTTON_NEXT(int step) {
        return By.cssSelector("button[data-test='proceed-" + step + "']");
    }

}
