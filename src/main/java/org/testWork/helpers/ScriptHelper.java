package org.testWork.helpers;

import com.google.inject.Inject;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ScriptHelper {

    private final WebDriver driver;

    @Inject
    public ScriptHelper(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Executing JS: {script}")
    public Object executeScript(String script, Object... args) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript(script, args);
    }
}