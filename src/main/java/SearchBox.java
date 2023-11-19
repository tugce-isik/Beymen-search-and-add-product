import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchBox extends BasePage {

    By searchBoxDiv = By.cssSelector(".o-header__search--wrapper");
    By searchBoxLocator = By.id("o-searchSuggestion__input");

    public SearchBox(WebDriver driver) {
        super(driver);
    }

    public void clearInput(String text) {
        click(searchBoxDiv);
        type(searchBoxLocator,text);
        clear(searchBoxLocator);
    }
    public void search(String text) {
        type(searchBoxLocator,text);
        driver.findElement(By.cssSelector("button.o-header__search--btn")).sendKeys(Keys.ENTER);
    }
}
