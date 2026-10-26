package com.herokuapp;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DummyTest {


    @Test
    public void BrowserTest() {

        String url = "https://the-internet.herokuapp.com/login";
        String engine = "WEBKIT";

        Browser browser;

        Playwright pw = Playwright.create();

        browser = switch (engine.toLowerCase()) {
            case "chromium" -> pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            case "webkit" -> pw.webkit().launch((new BrowserType.LaunchOptions().setHeadless(false)));
            default -> pw.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        };

        Page page = browser.newPage();

        page.navigate(url);

        System.out.println(page.title());
        assertThat(page).hasTitle("The Internet");
    }
}