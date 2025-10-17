package Auth;

import base.TestBase;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Collections;

public class TestVisitAndTasks extends TestBase {

    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH,"finger");
    Sequence tap = new Sequence(finger,1);

    @Test(priority = 1)
    public void testOpenVisit () throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.id("More\nTab 5 of 5")).click();

        tap.addAction(finger.createPointerMove(Duration.ofMillis(10), PointerInput.Origin.viewport(), 34, 689));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(tap));
    }

    @Test (priority = 2)
    public void addNewVisit(){
        driver.findElement(By.xpath("//XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[4]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeImage[1]")).click();
    }

    @Test (priority = 3)
    public void createNewVisit(){

        // Name
        driver.findElement(By.id("Visit")).click();
        driver.findElement(By.xpath("//XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeTextField[1]")).sendKeys("Automation Visit");

        // Category
        driver.findElement(By.xpath("(//XCUIElementTypeOther[@name=\"Select...\"])[1]")).click();
        driver.findElement(By.id("Demo Category")).click();
        driver.findElement(By.id("Done")).click();

        // Execution Type
        driver.findElement(By.xpath("(//XCUIElementTypeOther[@name=\"Select...\"])[2]")).click();
        driver.findElement(By.id("One Time")).click();
        driver.findElement(By.id("Done")).click();

        // Date
        driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"TalentLink360\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeOther[3]/XCUIElementTypeOther")).click();
        driver.findElement(By.id("Done")).click();

        // Start time
        driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"TalentLink360\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeOther[4]/XCUIElementTypeOther")).click();
        driver.findElement(By.id("Done")).click();

        // End time
        driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"TalentLink360\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeOther[5]/XCUIElementTypeOther")).click();
        driver.findElement(By.id("Done")).click();

        // press at bottom of screen
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), 190, 750));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        // Move to up
        tap.addAction(finger.createPointerMove(Duration.ofMillis(800), PointerInput.Origin.viewport(), 190, 200));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(tap));

        // Assign employee
        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"TalentLink360\"]")).click();
        driver.findElement(By.xpath("(//XCUIElementTypeOther[@name=\"Select...\"])[3]")).click();
        driver.findElement(By.id("Mahmoud Samy Samy")).click();
        driver.findElement(By.id("Done")).click();

        // Location
        driver.findElement(By.xpath("(//XCUIElementTypeOther[@name=\"Select...\"])[4]")).click();
        driver.findElement(By.id("Submit")).click();

        // Submit
        driver.findElement(By.id("Submit")).click();
        driver.findElement(By.id("Ok")).click();

        // Visit details
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeOther[`name CONTAINS 'Pending'`][1]")).click();

        // Three points
        driver.findElement(By.xpath("//XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeImage[2]")).click();

        // Add comment
        driver.findElement(By.id("Add Comment")).click();

        // Write a comment
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeTextField")).sendKeys("Add a new comment");

        // Submit comment
        driver.findElement(By.id("Add Comment")).click();

        // Check-in
        driver.findElement(By.id("Check In")).click();

        WebElement checkoutMessage = driver.findElement(By.name("Data saved Successfully"));

        String messageText = checkoutMessage.getAttribute("value");
        System.out.println("✓ Successfully verified checkout message: " + messageText);

        driver.findElement(By.name("Ok")).click();
        System.out.println("✓ Successfully tapped 'Ok' button check-in");

        // Check-out
        WebElement button = driver.findElement(By.id("Check Out"));
        if (button.getText().equals("Check Out")) {
            button.click();
        }
        driver.findElement(By.name("Ok")).click();
        System.out.println("✓ Successfully tapped 'Ok' button check-out");

        // Start
        driver.findElement(By.id("Start")).click();
        WebElement startMessage = driver.findElement(By.name("Data saved Successfully"));

        String startMessageText = startMessage.getAttribute("value");
        System.out.println("✓ Successfully verified checkout message: " + startMessageText);

        driver.findElement(By.name("Ok")).click();
        System.out.println("✓ Successfully tapped 'Ok' button Start");

        // End
        WebElement endButton = driver.findElement(By.id("End"));
        if (endButton.getText().equals("End")) {
            endButton.click();
        }
        driver.findElement(By.name("Ok")).click();
        System.out.println("✓ Successfully tapped 'Ok' button End");

        // Back to Home

        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeImage[1]")).click();

        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeImage")).click();

        driver.findElement(By.id("Home\\nTab 1 of 5")).click();



    }
}
