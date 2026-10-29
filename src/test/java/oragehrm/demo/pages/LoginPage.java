package oragehrm.demo.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginPage {

    private final Page page;
    private final String url = "https://opensource-demo.orangehrmlive.com/";

    //locators
    private final Locator inputUsername;
    private final Locator inputPassword;
    private final Locator buttonLogin;

    public LoginPage(Page page) {
        this.page = page;

        this.inputUsername = page.getByPlaceholder("Username");
        this.inputPassword = page.getByPlaceholder("Password");
        this.buttonLogin = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"));
    }


    public void navigate() {

        page.navigate(url);
    }


    public void enterUsername(String username) {

        inputUsername.fill(username);
    }


    public void enterPassword(String password) {

        inputPassword.fill(password);
    }


    public void clickSubmit() {

        buttonLogin.click();
    }


    public void login(String username, String password) {

        enterUsername(username);
        enterPassword(password);
        clickSubmit();
    }
}
