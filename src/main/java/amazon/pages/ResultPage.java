package amazon.pages;

import amazon.factories.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ResultPage {
    WebDriver driver;
    WebDriverWait wait;
    By SORT_BY = By.xpath("//*[@name='s']");
    By LIST_OF_ITEMS = By.xpath("//*[@data-component-type='s-search-result']");
    By SELECT_BRAND=By.id("p_89/SAMSUNG");


    public ResultPage(WebDriver driver) {
        this.driver = driver;
    }


    public void selectAnyBrand(String brandName) {
        System.out.println("brand name");
        driver.findElement(By.xpath("//*[text()='" + brandName + "']")).click();
        wait=DriverFactory.getWebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(SELECT_BRAND));

    }

    public void getSortBy(String sortBy) throws InterruptedException {
        Select se = new Select(driver.findElement(SORT_BY));
        se.selectByVisibleText(sortBy);
    }

    public void clickOnXNumberOfItem(int itemIndex) throws InterruptedException {
        wait=DriverFactory.getWebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(LIST_OF_ITEMS));
        List<WebElement> listOfItems = driver.findElements(LIST_OF_ITEMS);
        System.out.println(listOfItems.size());
        listOfItems.get(itemIndex - 1).click();
    }
}
