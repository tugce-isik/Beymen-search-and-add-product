import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage {

    By productListLocator = By.cssSelector("div.o-productList");
    By productNameLocator = By.cssSelector("div.m-productCard__photo");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductPage() {
        return isDisplayed(productListLocator);
    }

    public void selectProduct(int i) {
        getAllProducts().get(i).click();
    }
    private List<WebElement> getAllProducts(){
        return findAll(productNameLocator);
    }
}
