package cl.cucumber;

import cl.managers.PageObjectManager;
import cl.managers.WebDriverManager;

public class TestContext {
    private WebDriverManager webDriverManager;
    private PageObjectManager pageObjectManager;

    public TestContext() {
        webDriverManager = new WebDriverManager();
        pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
    }

    public WebDriverManager getWebDriverManager() {
        return webDriverManager;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

    //user data
    public String userName;
    public String firstName;
    public String lastName;
    public String birthDay;
    public String birthMonth;
    public String birthYear;
    public String gender;
    public String country;
    public String phoneNumber;

}
