import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class WriteText extends BasePage{
    public WriteText(WebDriver driver) {
        super(driver);
    }

    public static void main(String[] args) throws IOException {
        By infoProductLocator  = By.cssSelector(".o-productDetail__description");
        By priceProductLocator = By.id("priceNew");

        FileWriter fw = new FileWriter("info.txt",true);
        PrintWriter pw = new PrintWriter(fw);
        pw.println("Product info= " + infoProductLocator + " Product price= "  + priceProductLocator);
        pw.close();
    }
}