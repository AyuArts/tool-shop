package org.testWork.helpers;

import com.google.inject.Inject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropdownHelper {

    private final WebDriverWait wait;

    @Inject
    public DropdownHelper(WebDriverWait wait) {
        this.wait = wait;
    }

    @Step("Selecting '{visibleText}' in dropdown: {locator}")
    public void select(By locator, String visibleText) {
        Select dropdown = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(locator)));
        dropdown.selectByVisibleText(visibleText);
    }

    @Step("Getting selected option in dropdown: {locator}")
    public String getFirstSelectedOption(By locator) {
        Select dropdown = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(locator)));
        return dropdown.getFirstSelectedOption().getText();
    }

    @Step("Checking if selected option equals: {value}")
    public boolean dropdownSelectCheck(By locator, String value) {
        return getFirstSelectedOption(locator).equals(value);
    }

    @Step("Switching dropdown {locator} to {value}")
    public void switchSelect(By locator, String value) {
        select(locator, value);
    }
}