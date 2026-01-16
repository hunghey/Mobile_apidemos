package pageObjects.SauceLabs;

import io.appium.java_client.android.AndroidDriver;
import pageObjects.SauceLabs.LoginPage;
import pageUIs.ApiDemoApp.HomePageUI;

public class PageGenerator {

    public static LoginPage getLoginPage(AndroidDriver driver){
        return new LoginPage(driver);
    }

    public static HomePage getHomePage(AndroidDriver driver){
        return new HomePage(driver);
    }

    public static MenuPage getMenuPage(AndroidDriver driver){
        return new MenuPage(driver);
    }

}
