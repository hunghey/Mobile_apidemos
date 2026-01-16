package pageObjects.SauceLabs;

import commons.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import pageUIs.SauceLab.HomePageUI;
import pageUIs.SauceLab.LoginPageUI;
import pageUIs.SauceLab.MenuPageUI;

public class MenuPage extends BasePage {

    public MenuPage(AndroidDriver driver) {
        super(driver);
    }

    public boolean checkHomePageTitle() {
        return isElementDisplayed(LoginPageUI.HOMEPAGE_TITLE);
    }

    public MenuPage openMenu(){
        clickToElement(MenuPageUI.MENU);
        return PageGenerator.getMenuPage(driver);
    }
    public void logout() {
        clickToElement(MenuPageUI.LOGOUT);
    }
}
