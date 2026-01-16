package com.SauceLabs;

import core.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.SauceLabs.LoginPage;
import pageObjects.SauceLabs.MenuPage;
import utilities.CSVReader;

public class TC1 {
    private AndroidDriver driver;
    private LoginPage loginPage;
    private MenuPage menuPage;

    @BeforeMethod
    public void beforeTest(){
        driver = DriverFactory.initDriver();
        loginPage = new LoginPage(driver);
        menuPage = new MenuPage(driver);
    }
    @Test(dataProvider = "loginData",
            dataProviderClass = CSVReader.class)
    public void TC1_Login(String username, String password, String expectedMessage){
        loginPage.checkHomePageTitle();
        loginPage.inputAccount(username,password);
        if(loginPage.checkLogin(expectedMessage)){
            menuPage.openMenu()
                    .logout();
            loginPage.checkHomePageTitle();
        }
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        driver.quit();
    }
}
