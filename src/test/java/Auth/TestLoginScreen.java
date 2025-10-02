package Auth;

import base.TestBase;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class TestLoginScreen extends TestBase{

    @Test (priority = 1)
    public void enter_valid_credential() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Email")));

        emailField.sendKeys("samymahmoud@gmail.com");

        driver.findElement(By.id("Password")).sendKeys("Samy2020@2");

        driver.findElement(By.id("Company code")).sendKeys("4");

        driver.findElement(By.id("Login")).click();

    }

    @Test (priority = 2)
    public void checkIn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement welcomeMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Home")));

        Assert.assertTrue(welcomeMessage.isDisplayed());

        System.out.println(welcomeMessage);

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

        driver.findElement(AppiumBy.accessibilityId("Ok")).click();
    }

    @Test(priority = 3)
    public void checkOut() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//XCUIElementTypeImage[starts-with(@name, 'Check Out')]")
        ).click();

        // Set implicit wait (add this in your setup method)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

// Check if the "See you later" text exists
        WebElement checkoutMessage = driver.findElement(By.name("See you later, Mahmoud"));

// Assert the message is displayed
        Assert.assertTrue(checkoutMessage.isDisplayed(), "Checkout message should be displayed");

        String messageText = checkoutMessage.getAttribute("value");
        System.out.println("✓ Successfully verified checkout message: " + messageText);

// Tap on Ok button
        driver.findElement(By.name("Ok")).click();
        System.out.println("✓ Successfully tapped 'Ok' button");

    }
}




