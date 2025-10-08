package Auth;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

        driver.findElement(By.id("Remember me")).click();

        driver.findElement(By.id("Login")).click();

    }
}




