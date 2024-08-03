package base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        Configuration.baseUrl = "https://www.saucedemo.com";
        open("/");
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }

}
