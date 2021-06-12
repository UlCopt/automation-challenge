package cl.steps_definitions;

import cl.cucumber.TestContext;
import cl.helper.Helper;
import cl.page_objects.CreateAccountPage;
import cl.page_objects.HomePage;
import cl.page_objects.MyProfilePage;
import cl.page_objects.PageObjectHelper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CreateAccountSteps {
    private CreateAccountPage createAccountPage;
    private HomePage homePage;
    private MyProfilePage myProfilePage;
    private TestContext testContext;

    public CreateAccountSteps(TestContext testContext) {
        this.testContext = testContext;
        createAccountPage = testContext.getPageObjectManager().getCreateAccountPage();
        homePage = testContext.getPageObjectManager().getHomePage();
        myProfilePage = testContext.getPageObjectManager().getMyProfilePage();
    }


    @When("I create a user with a {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void i_create_a_user_with_a_my_pass321$(String usernameValue,
                                                   String passwordValue,
                                                   String firstNameValue,
                                                   String lastNameValue,
                                                   String monthValue,
                                                   String dayValue,
                                                   String yearValue,
                                                   String genderValue,
                                                   String countryValue,
                                                   String phoneNumberValue,
                                                   String workingAgentValue,
                                                   String offerValue,
                                                   String termsConditionsValue) throws Exception {
        String userNameWithTimeStamp = usernameValue+ Helper.getTimeStamp() + "@gmail.com";

        testContext.userName = userNameWithTimeStamp;
        testContext.firstName = firstNameValue;
        testContext.lastName = lastNameValue;
        testContext.birthMonth = monthValue;
        testContext.birthDay = dayValue;
        testContext.birthYear = yearValue;
        testContext.gender = genderValue;
        testContext.country = countryValue;
        testContext.phoneNumber = phoneNumberValue;

        homePage.create();

        createAccountPage.enterUserName(userNameWithTimeStamp);
        createAccountPage.enterPassword(passwordValue);
        createAccountPage.signUpUser();
        createAccountPage.enterFirstName(firstNameValue);
        createAccountPage.enterLastName(lastNameValue);
        createAccountPage.selectMonth(monthValue);
        createAccountPage.enterDay(dayValue);
        createAccountPage.enterYear(yearValue);
        createAccountPage.selectGender(genderValue);
        createAccountPage.selectCountry(countryValue);
        createAccountPage.enterPhoneNumber(phoneNumberValue);
        createAccountPage.acceptOptionWorkingAgent(Boolean.parseBoolean(workingAgentValue));
        createAccountPage.acceptOptionOffers(Boolean.parseBoolean(offerValue));
        createAccountPage.acceptOptionTermsAndConditions(Boolean.parseBoolean(termsConditionsValue));
        createAccountPage.takeScreenshot("UserInfo");

        createAccountPage.submitUserInfo();
        createAccountPage.notBookingYet();
        createAccountPage.takeScreenshot("notBooking");
    }


    @Then("Should be created successfully")
    public void should_be_created_successfully() throws Exception {
        homePage.goToMyProfile();
        String firstNameActual =  myProfilePage.getFirstName();
        String lastNameActual =  myProfilePage.getLastName();
        String monthActual = myProfilePage.getMonth();
        String dayActual = myProfilePage.getDay();
        String yearActual = myProfilePage.getYear();
        String genderActual = myProfilePage.getGender();
        String emailActual = myProfilePage.getEmail();
        String countryActual = myProfilePage.getResidence();
        String phoneNumberActual = myProfilePage.getPhoneNumber();
        createAccountPage.takeScreenshot("MyProfile");

        Assert.assertEquals("Fail: Firstname not expected"
                , testContext.firstName
                , firstNameActual);
        Assert.assertEquals("Fail: Lastname not expected"
                , testContext.lastName
                , lastNameActual);
        Assert.assertEquals("Fail: Email not expected"
                , testContext.userName
                , emailActual);
        Assert.assertEquals("Fail: BirthMonth not expected"
                , testContext.birthMonth
                , monthActual);
        Assert.assertEquals("Fail: BirthDay not expected"
                , testContext.birthDay
                , dayActual);
        Assert.assertEquals("Fail: BirthYear not expected"
                , testContext.birthYear
                , yearActual);
        Assert.assertEquals("Fail: Gender not expected"
                , testContext.gender
                , genderActual);
        Assert.assertEquals("Fail: Country not expected"
                , testContext.country
                , countryActual);
        Assert.assertEquals("Fail: PhoneNumber not expected"
                , testContext.phoneNumber
                , phoneNumberActual);

    }
}
