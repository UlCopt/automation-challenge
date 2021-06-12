package cl.page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyProfilePage extends BasePageAbstract{
    public MyProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "sex")
    WebElement sex;

    @FindBy(id = "residence")
    WebElement residence;

    @FindBy(id = "month")
    WebElement month;

    @FindBy(id ="day")
    WebElement day;

    @FindBy(id = "year")
    WebElement year;

    @FindBy(id = "email-field")
    WebElement email;

    @FindBy(id = "phoneAreaCode")
    WebElement phoneAreaCode;

    @FindBy(id = "phoneNumber")
    WebElement phoneNumber;

    public String getFirstName() throws Exception {
        return PageObjectHelper.getAttributeTextByValueFromElement(driver,firstName, "value");
    }

    public String getLastName() throws Exception {
        return PageObjectHelper.getAttributeTextByValueFromElement(driver, lastName, "value");
    }

    public String getDay() throws  Exception {
        return PageObjectHelper.getAttributeTextByValueFromElement(driver,day,"value");
    }

    public String getMonth() throws Exception {
        return PageObjectHelper.getSelectTextFromDropdownList(month);
    }

    public String getYear() throws Exception {
        return PageObjectHelper.getAttributeTextByValueFromElement(driver, year, "value");
    }

    public String getGender() throws Exception {
        return PageObjectHelper.getSelectTextFromDropdownList(sex);
    }

    public String getResidence() throws Exception {
        return PageObjectHelper.getSelectTextFromDropdownList(residence);
    }

    public String getEmail() throws  Exception {
        return PageObjectHelper.getAttributeTextByValueFromElement(driver, email, "value");
    }

    public String getPhoneNumber() throws Exception {
        return
                PageObjectHelper.getAttributeTextByValueFromElement(driver,phoneAreaCode,"value") +
                PageObjectHelper.getAttributeTextByValueFromElement(driver,phoneNumber,"value");
    }

    public void takeScreenshot(String filename) throws  Exception {
        PageObjectHelper.TakeScreenshot(driver,filename);
    }



}
