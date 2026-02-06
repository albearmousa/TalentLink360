package pages;

import actions.IOSActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends IOSActions {

    @iOSXCUITFindBy(id = "Email")
    private WebElement email;
    @iOSXCUITFindBy(id = "Password")
    private WebElement password;
    @iOSXCUITFindBy(id = "Company code")
    private WebElement companyCode;
    @iOSXCUITFindBy(id = "Remember me")
    private WebElement rememberMe;
    @iOSXCUITFindBy(id = "Login")
    private WebElement loginButton;


    public LoginPage(AppiumDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(
                new AppiumFieldDecorator(driver),
                this
        );
    }

    public HomePage login(String mail, String pass, String code) {

        waitForElementVisibility(email);
        email.sendKeys(mail);
        password.sendKeys(pass);
        companyCode.sendKeys(code);
        rememberMe.click();
        loginButton.click();
        return new HomePage(driver);
    }

}