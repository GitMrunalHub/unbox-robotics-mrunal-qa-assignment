package pages;

import org.openqa.selenium.*;
import org.testng.Assert;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    By addToCart = By.xpath("//button[contains(text(),'Add to cart')]");

    public void addProductToCart() {

        driver.findElement(addToCart).click();
        Assert.assertTrue(driver.getPageSource().contains("Go to Cart"));
    }
}
