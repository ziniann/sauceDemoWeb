package pages;

import base.PageBase;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CartPage extends PageBase {

    private static SelenideElement title = $(".title");
    private static SelenideElement checkoutButton = $("#checkout");

    @Override
    public void init() {
        title.shouldBe(visible);
        title.shouldHave(text("Your Cart"));
    }

    public static void clickCheckoutButton() {
        checkoutButton.click();
        new CheckoutPage().init();
    }

}
