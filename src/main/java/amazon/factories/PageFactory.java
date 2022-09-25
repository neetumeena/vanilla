package amazon.factories;

import amazon.pages.DetailPage;
import amazon.pages.HomePage;
import amazon.pages.MainMenu;
import amazon.pages.ResultPage;
import org.openqa.selenium.WebDriver;

public class PageFactory {
    public HomePage getHomePage(WebDriver webDriver)
    {
        return new HomePage(webDriver);
    }
    public MainMenu getMainMenu(WebDriver webDriver)
    {
        return new MainMenu(webDriver);
    }
    public ResultPage getResultPage(WebDriver webDriver)
    {
        return new ResultPage(webDriver);
    }
    public DetailPage getDetailPage(WebDriver webDriver)
    {
        return new DetailPage(webDriver);
    }

}
