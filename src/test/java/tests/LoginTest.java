package tests;

import base.BaseTest;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

import static pages.LoginPage.checkErrorMessage;
import static pages.LoginPage.login;

public class LoginTest extends BaseTest {

    @Test(description = "Logging in with the valid user's credentials")
    @TmsLink("01")
    public void loginSuccessful() {
        new LoginPage().init();
        login("standard_user", "secret_sauce");
        new ProductsPage().init();
    }

    @Test(description = "Logging in with the locked out user's credentials")
    @TmsLink("02")
    public void loginUnsuccessful() {
        new LoginPage().init();
        login("locked_out_user", "secret_sauce");
        checkErrorMessage("Epic sadface: Sorry, this user has been locked out.");
    }
}
