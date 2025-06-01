import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testWork.extensions.GuiceExtension;
import org.testWork.pages.PageCart;

@ExtendWith(GuiceExtension.class)
public class TestCart extends BaseTest<PageCart> {

    @Test
    public void testValidTotalPrice() {
        userFlow.addToCart();
        page.openPage();
        assert page.checkTotalPrice();
    }

    @Test
    public void testUserFlowPlaceAnOrder() {
        String firstName = user.get("firstName");
        String lastName = user.get("lastName");
        String dateOfBirth = user.get("dateOfBirth");
        String email = user.get("email");
        String telephone = user.get("phone");
        String password = user.get("password");
        String street = user.get("street");
        String postalCode = user.get("postalCode");
        String city = user.get("city");
        String state = user.get("state");
        String country = user.get("country");
        userFlow.registerAndLogin(firstName, lastName, dateOfBirth, email, telephone, password, street, postalCode, city, state, country);
        userFlow.addToCart();
        userFlow.placeAnOrder(firstName, lastName, street, postalCode, city, state);
    }
}
