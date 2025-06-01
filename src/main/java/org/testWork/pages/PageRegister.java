package org.testWork.pages;

import com.google.inject.Inject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Map;

import static org.testWork.locators.RegisterLocators.*;
import static org.testWork.pages.Routers.REGISTER_URL;
import static org.testWork.pages.Routers.SING_IN_URL;

public class PageRegister extends BasePage {

    @Inject
    public PageRegister() {
    }

    @Step("Click on the link in the \"Register\" foot and waiting for a transition to a sing_in page")
    public void openPage() {
        clickAndWaitForUrl(SING_IN_LINK, SING_IN_URL);
        clickAndWaitForUrl(REGISTER_LINK, REGISTER_URL);
    }

    public List<String> getFormLabels() {
        return getElementsText(FORM_LABEL);
    }

    @Step("Fill registration form")
    public void fillRegisterForm(
            String firstName,
            String lastName,
            String dateOfBirth,
            String email,
            String telephone,
            String password,
            String street,
            String postalCode,
            String city,
            String state,
            String country
    ) {
        Map<By, String> fieldData =
                Map.of(
                        FIRST_NAME, firstName,
                        LAST_NAME, lastName,
                        DATE_OF_BIRTH, dateOfBirth,
                        STREET, street,
                        CITY, city,
                        STATE, state,
                        POSTAL_CODE, postalCode,
                        EMAIL, email,
                        PHONE, telephone,
                        PASSWORD, password
                );

        fieldData.forEach(this::fillFields);
        switchSelect(COUNTRY, country);
    }

    public void submitRegister() {
        clickAndWaitForUrl(CONFIRM, SING_IN_URL);
    }

}
