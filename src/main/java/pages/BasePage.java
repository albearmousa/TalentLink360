package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public class BasePage {
    protected AppiumDriver driver;
    protected WaitUtils waitUtils;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    protected void waitForElementVisible(WebElement element) {
        waitUtils.waitForElementVisible(element);
    }

    protected void waitForElementClickable(WebElement element) {
        waitUtils.waitForElementClickable(element);
    }
}
