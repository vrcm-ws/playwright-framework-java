package oragehrm.demo.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class Sidebar {

    private final Page page;

    //locators
    private final Locator linkDashboard;
    private final Locator linkTime;


    public Sidebar(Page page) {

        this.page = page;

        this.linkDashboard = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Dashboard"));
        this.linkTime = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Time"));
    }

    public void clickTimeLink() {

        linkTime.click();
    }

}
