package pages;

import org.openqa.selenium.*;
import org.testng.Assert;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    By plusButton = By.xpath("//button[text()='+']");
    By removeBtn = By.xpath("//div[text()='Remove']");

    public void increaseQty() {

        driver.findElement(plusButton).click();
        Assert.assertTrue(driver.getPageSource().contains("QUANTITY to '2'"));
    }

    public void removeProduct() {

        driver.findElement(removeBtn).click();
        Assert.assertTrue(driver.getPageSource().contains("Missing Cart items?"));
    }
}
