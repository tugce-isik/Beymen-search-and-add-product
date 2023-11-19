import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.IOException;


public class Test_Add_Product_Cart extends BaseTest {

    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;

    @Test
    @Order(1)
    public void search_product() throws IOException {
        homePage = new HomePage(driver);
        homePage.acceptCookies();
        productsPage = new ProductsPage(driver);
        ExcellDataconfig excel = new ExcellDataconfig("word.xlsx");
        homePage.searchBox().clearInput(excel.getData(0, 0, 0));
        homePage.searchBox().search(excel.getData(0, 0, 1));
        Assertions.assertTrue(productsPage.isOnProductPage(), "Not on products page!");
    }

    @Test
    @Order(2)
    public void select_product() {
        productDetailPage = new ProductDetailPage(driver);
        productsPage.selectProduct(0);
        Assertions.assertTrue(productDetailPage.isOnProductDetailPage(), "Not on product detail page!");
    }

    @Test
    @Order(3)
    public void add_product_to_cart() throws IOException {
        productDetailPage.selectVariant();
        productDetailPage.addToCart();
    }

    @Test
    @Order(4)
    public void remove_from_cart() {
        cartPage = new CartPage(driver);
        cartPage.removeProductFromBasket();
        Assertions.assertTrue(cartPage.isEmptyCartPage(), "Cart page is empty!");
    }
}
