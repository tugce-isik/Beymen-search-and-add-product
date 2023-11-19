import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProductDetailPage extends BasePage{

    By productDetailLocator = By.cssSelector("div.o-productDetail");
    By addToCartButtonLocator = By.id("addBasket");
    By selectVariantLocator = By.cssSelector(".m-variation__item:not(-disabled):nth-child(2)");
    By priceOnDetailPageLocator = By.id("priceNew");
    By priceOnCartPageLocator  = By.cssSelector(".m-productPrice__salePrice");
    By cartPageLocator = By.cssSelector(".o-header__userInfo--item.bwi-cart-o.-cart");



    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductDetailPage() {
        return isDisplayed(productDetailLocator);
    }

    public void selectVariant() {
        click(selectVariantLocator);
    }

    public void addToCart() {
        click(addToCartButtonLocator);
        String priceOnDetailPage = find(priceOnDetailPageLocator).getText();
        String[] priceOnDetailPageSplit = priceOnDetailPage.split(" TL");
        double priceOnDetailPageDbl = Double.valueOf(priceOnDetailPageSplit[0]);
        click(cartPageLocator);
        String priceOnCartPage = find(priceOnCartPageLocator).getText();
        String[] priceOnCartPageSplit = priceOnCartPage.split(",");
        double priceOnCartPageDbl = Double.valueOf(priceOnCartPageSplit[0]);
        if(priceOnDetailPageDbl == priceOnCartPageDbl){
            System.out.println("Results matched!");
        }else {
            System.out.println("Results not matched!");
        }
        WebElement selectLocator = driver.findElement(By.id("quantitySelect0-key-0"));
        Select select = new Select(selectLocator);
        select.selectByValue("2");
    }
}
