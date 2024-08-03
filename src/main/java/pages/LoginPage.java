package pages;

import base.PageBase;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends PageBase {

    private static SelenideElement usernameField = $("#user-name");
    private static SelenideElement passwordField = $("#password");
    private static SelenideElement loginButton = $("#login-button");
    private static SelenideElement errorMessageContainer = $(".error-message-container");

    @Override
    public void init() {
        usernameField.shouldBe(visible);
    }

    public static void login(String username, String password) {
        usernameField.setValue(username);
        passwordField.setValue(password);
        loginButton.click();
    }

    public static void checkErrorMessage(String errorText) {
        errorMessageContainer.shouldHave(text(errorText));
    }

}
