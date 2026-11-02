package oragehrm.demo.tests;

import oragehrm.demo.base.BaseTest;
import oragehrm.demo.pages.DashboardPage;
import oragehrm.demo.pages.LoginPage;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginPageTest extends BaseTest {

    @Test
    public void LoginTest() {

        String username = "Admin";
        String password = "admin123";

        LoginPage loginPage = new LoginPage(page);

        loginPage.navigate();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickSubmit();

        DashboardPage dashboardPage = new DashboardPage(page);

        assertThat(dashboardPage.getHeaderPage()).isVisible();
        assertThat(dashboardPage.getHeaderPage()).hasText("Dashboard");
    }
}