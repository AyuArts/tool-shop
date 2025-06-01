package org.testWork.helpers;

import com.google.inject.Inject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InputHelper {

    private final WebDriverWait wait;

    @Inject
    public InputHelper(WebDriverWait wait) {
        this.wait = wait;
    }

    @Step("Filling field {locator} with value: {value}")
    public void fillField(By locator, String value) {
        WebElement field = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        field.clear();
        field.sendKeys(value);
    }
}
