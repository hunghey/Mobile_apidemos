package commons;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;

public class BaseTest {
    protected WebDriver driver;

    @Parameters({"browser", "url"})
    @BeforeMethod
    public void beforeMethod(@Optional("chrome") String browserName,
                             @Optional("https://demo.nopcommerce.com") String url) {
//        // Initialize WebDriver
//        driver = getWebdriver(browserName,"https://demo.hyva.io/", true);
//        driver.manage().window().maximize();
//
//        // Initialize ScreenshotHelper
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        // Close browser
        if (driver != null) {
            driver.quit();
        }
    }

    private void createDownloadDirectory(String downloadDir) {
        if (downloadDir != null && !downloadDir.isEmpty()) {
            File dir = new File(downloadDir);
            if (!dir.exists()) {
                boolean created = dir.mkdirs();
            }
        }
    }

    private void configureChromeDownload(ChromeOptions options, String downloadDir) {
        if (downloadDir != null && !downloadDir.isEmpty()) {
            HashMap<String, Object> chromePrefs = new HashMap<>();
            chromePrefs.put("download.default_directory", downloadDir);
            chromePrefs.put("download.prompt_for_download", false);
            chromePrefs.put("download.directory_upgrade", true);
            options.setExperimentalOption("prefs", chromePrefs);
        }
    }
}
