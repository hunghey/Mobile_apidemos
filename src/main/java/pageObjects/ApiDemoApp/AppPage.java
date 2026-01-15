package pageObjects.ApiDemoApp;

import commons.BasePage;
import io.appium.java_client.android.AndroidDriver;
import pageUIs.ApiDemoApp.AlertPageUI;

public class AppPage extends BasePage {

    public AppPage(AndroidDriver driver) {
        super(driver);
    }

    public AlertDetailsPage openAlertMenu() {
        clickToElement(AlertPageUI.ALERT_DIALOGS);
        return PageGenerator.getAlertPageDetails(driver);
    }

}
