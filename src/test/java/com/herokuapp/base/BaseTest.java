package com.herokuapp.base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected Page page;

    @BeforeMethod
    public void setUp() {

        String engine = "WEBKIT";

        playwright = Playwright.create();

        browser = switch (engine.toLowerCase()) {
            case "chromium" -> playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            case "webkit" -> playwright.webkit().launch((new BrowserType.LaunchOptions().setHeadless(false)));
            default -> playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        };

        page = browser.newPage();
    }

    @AfterMethod
    public void tearDown() {

        if(browser != null) {
            browser.close();
        }

        if(playwright != null) {
            playwright.close();
        }
    }

}
