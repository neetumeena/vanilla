package amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainMenu {
    WebDriver driver;

    By LIST_OF_CATEGORIES = By.className("hmenu-item");
    By LIST_OF_DEPARTMENT = By.className("a-list-item");

    public MainMenu(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnElectronicCategory(String category) {
        List<WebElement> listOfCategories = driver.findElements(LIST_OF_CATEGORIES);
        for (WebElement getCategory : listOfCategories) {
            if (getCategory.getText().equals(category)) {
                getCategory.click();
                break;
            }
        }
    }

    public void clickOnElectronicSubCategory(String subCategory) {
        clickOnElectronicCategory(subCategory);
    }

    public void clickOnDepartment(String departmentName) throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> listOfDepartment = driver.findElements(LIST_OF_DEPARTMENT);
        System.out.println(listOfDepartment.size());
        for (WebElement department : listOfDepartment) {
            if (department.getText().equals(departmentName)) {
                department.click();
                break;
            }

        }
    }
}
