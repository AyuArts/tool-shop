package org.testWork.pages;

import com.google.inject.Inject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Map;

import static org.testWork.locators.LoginLocators.*;
import static org.testWork.pages.Routers.ACCOUNT_URL;
import static org.testWork.pages.Routers.SING_IN_URL;

public class PageLogin extends BasePage {

    @Inject
    public PageLogin() {
    }

    @Step("Click on the link in the \"Register\" foot and waiting for a transition to a sing_in page")
    public void openPage() {
        clickAndWaitForUrl(SING_IN_LINK, SING_IN_URL);
    }

    public List<String> getFormLabels() {
        return getElementsText(FORM_LABEL);
    }

    @Step("Fill Login form")
    public void fillLoginForm(
            String email,
            String password
    ) {
        Map<By, String> fieldData =
                Map.of(
                        EMAIL, email,
                        PASSWORD, password
                );
        fieldData.forEach(this::fillFields);
    }

    public void submitLogin() {
        clickAndWaitForUrl(CONFIRM, ACCOUNT_URL);
    }

}
