package com.orangehrm;

import core.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pageObjects.ApiDemoApp.AlertDetailsPage;
import pageObjects.ApiDemoApp.HomePage;

import java.util.List;

public class AlertDialog {
    private AndroidDriver driver;
    private HomePage homePage;
    private AlertDetailsPage alertPage;

    @BeforeMethod
    public void beforeTest(){
        driver = DriverFactory.initDriver();
        homePage = new HomePage(driver);
        alertPage = new AlertDetailsPage(driver);
    }
    @Test
    public void TC1_NormalDialog(){
        homePage.checkHomePageTitle();
        homePage.openAppMenu()
                .openAlertMenu()
                .transitNormalAlert()
                .tapAlertOK();
    }
    @Test
    public void TC2_ListDialog(){
        List<String> expected = List.of(
                "Command one",
                "Command two",
                "Command three",
                "Command four"
        );
        alertPage.transitListDialog()
                .checkListDialog(expected)
                .checkEachDialog(expected);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        driver.quit();
    }
}
