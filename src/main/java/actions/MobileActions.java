package actions;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import pages.BasePage;

import java.time.Duration;
import java.util.Collections;

public class MobileActions extends BasePage {
    protected AppiumDriver driver;

    public MobileActions(AppiumDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void tap(WebElement element) {
        waitForElementClickable(element);
        element.click();
    }

    public void tapByCoordinates(int x, int y) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);

        tap.addAction(finger.createPointerMove(
                Duration.ZERO,
                PointerInput.Origin.viewport(),
                x, y
        ));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(tap));
    }
}
