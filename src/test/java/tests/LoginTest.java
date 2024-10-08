package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigManager;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(ConfigManager.getProperty("url"));

        loginPage = new LoginPage(driver).init();
    }

    @Test(description = "Logging in with the valid user's credentials")
    public void verifySuccessfulLogin() {
        loginPage.enterUsername(ConfigManager.getProperty("username"));
        loginPage.enterPassword(ConfigManager.getProperty("password"));
        loginPage.clickLoginButton();

        assertTrue(driver.getCurrentUrl().contains("inventory.html"),
                "Login was not successful. Expected to be on inventory page.");
    }

    @Test(description = "Logging in with the locked out user's credentials")
    public void verifyLoginFailureWithIncorrectCredentials() {
        loginPage.enterUsername(ConfigManager.getProperty("username"));
        loginPage.enterPassword(ConfigManager.getProperty("incorrect_password"));
        loginPage.clickLoginButton();

        assertTrue(loginPage.getErrorMessage().contains("Epic sadface"),
                "Expected error message was not displayed for incorrect credentials.");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}


