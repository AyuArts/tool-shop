package org.testWork.helpers;

import com.google.inject.Inject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class ElementHelper {

    private final WebDriverWait wait;

    @Inject
    public ElementHelper(WebDriverWait wait) {
        this.wait = wait;
    }

    @Step("Finding element: {locator}")
    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    @Step("Finding all elements: {locator}")
    public List<WebElement> findElements(By locator) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    @Step("Getting text from element: {locator}")
    public String getText(By locator) {
        return findElement(locator).getText();
    }

    @Step("Getting visible text for all elements: {locator}")
    public List<String> getElementsText(By locator) {
        return findElements(locator).stream()
                .map(WebElement::getText)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
    }

    @Step("Checking if count of elements equals: {value}")
    public boolean checkCount(By locator, String value) {
        return String.valueOf(findElements(locator).size()).equals(value);
    }
}