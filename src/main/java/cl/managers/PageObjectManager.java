package cl.managers;

import cl.page_objects.CreateAccountPage;
import cl.page_objects.HomePage;
import cl.page_objects.MyProfilePage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private WebDriver driver;
    private HomePage homePage;
    private CreateAccountPage createAccountPage;
    private MyProfilePage myProfilePage;


    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return (homePage == null) ? homePage = new HomePage(driver): homePage;
    }

    public CreateAccountPage getCreateAccountPage() {
        return (createAccountPage == null) ? createAccountPage = new CreateAccountPage(driver): createAccountPage;
    }
    public MyProfilePage getMyProfilePage() {
        return (myProfilePage == null) ? myProfilePage = new MyProfilePage(driver): myProfilePage;
    }



}
