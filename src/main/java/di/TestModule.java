package di;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testWork.AssertsForTests;
import org.testWork.Config;
import org.testWork.flows.UserFlow;
import org.testWork.helpers.*;
import org.testWork.pages.PageCart;
import org.testWork.pages.PageHome;
import org.testWork.pages.PageLogin;
import org.testWork.pages.PageRegister;
import org.testWork.utils.RandomUser;

import java.time.Duration;

public class TestModule extends AbstractModule {
    @Override
    protected void configure() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Config.TIMEOUT));
        AssertsForTests asserts = new AssertsForTests();
        RandomUser user = RandomUser.getInstance();


        bind(RandomUser.class).toInstance(user);
        bind(WebDriver.class).toInstance(driver);
        bind(WebDriverWait.class).toInstance(wait);
        bind(AssertsForTests.class).toInstance(asserts);

        // helpers
        bind(ClickHelper.class).in(Singleton.class);
        bind(DropdownHelper.class).in(Singleton.class);
        bind(ElementHelper.class).in(Singleton.class);
        bind(ScriptHelper.class).in(Singleton.class);
        bind(CursorHelper.class).in(Singleton.class);
        bind(InputHelper.class).in(Singleton.class);
        bind(WaitHelper.class).in(Singleton.class);

        // pages
        bind(PageRegister.class).in(Singleton.class);
        bind(PageLogin.class).in(Singleton.class);
        bind(PageHome.class).in(Singleton.class);
        bind(PageCart.class).in(Singleton.class);

        // flows
        bind(UserFlow.class).in(Singleton.class);
    }
}

