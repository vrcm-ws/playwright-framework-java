package oragehrm.demo.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class DashboardPage {

    private final Page page;
    private final Sidebar sidebar;

    //locators
    private final Locator headerPage;



    public DashboardPage(Page page) {

        this.page = page;
        this.sidebar = new Sidebar(page);

        this.headerPage = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Dashboard"));
    }


    public Locator getHeaderPage() {

        return headerPage;
    }


    public Sidebar sidebar() {

        return this.sidebar;
    }
}
