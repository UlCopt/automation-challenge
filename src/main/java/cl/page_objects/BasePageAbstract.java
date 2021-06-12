package cl.page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

abstract class BasePageAbstract {

    WebDriver driver;

    BasePageAbstract(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
