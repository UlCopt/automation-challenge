package cl.page_objects;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.sql.Timestamp;

import static cl.config.Configuration.POLLING_DURATION;
import static cl.config.Configuration.TIMEOUT_DURATION;

public class PageObjectHelper {

    private static boolean fluentWaitElement(WebDriver driver, WebElement element) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(TIMEOUT_DURATION)
                .pollingEvery(POLLING_DURATION)
                .ignoring(NoSuchElementException.class);

        return wait.until(a -> {
            try {
                return element.isDisplayed();
            } catch (Exception e) {
                return false;
            }
        });
    }

    static void setWebElement(WebDriver driver, WebElement element, String value) throws Exception {
        if (fluentWaitElement(driver, element)) {
            element.sendKeys(value);
        } else {
            throw new Exception("not found element: " + element.toString());
        }
    }

    static void sendEnter(WebDriver driver, WebElement element) throws Exception {
        if (fluentWaitElement(driver, element)) {
            element.sendKeys(Keys.ENTER);
        } else {
            throw new Exception("not found element: " + element.toString());
        }
    }

    static void clickElement(WebDriver driver, WebElement element) throws Exception {
        if (fluentWaitElement(driver, element)) {
            element.click();
        } else {
            throw new Exception("not found element");
        }
    }

    static String getAttributeTextByValueFromElement(WebDriver driver, WebElement element, String value) throws Exception {
        if (fluentWaitElement(driver, element)) {
            return element.getAttribute(value);
        } else {
            throw new Exception("not found element");
        }
    }

    static void TakeScreenshot(WebDriver driver, String fileName) throws Exception  {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String timeStampString = Long.toString(timestamp.getTime());
        File File = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(File,new File("src/main/resources/screenshots/"+ fileName + timeStampString  + ".png"));
    }
}
