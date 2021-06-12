package cl.page_objects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends BasePageAbstract {
    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    // SIGN UP
    @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(xpath = "//*[@id=\"MainBody\"]/div[13]/div/div/div/div[2]/div/div[1]/section/section/form/div[4]/button")
    WebElement signup;

    // CREATE ACCOUNT
    @FindBy(id = "firstName-pm")
    WebElement firstName;

    @FindBy(id = "lastName-pm")
    WebElement lastName;

    @FindBy(id = "dobMonth-pm")
    WebElement monthSelector;

    @FindBy(id = "dobDay-pm")
    WebElement day;

    @FindBy(id = "dobYear-pm")
    WebElement year;

    @FindBy(id = "gender-pm")
    WebElement genderSelector;

    @FindBy(id = "countryCode-pm")
    WebElement countrySelector;

    @FindBy(id = "domesticPhoneNumber-pm")
    WebElement phoneNumber;

    @FindBy(id = "workingWithTravelAgent-pm")
    WebElement workingWithTravelAgentCheck;

    @FindBy(id = "acceptsOffers-pm")
    WebElement acceptsOffersCheck;

    @FindBy(id = "acceptsTermsAndConditions-pm")
    WebElement acceptsTermsAndConditionsCheck;

    @FindBy(id = "submit-guest-pm")
    WebElement submitUser;

    @FindBy(id = "ns-no-booking-yet")
    WebElement noBookingYet;

    @FindBy(id = "ns-have-a-booking")
    WebElement haveABooking;


    public void enterUserName(String usernameValue) throws Exception {
        PageObjectHelper.setWebElement(driver,username,usernameValue);
    }

    public void enterPassword(String passwordValue) throws Exception {
        PageObjectHelper.setWebElement(driver, password, passwordValue);
    }

    public void signUpUser() throws Exception {
        PageObjectHelper.clickElement(driver, signup);
    }

    public void enterFirstName(String firstNameValue) throws Exception {
        PageObjectHelper.setWebElement(driver, firstName, firstNameValue);
    }

    public void enterLastName(String lastNameValue) throws Exception {
        PageObjectHelper.setWebElement(driver, lastName,lastNameValue);
    }

    public void selectMonth(String monthValue) throws Exception {
        PageObjectHelper.clickElement(driver,monthSelector);
        PageObjectHelper.selectItemBoxByVisibleText(monthSelector, monthValue);
    }

    public void enterDay(String dayValue) throws Exception {
        PageObjectHelper.setWebElement(driver, day, dayValue);
    }

    public void enterYear(String yearValue) throws Exception {
        PageObjectHelper.setWebElement(driver, year, yearValue);
    }

    public void selectGender(String genderValue) {
        PageObjectHelper.selectItemBoxByVisibleText(genderSelector, genderValue);
    }

    public void selectCountry(String countryValue) {
        PageObjectHelper.selectItemBoxByVisibleText(countrySelector, countryValue);
    }

    public void enterPhoneNumber(String phoneNumberValue) throws Exception {
        phoneNumber.sendKeys(Keys.PAGE_DOWN);
        PageObjectHelper.setWebElement(driver, phoneNumber, phoneNumberValue);

    }

    public void acceptOptionWorkingAgent(boolean option) throws Exception {
        if (option != workingWithTravelAgentCheck.isSelected()) {
            PageObjectHelper.clickElementByJavascriptExecutor(driver, workingWithTravelAgentCheck);
        }
    }

    public void acceptOptionOffers(boolean option) throws Exception {
        if (option != acceptsOffersCheck.isSelected()) {
            PageObjectHelper.clickElementByJavascriptExecutor(driver, workingWithTravelAgentCheck);
        }
    }

    public void acceptOptionTermsAndConditions(boolean option) throws  Exception {
         if (option != acceptsTermsAndConditionsCheck.isSelected()) {
            PageObjectHelper.clickElementByJavascriptExecutor(driver,acceptsTermsAndConditionsCheck );
        }
    }

    public void submitUserInfo() throws Exception {
        PageObjectHelper.clickElement(driver, submitUser);
    }

    public void notBookingYet() throws  Exception {
        PageObjectHelper.clickElement(driver, noBookingYet);
    }

    public void takeScreenshot(String filename) throws  Exception {
        PageObjectHelper.TakeScreenshot(driver,filename);
    }

}
