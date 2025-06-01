import io.qameta.allure.Epic;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testWork.extensions.GuiceExtension;
import org.testWork.pages.PageRegister;

import java.util.Arrays;
import java.util.List;

@Epic("Library")
@ExtendWith(GuiceExtension.class)
public class TestRegister extends BaseTest<PageRegister> {
    @Test
    public void testRegisterForm() {
        page.openPage();
        List<String> actualLabels = page.getFormLabels();
        List<String> expectedLabels = Arrays.asList(
                "First name",
                "Last name",
                "Date of Birth *",
                "Street",
                "Postal code",
                "City",
                "State",
                "Country",
                "Phone",
                "Email address",
                "Password"
        );
        asserts.assertLabelsPresent(actualLabels, expectedLabels);
    }

    @Test
    public void testValidRegisterSubmit() {
        page.openPage();
        page.fillRegisterForm(
                user.get("firstName"),
                user.get("lastName"),
                user.get("dateOfBirth"),
                user.get("email"),
                user.get("phone"),
                user.get("password"),
                user.get("street"),
                user.get("postalCode"),
                user.get("city"),
                user.get("state"),
                user.get("country")
        );
        page.submitRegister();

    }

}