package pageObjects.SauceLabs;

import commons.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import pageUIs.SauceLab.HomePageUI;
import pageUIs.SauceLab.LoginPageUI;

public class LoginPage extends BasePage {

    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    public boolean checkHomePageTitle() {
        return isElementDisplayed(LoginPageUI.HOMEPAGE_TITLE);
    }

    public void inputAccount(String username, String password) {
        inputText(LoginPageUI.USERNAME_TXT, username);
        inputText(LoginPageUI.PASSWORD_TXT, password);
        clickToElement(LoginPageUI.LOGIN_BTN);
    }

    public boolean checkLogin(String message) {
        boolean statusLogin =  false;
        if(isElementDisplayed(HomePageUI.PRODUCT_TITLE)){
            statusLogin = true;
        }else{
            String msg = getElementText(LoginPageUI.ERROR_TEXT);
            Assert.assertEquals(msg, message);
        }
        return statusLogin;
    }
}
