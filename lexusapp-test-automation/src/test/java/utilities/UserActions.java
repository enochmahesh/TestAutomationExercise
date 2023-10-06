package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserActions {
    final WebDriver driver;

    public UserActions(WebDriver driver) {
        this.driver = driver;
    }
    public void scrollToElement(WebElement element) {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

}
