package pages;

import base.PageBase;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CompletePage extends PageBase {

    private static SelenideElement title = $(".title");
    private static SelenideElement completeHeader = $(".complete-header");

    @Override
    public void init() {
        title.shouldBe(visible);
        title.shouldHave(text("Checkout: Complete!"));
    }

    public static void checkCompletionMessage(String message) {
        completeHeader.shouldHave(text(message));
    }

}
