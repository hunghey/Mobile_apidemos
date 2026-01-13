package pageObjects;

import commons.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import pageUIs.AlertPageUI;
import pageUIs.HomePageUI;

public class AppPage extends BasePage {

    public AppPage(AndroidDriver driver) {
        super(driver);
    }

    public AlertDetailsPage openAlertMenu() {
        clickToElement(AlertPageUI.ALERT_DIALOGS);
        return PageGenerator.getAlertPageDetails(driver);
    }

}
