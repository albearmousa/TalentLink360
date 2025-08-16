package Auth;

import base.TestBase;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class TestLoginScreen extends TestBase{

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

        WebElement ok = driver.findElement(AppiumBy.accessibilityId("Ok"));
        ok.click();
    }

    @Test(priority = 3)
    public void checkOut() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//XCUIElementTypeImage[starts-with(@name, 'Check Out')]")
        ).click();
        WebElement ok = driver.findElement(AppiumBy.accessibilityId("Ok"));
        ok.click();
    }

}




