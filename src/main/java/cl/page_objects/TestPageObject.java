package cl.page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestPageObject extends BasePageAbstract {
    public TestPageObject(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//*[@id=\"cclr-global-header-root\"]/div/header/div[2]/nav[2]/div[2]/ul[2]/li[2]/div/div/div/a/p/b")
    WebElement savedTrips;

    @FindBy(className = "vifp-no-thankyou")
    WebElement noThankYou;

    public void navigateToURL() {
        driver.get("https://www.carnival.com/");
    }

    public void openSaved() throws Exception {
        PageObjectHelper.clickElement(driver, savedTrips);
        Thread.sleep(5000);
    }

    public void nope() throws Exception {
        PageObjectHelper.clickElement(driver, noThankYou);
    }

}
