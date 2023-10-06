package pages;

import constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.UserActions;

public class HomePage {
    private final WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToHomePage() {
        driver.get(Constants.HOME_PAGE_URL);
    }
    public WebElement getBanner() {
        By bannerLocator=By.xpath("/html/body/div[1]/main/article/div/section[1]/div[1]/section[2]/section/h1");
        return driver.findElement(bannerLocator);
    }
    public WebElement getAcceptAlert(){
        By acceptCookies=By.xpath("//*[@id=\"consent_prompt_submit\"]");
        return driver.findElement(acceptCookies);
    }

    public WebElement suvTab(){
        By suvTab=By.xpath("/html/body/div[1]/main/article/div/section[2]/section[1]/div[1]/div/div/div/button[1]/span[3]");
        return driver.findElement(suvTab);
    }

    public WebElement compactLuxury(){
        UserActions actions = new UserActions(driver);
        actions.scrollToElement(suvTab());
        By compactLuxury=By.xpath("/html/body/div[1]/main/article/div/section[2]/section[1]/div[2]/div[1]/div[2]/div[1]/ul/li[1]/a/div/div/p");
        return driver.findElement(compactLuxury);
    }
}
