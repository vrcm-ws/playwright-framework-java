package oragehrm.demo.tests;

import oragehrm.demo.base.BaseTest;
import oragehrm.demo.pages.DashboardPage;
import oragehrm.demo.pages.LoginPage;
import org.testng.annotations.Test;
import utils.Screenshoot;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginPageTest extends BaseTest {

    @Test
    public void LoginTest() {

        String username = "Admin";
        String password = "admin123";

        LoginPage loginPage = new LoginPage(page);

        test.info("Opening loging page");
        loginPage.navigate();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);

        test.info(Screenshoot.buildMedia(page, "Login Page"));
        loginPage.clickSubmit();

        test.info("Moving to Dashboard");

        DashboardPage dashboardPage = new DashboardPage(page);

        assertThat(dashboardPage.getHeaderPage()).isVisible();
        assertThat(dashboardPage.getHeaderPage()).hasText("Dashboard");

        test.info("End of test");
    }
}