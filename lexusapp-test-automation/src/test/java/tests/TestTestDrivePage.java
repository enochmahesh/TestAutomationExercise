package tests;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestDriverPage;
import testData.TestDriverData;
import utilities.BaseTest;
import utilities.TestReport;
import utilities.UserActions;

public class TestTestDrivePage extends BaseTest {
    private TestDriverPage testDriverPage;

    @Test
    public void testFormFunctionality() throws InterruptedException {
        testDriverPage=new TestDriverPage(driver);
        testDriverPage.goToTestDriverPage();
        pause(2000);
        if (testDriverPage.getAcceptAlert().isDisplayed()){
            testDriverPage.getAcceptAlert().click();
            TestReport.logInfo("Accept Cookies alert clicked.");
        }
        else{
            Thread.sleep(1000);
        }
        TestReport.startTest("Validation for form filling functionalities");

        testDriverPage.firstName().sendKeys(TestDriverData.FIRST_NAME);
        TestReport.logInfo("First Name Filled");
        testDriverPage.lastName().sendKeys(TestDriverData.LAST_NAME);
        TestReport.logInfo("Last Name Filled");
        testDriverPage.email().sendKeys(TestDriverData.EMAIL);
        TestReport.logInfo("Email address Filled");
        pause(2000);
        UserActions actions = new UserActions(driver);
        actions.scrollToElement(testDriverPage.phoneNumberLbl());
        testDriverPage.phoneNumber().sendKeys(TestDriverData.PHONE_NUMBER);
        TestReport.logInfo("Phone Number Filled");
        testDriverPage.preferredDate().click();
        pause(3000);

        testDriverPage.nextMonthNav().click();
        Select select = new Select(testDriverPage.nextMonthNav());
        select.selectByVisibleText(TestDriverData.MONTH);
        pause(1000);
        testDriverPage.selectedDate().click();
        TestReport.logInfo("Preferred Date Selected.");
        pause(2000);
        testDriverPage.preferredTime().click();
        testDriverPage.selectTime().click();
        pause(2000);
        TestReport.logInfo("Preferred Time Selected.");

        testDriverPage.numberOfPax().click();
        testDriverPage.selectPax().click();
        pause(2000);
        TestReport.logInfo("Number of pax selected.");
        testDriverPage.modelChoices().click();
        Assert.assertTrue((testDriverPage.selectModel().isDisplayed()),"UX 300e Model was not pre-selected");
        TestReport.logInfo("Pre-selected model found.");
        testDriverPage.testDriveOptions().click();
        testDriverPage.selectTestDriveOption().click();
        TestReport.logInfo("Test Drive Option selected.");
        pause(2000);
        testDriverPage.checkBoxLicense().click();
        testDriverPage.checkBoxTerms().click();
        testDriverPage.checkBoxPrivacy().click();
        TestReport.logInfo("All compulsory checkboxes ticked.");
        pause(2000);
        Assert.assertTrue((testDriverPage.submitButton().isEnabled()),"Submit button was not enabled.");
        TestReport.logPass("Form filling functionalities successfully verified.");

    }
}
