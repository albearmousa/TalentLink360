package actions;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import utils.AppiumUtils;

public class IOSActions extends AppiumUtils {
    protected AppiumDriver driver;

    public IOSActions(AppiumDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void tap(WebElement element) {
        waitForElement(element);
        element.click();
    }

}
