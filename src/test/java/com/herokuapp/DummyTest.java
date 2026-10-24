package com.herokuapp;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

public class DummyTest {


    @Test
    public void BrowserTest() {

        String url = "https://the-internet.herokuapp.com/login";

        Playwright pw = Playwright.create();
        Browser browser = pw.chromium().launch();
        Page page = browser.newPage();

        page.navigate(url);

        System.out.println(page.title());
    }
}