package amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    By HAM_BURGER_MENU= By.xpath("//*[@data-action-params='{\"toasterType\":\"AIS_INGRESS\"}']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickOnHamburgerMenu() throws InterruptedException {
        try {
            driver.findElement(HAM_BURGER_MENU).click();

        } catch (Exception e) {
            System.out.println("no pop-up");
        }
        driver.findElement(By.className("hm-icon-label")).click();
    }
}
