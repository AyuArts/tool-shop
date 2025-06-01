package org.testWork.helpers;

import com.google.inject.Inject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

    private final WebDriverWait wait;

    @Inject
    public WaitHelper(WebDriverWait wait) {
        this.wait = wait;
    }

    @Step("Waiting for element {locator} to contain text: {text}")
    public void waitForText(By locator, String text) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    @Step("Waiting for element with locator: {locator}")
    public WebElement waitElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
