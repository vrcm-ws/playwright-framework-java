package com.herokuapp.tests;

import com.herokuapp.base.BaseTest;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class BasicLoginTest extends BaseTest {

    @Test
    public void LoginTest() {

        String url = "https://the-internet.herokuapp.com/login";

        page.navigate(url);

        Page.GetByRoleOptions roleOptions = new Page.GetByRoleOptions();

        assertThat(page).hasTitle("The Internet");

        page.getByLabel("Username").fill("tomsmith");
        page.getByLabel("Password").fill("SuperSecretPassword!");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();

        assertThat(page.getByText("You logged into a secure area!")).isVisible();

        //page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Logout")).click();
        page.getByRole(AriaRole.LINK, roleOptions.setName("Logout")).click();
    }
}