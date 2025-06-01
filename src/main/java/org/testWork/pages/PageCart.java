package org.testWork.pages;

import com.google.inject.Inject;
import org.openqa.selenium.By;

import java.util.Map;

import static org.testWork.locators.CartLocators.*;
import static org.testWork.locators.RegisterLocators.*;
import static org.testWork.pages.Routers.CART_URL;

public class PageCart extends BasePage {

    @Inject
    public PageCart() {
    }

    public void openPage() {
        clickAndWaitForUrl(CART_LINK, CART_URL);
    }

    public boolean checkTotalPrice() {
        double price = Double.parseDouble(getText(PRICE).replaceAll("[^\\d.]", ""));
        double total = Double.parseDouble(getText(TOTAL).replaceAll("[^\\d.]", ""));
        int quantity = Integer.parseInt(getTextInInput(QUANTITY, "value"));
        double expectedTotal = price * quantity;
        return Math.abs(total - expectedTotal) < 0.01;
    }

    public boolean checkBillingAddress(String street, String postalCode,
                                       String city, String state, String country) {

        Map<By, String> expected = Map.of(
                STREET, street,
                POSTAL_CODE, postalCode,
                CITY, city,
                STATE, state,
                COUNTRY, country
        );

        return expected.entrySet().stream()
                .allMatch(entry -> getTextInInput(entry.getKey(), "value").equals(entry.getValue()));
    }


    public boolean checkHelLo(String firstName, String lastName) {
        String text = getText(HELLO_TEXT);
        return text.contains(firstName) && text.contains(lastName);
    }

    public void setPayment(String payment) {
        switchSelect(PAYMENT_METHOD, payment);
    }

    public void submit() {
        click(SUBMIT);
    }

    public boolean Accept() {
        return waitElement(ACCEPT_TEXT).getText().equals("Payment was successful");
    }

    public void goToNextStep(int step) {
        click(BUTTON_NEXT(step));
    }

}
