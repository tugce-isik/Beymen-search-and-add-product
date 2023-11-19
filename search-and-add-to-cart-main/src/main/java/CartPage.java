import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    By removeProductLocator = By.id("removeCartItemBtn0-key-0");
    By emptyCartLocator = By.id("emtyCart");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isEmptyCartPage() {
        return isDisplayed(emptyCartLocator);
    }

    public void removeProductFromBasket() {
        click(removeProductLocator);
    }
}
