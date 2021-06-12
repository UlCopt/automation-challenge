package cl.page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePageAbstract {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"cclr-global-header-root\"]/div/header/div[2]/nav[2]/div[2]/ul[2]/li[1]/div/div[1]/a")
    WebElement createAccount;

    @FindBy(xpath = "//*[@id=\"cclr-global-header-root\"]/div/header/div[2]/nav[2]/div[2]/ul[2]/li[2]/div/div/div/a/p/b")
    WebElement savedTrip;

    @FindBy(className = "vifp-no-thankyou")
    WebElement noThankYou;

    @FindBy(xpath = "//*[@id=\"cclr-global-header-root\"]/div/header/div[2]/nav[2]/div[2]/ul[2]/li[1]/div/div[1]/p/a")
    WebElement usernameOnScreen;

    public void navigateToURL() {
        driver.get("https://www.carnival.com/");
    }

    public void create() throws Exception {
        PageObjectHelper.clickElement(driver, createAccount);
    }

    public void openSaved() throws Exception {
        PageObjectHelper.clickElement(driver, savedTrip);
      }

    public void nope() throws Exception {
        PageObjectHelper.clickElement(driver, noThankYou);
    }

    public void goToMyProfile() throws Exception {
        PageObjectHelper.clickElement(driver, usernameOnScreen);
    }

    public void takeScreenshot(String filename) throws  Exception {
        PageObjectHelper.TakeScreenshot(driver,filename);
    }


}
