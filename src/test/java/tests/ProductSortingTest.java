package tests;

import base.BaseTest;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ProductsPage;

import static pages.LoginPage.login;
import static pages.ProductsPage.checkFilterText;
import static pages.ProductsPage.selectOption;

public class ProductSortingTest extends BaseTest {

    @BeforeMethod
    public void loginForAccess() {
        login("standard_user", "secret_sauce");
        new ProductsPage().init();
    }

    @Test(description = "Sorting price from low to high")
    @TmsLink("03")
    public void sortPriceLowToHigh() {
        selectOption("Price (low to high)");
        checkFilterText("Price (low to high)");
    }

    @Test(description = "Sorting price from high to low")
    @TmsLink("04")
    public void sortPriceHighToLow() {
        selectOption("Price (high to low)");
        checkFilterText("Price (high to low)");
    }
}
