package cl.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    private WebDriver driver;
    String browser = System.getProperty("browser","local-chrome");

    private static final String LOCAL_CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

    public WebDriver getDriver() {
        switch (browser.toLowerCase().trim()) {
            case "docker-chrome":
                if (driver == null) driver = createChromeDriverDocker();
                return driver;

            case "local-chrome":
                if (driver == null) driver = createChromeDriverLocal();
                return driver;

            default:
                throw new Error("Error: Browser selected not found");
        }
    }

    private WebDriver createChromeDriverLocal() {
        System.setProperty(LOCAL_CHROME_DRIVER_PROPERTY, "src/main/resources/webdriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    private WebDriver createChromeDriverDocker() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.setCapability(ChromeOptions.CAPABILITY,options);
        options.setCapability("browserName","chrome");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        options.merge(capabilities);
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),options);
            return driver;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void closeDriver() {
        driver.close();
        driver.quit();
    }
}
