package aboutThisProductTextPresent;

import amazon.config.EnvFactory;
import amazon.factories.DriverFactory;
import amazon.factories.PageFactory;
import com.typesafe.config.Config;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
@Slf4j
public class AboutThisProductTextPresentTestClass {


    private static Config config = EnvFactory.getInstance().getConfig();
    private static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
    private WebDriver driver = DriverFactory.getDriver();

    @Tag("smokeTest")
    @DisplayName("This test is for demo purpose only to show that the basic code works." +
            "You have to use the best practices that you normally use to design your tests")
//    @Test
    void assertThatHomePageTitleIsCorrect() throws InterruptedException {
        driver.get(HOME_PAGE_URL);
        assertEquals("Amazon.com. Spend less. Smile more.", driver.getTitle());
    }

    private final PageFactory pageFactory = new PageFactory();
    AboutThisProductTextPresentHelperClass helperClass = new AboutThisProductTextPresentHelperClass();

    @Test
    void assertAboutThisProductText() throws InterruptedException {
        DriverFactory.setImplicitWait(driver);
        driver.get(HOME_PAGE_URL);
        pageFactory.getHomePage(driver).clickOnHamburgerMenu();
        pageFactory.getMainMenu(driver).clickOnElectronicCategory(helperClass.category);
        pageFactory.getMainMenu(driver).clickOnElectronicSubCategory(helperClass.subCategory);
        pageFactory.getMainMenu(driver).clickOnDepartment(helperClass.departmentName);
        pageFactory.getResultPage(driver).selectAnyBrand(helperClass.brandName);
        pageFactory.getResultPage(driver).getSortBy(helperClass.sortBy);
        pageFactory.getResultPage(driver).clickOnXNumberOfItem(helperClass.itemIndex);
        if (! pageFactory.getDetailPage(driver).aboutThisProductTextPresentOrNot()) {
            log.info("About this item Not Present");
        } else {
            log.info("About this item present");
        }
    }
    @AfterEach
    void quitDriver()
    {
        driver.quit();;
    }
}
