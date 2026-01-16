package pageObjects.SauceLabs;

import commons.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import pageUIs.SauceLab.HomePageUI;
import pageUIs.SauceLab.LoginPageUI;

public class HomePage extends BasePage {

    public HomePage(AndroidDriver driver) {
        super(driver);
    }

    public boolean checkHomePageTitle() {
        return isElementDisplayed(LoginPageUI.HOMEPAGE_TITLE);
    }

    public void inputAccount(String username, String password) {

    }
}
