package oragehrm.demo.tests;

import oragehrm.demo.base.BaseTest;
import oragehrm.demo.pages.DashboardPage;
import oragehrm.demo.pages.LoginPage;
import oragehrm.demo.pages.TimePage;
import org.testng.annotations.Test;

public class DashboardPageTest extends BaseTest {

    @Test
    public void DashboardTest() {

        String username = "Admin";
        String password = "admin123";

        LoginPage loginPage = new LoginPage(page);

        loginPage.navigate();
        loginPage.login(username, password);

        DashboardPage dashboardPage = new DashboardPage(page);

        dashboardPage.sidebar().clickTimeLink();

        TimePage timePage = new TimePage(page);

        System.out.println(timePage.getHeaderPage().textContent());
    }
}
