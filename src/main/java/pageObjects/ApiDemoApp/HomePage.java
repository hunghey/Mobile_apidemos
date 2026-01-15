package pageObjects.ApiDemoApp;

import commons.BasePage;
import io.appium.java_client.android.AndroidDriver;
import pageUIs.ApiDemoApp.HomePageUI;

public class HomePage extends BasePage {

    public HomePage(AndroidDriver driver) {
        super(driver);
    }

    public boolean checkHomePageTitle() {
        return isElementDisplayed(HomePageUI.HOMEPAGE_TITLE);
    }

    public AppPage openAppMenu() {
        clickToElement(HomePageUI.APP_MENU);
        return PageGenerator.getAppPage(driver);
    }
}
