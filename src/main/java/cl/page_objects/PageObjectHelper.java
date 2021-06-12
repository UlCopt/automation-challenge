package cl.page_objects;

import cl.helper.Helper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;

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

    static void selectItemBoxByVisibleText(WebElement element, String value) {
        Select selectBox = new Select(element);
        selectBox.selectByVisibleText(value);
    }

    static void clickElementByJavascriptExecutor(WebDriver driver, WebElement element) throws  Exception {
        try {
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    static String getAttributeTextByValueFromElement(WebDriver driver, WebElement element, String value) throws Exception {
        if (fluentWaitElement(driver, element)) {
            return element.getAttribute(value);
        } else {
            throw new Exception("not found element");
        }
    }

    static String getSelectTextFromDropdownList(WebElement element) throws Exception {
        Select selectBox = new Select(element);
        return  selectBox.getFirstSelectedOption().getText();
    }

    static void TakeScreenshot(WebDriver driver, String fileName) throws Exception  {
        String timeStampString = Helper.getTimeStamp();
        File File = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(File,new File("src/main/resources/screenshots/"+ fileName + timeStampString  + ".png"));
    }


}
