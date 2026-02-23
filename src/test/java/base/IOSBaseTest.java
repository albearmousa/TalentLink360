package base;

import drivers.DriverFactory;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


public class IOSBaseTest {
    protected IOSDriver driver;
    protected AppiumDriverLocalService service;

    @BeforeClass
    public void startAppium() {
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
    }

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.createIOSDriver(service);
    }

    @AfterClass(alwaysRun = true)
    public void stopEverything() {
        if (driver != null) driver.quit();
        if (service != null) service.stop();
    }
}
