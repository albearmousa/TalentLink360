package base;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
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
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "ios");
        caps.setCapability("appium:deviceName", "iPhone 14 Pro");
        caps.setCapability("appium:automationName", "XCUITest");
        caps.setCapability("appium:platformVersion", "26.1");
        //caps.setCapability("noReset", true);
        //  caps.setCapability("fullReset", false);
        caps.setCapability("appium:autoAcceptAlerts", "true");
        caps.setCapability("autoGrantPermissions", true);
        caps.setCapability("udid", "00008120-000A6C2411F0201E");
        caps.setCapability("appium:app", "/Users/albearmousa/Library/Developer/Xcode/DerivedData/Runner-czeogqgpqajicbecaqqbknallehz/Build/Products/Release-production-iphoneos/Runner.app");
        caps.setCapability("appium:appLaunchTimeout", 100000); // 60 seconds
        caps.setCapability("appium:wdaLaunchTimeout", 100000);
        caps.setCapability("appium:wdaConnectionTimeout", 100000);
        driver = new IOSDriver(service.getUrl(), caps);
    }

    @AfterSuite(alwaysRun = true)
    public void stopEverything() {
        if (driver != null) driver.quit();
        if (service != null) service.stop();
    }
}
