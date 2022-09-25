package amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DetailPage {
    WebDriver driver;

    By ABOUT_THIS_PRODUCT=By.xpath("//*[text()=' About this item ']");
    public DetailPage(WebDriver driver) {
        this.driver = driver;
    }
    public boolean aboutThisProductTextPresentOrNot() {
        List<WebElement> list = driver.findElements(ABOUT_THIS_PRODUCT);
        return list.size() > 0;
    }
}
