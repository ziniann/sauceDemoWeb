package pages;

import base.PageBase;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage extends PageBase {

    private static SelenideElement title = $(".title");
    private static SelenideElement firstName = $("#first-name");
    private static SelenideElement lastName = $("#last-name");
    private static SelenideElement postalCode = $("#postal-code");
    private static SelenideElement continueButton = $("#continue");

    @Override
    public void init() {
        title.shouldBe(visible);
        title.shouldHave(text("Checkout: Your Information"));
    }

    public static void fillCheckoutInfo(String firstNameValue, String lastNameValue, String postalCodeValue) {
        firstName.setValue(firstNameValue);
        lastName.setValue(lastNameValue);
        postalCode.setValue(postalCodeValue);
    }

    public static void clickCompleteCheckoutButton() {
        continueButton.click();
    }

}
