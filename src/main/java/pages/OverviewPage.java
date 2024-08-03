package pages;

import base.PageBase;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class OverviewPage extends PageBase {

    private static SelenideElement title = $(".title");
    private static SelenideElement finishButton = $("#finish");

    @Override
    public void init() {
        title.shouldBe(visible);
        title.shouldHave(text("Checkout: Overview"));
    }

    public static void clickFinishCheckoutButton() {
        finishButton.click();
        new CompletePage().init();
    }

}
