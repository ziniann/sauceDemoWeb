package tests;

import base.BaseTest;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.OverviewPage;
import pages.ProductsPage;

import static pages.CheckoutPage.clickCompleteCheckoutButton;
import static pages.CheckoutPage.fillCheckoutInfo;
import static pages.CompletePage.checkCompletionMessage;
import static pages.LoginPage.login;
import static pages.OverviewPage.clickFinishCheckoutButton;
import static pages.ProductsPage.*;
import static pages.CartPage.clickCheckoutButton;

public class CartAndCheckoutTest extends BaseTest {

    @BeforeMethod
    public void loginForAccess() {
        login("standard_user", "secret_sauce");
        new ProductsPage().init();
    }

    @Test(description = "Adding item into the cart")
    @TmsLink("05")
    public void addItemToCart() {
        isInventoryItemPresent("Sauce Labs Backpack");
        clickAddButton();
        checkShoppingCartBadgeCount("1");
    }

    @Test(description = "Completing the checkout")
    @TmsLink("06")
    public void completeCheckout() {
        isInventoryItemPresent("Sauce Labs Backpack");
        clickAddButton();
        clickShoppingCart();
        clickCheckoutButton();
        fillCheckoutInfo("Zinaa", "Umrshatyan", "000333");
        clickCompleteCheckoutButton();
        new OverviewPage().init();
        clickFinishCheckoutButton();
        checkCompletionMessage("THANK YOU FOR YOUR ORDER");
    }

}
