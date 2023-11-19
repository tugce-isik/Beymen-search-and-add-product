import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage {

    By acceptCookiesLocator = By.id("onetrust-accept-btn-handler");
    By acceptGenderLocator = By.id("genderWomanButton");

    SearchBox searchBox;

    public HomePage(WebDriver driver) {
        super(driver);
        searchBox = new SearchBox(driver);
    }

    public SearchBox searchBox() {
        return this.searchBox;
    }

    public void acceptCookies() {
        if (isDisplayed(acceptCookiesLocator)) {
            click(acceptCookiesLocator);
            click(acceptGenderLocator);
        }
    }
}
