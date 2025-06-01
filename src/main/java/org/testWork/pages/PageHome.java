package org.testWork.pages;

import com.google.inject.Inject;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testWork.locators.HomeLocators.*;
import static org.testWork.pages.Routers.HOME_URL;

public class PageHome extends BasePage {

    @Inject
    public PageHome() {
    }

    public void openPage() {
        clickAndWaitForUrl(HOME_LINK, HOME_URL);
    }

    public List<WebElement> getGoods() {
        return findElements(GOODS);
    }

    public void addGoodToCart() {
        click(PLIERS);
        WebElement element = waitElement(ADD_TO_CART);
        element.click();
    }

    public String getTextNotification() {
        WebElement text = waitElement(N_ADD_TO_CART);
        return text.getText();
    }

}
