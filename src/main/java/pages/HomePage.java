package pages;

import actions.MobileActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends MobileActions {

    @iOSXCUITFindBy(accessibility = "Home")
    private WebElement homeTitle;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name, 'Check In')]")
    private WebElement check_in_button;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name, 'Check Out')]")
    private WebElement check_out_button;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Annual Leaves Balance See More Today 81.0 Days End of the year 81.0 Days\"]")
    private WebElement annual_leave_balance;

    public HomePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isHomeDisplayed() {
        waitForElementVisible(homeTitle);
        return homeTitle.isDisplayed();
    }

    public void setCheck_in() {
        tap(check_in_button);
        System.out.println("tapped on the check-in button");
    }

    public void setCheck_in_msg() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("before waiting for the check-in message");
        tapByCoordinates(196, 493);
        System.out.println("after tapping on the check-in message");
    }

    public void setCheck_out() {
        tap(check_out_button);
        System.out.println("tapped on the check-out button");
    }

    public void allowLocationOnceIfPresent() throws InterruptedException {
        Thread.sleep(3000);
        tapByCoordinates(195, 600);
        System.out.println("tap on the location alert");
    }

    public void setAnnualLeaveBalance() throws InterruptedException {
        tapByCoordinates(325, 375);
        Thread.sleep(3000);
    }
}
