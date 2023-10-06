package pages;


import constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import utilities.UserActions;


public class UXPage {
    private final WebDriver driver;

    public UXPage(WebDriver driver) {
        this.driver = driver;
    }
    public void goToUXPage() {
        driver.get(Constants.UX_PAGE_URL);
    }

    public WebElement getVideo() throws InterruptedException {
        UserActions actions = new UserActions(driver);
        WebElement gallerySection = driver.findElement(By.xpath("/html/body/div[1]/main/article/section[3]/div/div/div/header/h2"));
        actions.scrollToElement(gallerySection);
        Thread.sleep(2000);
        By video = By.xpath("/html/body/div[1]/main/article/section[3]/div/section[1]/div[2]/div[1]/div[1]/ul/li[3]/div/picture");
        return driver.findElement(video);
    }

    public WebElement closeIcon() throws InterruptedException {
        By closeIcon = By.xpath("/html/body/div[4]/div/div[2]/button");
        return driver.findElement(closeIcon);
    }



}

