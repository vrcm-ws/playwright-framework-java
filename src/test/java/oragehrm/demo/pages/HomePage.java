package oragehrm.demo.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HomePage {

    private final Page page;

    //locators
    private final Locator headerPage;
    private final Locator linkDashboard;


    public HomePage(Page page) {

        this.page = page;

        this.headerPage = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Dashboard"));
        this.linkDashboard = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Dashboard"));
    }


    public Locator getHeaderPage() {
        return headerPage;
    }
}
