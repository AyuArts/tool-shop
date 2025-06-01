import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebElement;
import org.testWork.extensions.GuiceExtension;
import org.testWork.pages.PageHome;

import java.util.List;

@ExtendWith(GuiceExtension.class)
public class TestHome extends BaseTest<PageHome> {
    @Test
    public void testPresenceOfGoods() {
        page.openPage();
        List<WebElement> goods = page.getGoods();
        assert !goods.isEmpty();
    }

    @Test
    public void testAddGoodToCart() {
        String notificationText = userFlow.addToCart();
        assert notificationText.contains("Product added to shopping cart.");
    }
}