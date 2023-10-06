package pages;

import constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TestDriverPage {
    private final WebDriver driver;

    public TestDriverPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToTestDriverPage() {
        driver.get(Constants.TEST_DRIVER_PAGE_URL);
    }

    public WebElement getAcceptAlert(){
        By acceptCookies=By.xpath("//*[@id=\"consent_prompt_submit\"]");
        return driver.findElement(acceptCookies);
    }

    public WebElement firstName() {
        By firstName = By.id("input_first_name");
        return driver.findElement(firstName);
    }

    public WebElement lastName() {
        By lastName = By.id("input_last_name");
        return driver.findElement(lastName);
    }

    public WebElement email() {
        By email = By.id("input_email_address");
        return driver.findElement(email);
    }

    public WebElement phoneNumberLbl() {
        By phoneNumberLbl = By.xpath("/html/body/div[1]/main/article/section/section/div/form/div[4]/div/label");
        return driver.findElement(phoneNumberLbl);
    }

    public WebElement phoneNumber() {
        By phoneNumber = By.id("input_phone_number");
        return driver.findElement(phoneNumber);
    }

    public WebElement preferredDate() {
        By preferredDate = By.id("datepicker_preferred_date");
        return driver.findElement(preferredDate);
    }
    public WebElement nextMonthNav() {
        By nextMonthNav = By.className("flatpickr-monthDropdown-months");
        return driver.findElement(nextMonthNav);
    }

    public WebElement selectedDate() {
        By selectedDate = By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/span[3]");
        return driver.findElement(selectedDate);
    }

    public List<WebElement> datesList() {
        preferredDate().click();
        WebElement dayContainer = driver.findElement(By.className("dayContainer"));
        List<WebElement> dayElements = dayContainer.findElements(By.tagName("span"));
        return dayElements;
    }

    public WebElement preferredTime(){
        By preferredTime=By.xpath("/html/body/div[1]/main/article/section/section/div/form/div[6]/div/div[1]/div[1]/div/div");
        return driver.findElement(preferredTime);
    }

    public WebElement selectTime(){
        By selectTime=By.xpath("//div[@data-value='18:00']");
        return driver.findElement(selectTime);
    }

    public WebElement numberOfPax(){
        By numberOfPax=By.xpath("/html/body/div[1]/main/article/section/section/div/form/div[8]/div/div[1]/div[1]/div/div");
        return driver.findElement(numberOfPax);
    }

    public WebElement selectPax(){
        By selectPax=By.xpath("//div[@data-value='2']");
        return driver.findElement(selectPax);
    }

    public WebElement modelChoices(){
        By numberOfPax=By.xpath("/html/body/div[1]/main/article/section/section/div/form/div[9]/div/div[1]/div[1]/div/div");
        return driver.findElement(numberOfPax);
    }

    public WebElement selectModel(){
        By selectPax=By.xpath("//div[@data-value='RX 350h']");
        return driver.findElement(selectPax);
    }

    public WebElement testDriveOptions(){
        By testDriveOptions=By.xpath("/html/body/div[1]/main/article/section/section/div/form/div[10]/div/div[1]/div[1]/div/div");
        return driver.findElement(testDriveOptions);
    }

    public WebElement selectTestDriveOption(){
        By selectTestDriveOption=By.xpath("//div[@data-value='lexus-test-drive-concierge']");
        return driver.findElement(selectTestDriveOption);
    }

    public WebElement checkBoxLicense(){
        By checkBoxLicense=By.id("checkbox_driving_license");
        return driver.findElement(checkBoxLicense);
    }
    public WebElement checkBoxTerms(){
        By checkBoxTerms=By.id("checkbox_terms_conditions");
        return driver.findElement(checkBoxTerms);
    }
    public WebElement checkBoxPrivacy(){
        By checkBoxPrivacy=By.id("checkbox_privacy_policy");
        return driver.findElement(checkBoxPrivacy);
    }

    public WebElement submitButton(){
        By submitButton=By.xpath("/html/body/div[1]/main/article/section/section/div/form/div[17]/button");
        return driver.findElement(submitButton);
    }







}
