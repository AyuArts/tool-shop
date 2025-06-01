package org.testWork.pages;

import com.google.inject.Inject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testWork.helpers.*;

import java.util.List;

public abstract class BasePage {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());
    @Inject
    protected WebDriver driver;
    @Inject
    protected WebDriverWait wait;
    @Inject
    protected ClickHelper clickHelper;
    @Inject
    protected DropdownHelper dropdownHelper;
    @Inject
    protected ElementHelper elementHelper;
    @Inject
    protected ScriptHelper scriptHelper;
    @Inject
    protected CursorHelper cursorHelper;
    @Inject
    protected InputHelper inputHelper;
    @Inject
    protected WaitHelper waitHelper;

    public abstract void openPage();

    public void click(By locator) {
        clickHelper.click(locator);
    }

    public void clickAndWaitForUrl(By locator, String expectedUrlSubstring) {
        clickHelper.clickAndWaitForUrl(locator, expectedUrlSubstring);
    }

    public void select(By locator, String visibleText) {
        dropdownHelper.select(locator, visibleText);
    }

    public void switchSelect(By locator, String value) {
        dropdownHelper.switchSelect(locator, value);
    }

    public boolean dropdownSelectCheck(By locator, String value) {
        return dropdownHelper.dropdownSelectCheck(locator, value);
    }

    public String getFirstSelectedOption(By locator) {
        return dropdownHelper.getFirstSelectedOption(locator);
    }

    public WebElement findElement(By locator) {
        return elementHelper.findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        return elementHelper.findElements(locator);
    }

    public List<String> getElementsText(By locator) {
        return elementHelper.getElementsText(locator);
    }

    public void cursorGuidance(By locator) {
        cursorHelper.moveToElement(locator);
    }

    public void fillFields(By locator, String value) {
        inputHelper.fillField(locator, value);
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public String getTextInInput(By locator, String value) {
        return getElement(locator).getAttribute(value);
    }

    public Object executeScript(String script, Object... args) {
        return scriptHelper.executeScript(script, args);
    }

    public String getText(By locator) {
        return elementHelper.getText(locator);
    }

    public boolean checkCount(By locator, String value) {
        return elementHelper.checkCount(locator, value);
    }

    public void waitSwitch(By locator, String value) {
        waitHelper.waitForText(locator, value);
    }

    public WebElement waitElement(By locator) {
        return waitHelper.waitElement(locator);
    }
}
