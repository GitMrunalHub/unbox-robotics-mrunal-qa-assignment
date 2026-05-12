package pages;

import org.openqa.selenium.*;
import org.testng.Assert;

import java.util.List;

public class SearchPage {

    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    By resultText = By.xpath("//span[contains(text(),'results')]");

    By products = By.xpath("//div[contains(@data-id,'MOB')]");

    By compareCheckboxes = By.xpath("//div[contains(@data-id,'MOB')]//label[.//input[@type='checkbox']]");

    public void verifySearchResults() {  

        String text = driver.findElement(resultText).getText();

        Assert.assertTrue(text.contains("results"));
    }

    public String addProductsToCompare() {

        List<WebElement> phones = driver.findElements(products);
        List<WebElement> compare = driver.findElements(compareCheckboxes);

        compare.get(9).click();
        compare.get(10).click();
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='COMPARE']/../../div/span[2]")).getText(), 2);
    }

    public void click10thPhone() {

        List<WebElement> phones = driver.findElements(products);
        phones.get(9).click();
    }
}
