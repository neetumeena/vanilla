package aboutThisProductTextPresent;

import amazon.config.EnvFactory;
import amazon.factories.DriverFactory;
import amazon.factories.PageFactory;
import com.typesafe.config.Config;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

@Slf4j
public class AboutThisProductTextPresentTestClass {


    private static Config config = EnvFactory.getInstance().getConfig();
    private static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
    private final PageFactory pageFactory = new PageFactory();
    AboutThisProductTextPresentHelperClass helperClass = new AboutThisProductTextPresentHelperClass();
    private WebDriver driver = DriverFactory.getDriver();


    @DisplayName("This test is to validate about this product text on product detail page")
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
    void quitDriver() {
        driver.quit();
        ;
    }
}
