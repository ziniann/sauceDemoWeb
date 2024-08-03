package pages;

import base.PageBase;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProductsPage extends PageBase {

    private static SelenideElement title = $(".title");
    private static SelenideElement filter = $(".product_sort_container");
    private static SelenideElement inventoryItem = $(".inventory_item");
    private static SelenideElement inventoryItemAddButton = $("#add-to-cart-sauce-labs-backpack");
    private static SelenideElement shoppingCartBadge = $(".shopping_cart_badge");

    @Override
    public void init() {
        title.shouldBe(visible);
        title.shouldHave(text("Products"));
    }

    public static void isInventoryItemPresent(String itemName) {
        inventoryItem.shouldHave(text(itemName));
    }

    public static void checkFilterText(String filterText) {
        filter.shouldHave(text(filterText));
    }

    public static void checkShoppingCartBadgeCount(String displayedCount) {
        shoppingCartBadge.shouldHave(text(displayedCount));
    }

    public static void selectOption(String filterOption) {
        filter.selectOption(filterOption);
    }

    public static void clickAddButton() {
        inventoryItemAddButton.click();
    }

    public static void clickShoppingCart() {
        shoppingCartBadge.click();
        new CartPage().init();
    }

}
