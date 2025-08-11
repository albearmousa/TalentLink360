package Auth;

import base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class TestLoginScreen{

    AppiumDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("appium:deviceName", "iPhone 15");
        caps.setCapability("appium:automationName", "XCUITest");
        caps.setCapability("appium:platformVersion", "17.2");
        caps.setCapability("appium:autoAcceptAlerts", "true");
        caps.setCapability("appium:app", "/Users/abanniub/Library/Developer/Xcode/DerivedData/Runner-bszxftpnggutcjgsqnjriwqeqvol/Build/Products/Debug-development-iphonesimulator/Runner.app");
        driver = new IOSDriver(new URL("http://localhost:4723/"), caps);
    }

    @Test(priority = 1)
    public void enter_valid_credential() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Email")));

        emailField.sendKeys("samymahmoud@gmail.com");

        driver.findElement(By.id("Password")).sendKeys("Samy2020@2");

        driver.findElement(By.id("Company code")).sendKeys("4");

        driver.findElement(By.id("Login")).click();

    }

    @Test(priority = 2)
    public void checkIn_checkout() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@name, 'Check In')]")));
        checkIn.click();

        try {
            Thread.sleep(3000);

            Actions actions = new Actions(driver);

            actions.moveToLocation(140, 620).click().perform();

            System.out.println("✅ Successfully tapped 'Allow Once' by coordinates");

            Thread.sleep(2000);

        } catch (Exception e) {

            System.out.println("❌ Failed to tap by coordinates: " + e.getMessage());

            e.printStackTrace();

        }
    }

}




