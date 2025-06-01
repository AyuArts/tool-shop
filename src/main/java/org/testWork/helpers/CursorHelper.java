package org.testWork.helpers;

import com.google.inject.Inject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CursorHelper {

    private final WebDriverWait wait;
    private final Actions actions;

    @Inject
    public CursorHelper(WebDriver driver, WebDriverWait wait) {
        this.wait = wait;
        this.actions = new Actions(driver);
    }

    @Step("Moving cursor to element: {locator}")
    public void moveToElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        actions.moveToElement(element).perform();
    }
}
