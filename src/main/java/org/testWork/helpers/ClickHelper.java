package org.testWork.helpers;

import com.google.inject.Inject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClickHelper {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @Inject
    public ClickHelper(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    @Step("Clicking on element: {locator}")
    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    @Step("Clicking on {locator} and waiting for URL to contain: {expectedUrlSubstring}")
    public void clickAndWaitForUrl(By locator, String expectedUrlSubstring) {
        click(locator);
        wait.until(ExpectedConditions.urlContains(expectedUrlSubstring));
    }
}
