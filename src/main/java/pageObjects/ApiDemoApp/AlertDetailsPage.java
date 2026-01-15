package pageObjects.ApiDemoApp;

import commons.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageUIs.ApiDemoApp.AlertDetailsPageUI;

import java.util.List;

public class AlertDetailsPage extends BasePage {

    public AlertDetailsPage(AndroidDriver driver) {
        super(driver);
    }

    public String getAlertMessage() {
        waitForElementVisible(AlertDetailsPageUI.MESSAGE);
        return getElementText(AlertDetailsPageUI.MESSAGE);
    }

    public void tapAlertOK() {
        clickToElement(AlertDetailsPageUI.OK_BTN);
    }

    public void tapAlertCancel() {
        clickToElement(AlertDetailsPageUI.CANCEL_BTN);
    }

    public AlertDetailsPage transitNormalAlert() {
        clickToElement(AlertDetailsPageUI.NORMAL_ALERT);
        return PageGenerator.getAlertPageDetails(driver);
    }
//    ListDialog
    public AlertDetailsPage transitListDialog() {
        clickToElement(AlertDetailsPageUI.LIST_DIALOG);
        return PageGenerator.getAlertPageDetails(driver);
    }

    public AlertDetailsPage checkListDialog(List<String> expectedCommands) {
        waitForElementVisible(AlertDetailsPageUI.HEADER_LIST_ALERT);
        List<WebElement> commands = getListElement(AlertDetailsPageUI.COMMAND_ITEMS);

        List<String> actualTexts = commands.stream()
                .map(WebElement::getText)
                .toList();
        Assert.assertEquals(actualTexts, expectedCommands);
        return PageGenerator.getAlertPageDetails(driver);
    }

    public void checkEachDialog(List<String> expectedCommands) {
        List<WebElement> commands = getListElement(AlertDetailsPageUI.COMMAND_ITEMS);
            // Click command i
            commands.getFirst().click();

            // Get message in dialog
            String msgDialog = getElementText(AlertDetailsPageUI.MESSAGE);

            // Compare message with expected i
            Assert.assertTrue(msgDialog.contains(expectedCommands.getFirst()));

            pressBack();

    }

    public void checkSinglechoice(){
        boolean isChecked = Boolean.parseBoolean(getElementAttribute(AlertDetailsPageUI.SINGLE_CHOICE,"checked"));
        if(isChecked)
            clickToElement(AlertDetailsPageUI.OK_BTN);
    }
}
