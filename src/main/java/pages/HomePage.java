package pages;

import actions.IOSActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends IOSActions {

    @iOSXCUITFindBy(accessibility = "Home")
    private WebElement homeTitle;

    public HomePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isHomeDisplayed() {
        return homeTitle.isDisplayed();
    }
}
