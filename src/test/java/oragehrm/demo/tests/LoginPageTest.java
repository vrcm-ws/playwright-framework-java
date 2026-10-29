package oragehrm.demo.tests;

import oragehrm.demo.base.BaseTest;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import oragehrm.demo.pages.HomePage;
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

        HomePage homePage = new HomePage(page);

        assertThat(homePage.getHeaderPage()).isVisible();
        assertThat(homePage.getHeaderPage()).hasText("Dashboard");
    }
}