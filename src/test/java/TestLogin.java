import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testWork.extensions.GuiceExtension;
import org.testWork.pages.PageLogin;

import java.util.Arrays;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(GuiceExtension.class)
public class TestLogin extends BaseTest<PageLogin> {

    private static boolean loginFormPassed = false;

    @Test
    @Order(1)
    @DisplayName("Check that login form contains correct labels")
    public void testLoginForm() {
        page.openPage();
        List<String> actualLabels = page.getFormLabels();
        List<String> expectedLabels = Arrays.asList("Email address *", "Password *");

        asserts.assertLabelsPresent(actualLabels, expectedLabels);

        loginFormPassed = true;
    }

    @Test
    @Order(2)
    @DisplayName("Submit login with valid credentials")
    public void testValidLoginSubmit() {
        Assumptions.assumeTrue(loginFormPassed, "Login form validation failed — skipping login test");

        page.openPage();
        page.fillLoginForm(user.get("email"), user.get("password"));
        page.submitLogin();
    }
}
