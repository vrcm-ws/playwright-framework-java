package oragehrm.demo.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ExtentManager;
import utils.Screenshoot;

import java.lang.reflect.Method;
import java.nio.file.Path;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected Page page;
    protected ExtentReports report;
    protected ExtentTest test;


    @BeforeMethod
    public void setUp(Method method) {

        String engine = "WEBKIT";

        // reporting
        report = ExtentManager.getInstance();
        test = report.createTest(method.getName());

        playwright = Playwright.create();

        browser = switch (engine.toLowerCase()) {
            case "chromium" -> playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            case "webkit" -> playwright.webkit().launch((new BrowserType.LaunchOptions().setHeadless(false)));
            default -> playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
        };

        page = browser.newPage();
    }


    @AfterMethod
    public void tearDown(ITestResult result) {

        switch (result.getStatus()) {

            case ITestResult.FAILURE:
                String screenshotPath = Screenshoot.takeScreenshoot(page, result.getName());

                test.info(MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath, "Failure").build());
                test.fail(result.getThrowable());
                break;
            case ITestResult.SUCCESS:
                test.pass("Test Passed");
                break;
            default:
                test.skip("Test Skipped");
                break;
        }

        report.flush();

        if(browser != null) {
            browser.close();
        }

        if(playwright != null) {
            playwright.close();
        }
    }
}
