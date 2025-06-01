import com.google.inject.Inject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testWork.AssertsForTests;
import org.testWork.Config;
import org.testWork.extensions.GuiceExtension;
import org.testWork.flows.UserFlow;
import org.testWork.utils.RandomUser;

@ExtendWith(GuiceExtension.class)
public abstract class BaseTest<T> {

    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);

    @Inject
    protected UserFlow userFlow;

    @Inject
    protected WebDriver driver;

    @Inject
    protected WebDriverWait wait;

    @Inject
    protected RandomUser user;

    @Inject
    protected AssertsForTests asserts;

    @Inject
    protected T page;

    @BeforeEach
    public void setupMethod() {
        try {
            log.info("WebDriver initialized and window maximized.");
            openProject();
            log.info("Homepage opened successfully.");
        } catch (Exception e) {
            log.error("Error during setupMethod: {}", e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    @AfterEach
    public void teardownMethod() {
        try {
            if (!Config.DEBUG && driver != null) {
                driver.quit();
                log.info("WebDriver closed.");
            }
        } catch (Exception e) {
            log.error("Error during teardownMethod: {}", e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    protected void openProject() {
        driver.get(Config.BASE_URL);
    }
}