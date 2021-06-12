package cl.managers;

import cl.page_objects.TestPageObject;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private WebDriver driver;
    private TestPageObject testPageObject;


    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public TestPageObject getTestPage() {
        return (testPageObject == null) ? testPageObject = new TestPageObject(driver): testPageObject;
    }

}
