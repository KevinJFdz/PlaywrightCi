package pages.dashboard;

import pages.base.BasePage;

public class DashboardPage extends BasePage {
    private String menuButton = "#react-burger-menu-btn";
    private String inventoryItems = ".inventory_item";
    private String addToCartButtonLocator = "[data-test*=add-to-cart]";
    private String shoppingCartButton = "#shopping_cart_container";

    public boolean isDashboardPageDisplayed() {
        return isVisible(menuButton);
    }

    public void addToCartItemByPosition(int itemPosition) {
        System.out.println();
        click(inventoryItems, itemPosition, addToCartButtonLocator);
    }

    public void clickShoppingCartButton() {
        click(shoppingCartButton);
    }
}
