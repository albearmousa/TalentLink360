package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {
    protected static AppiumDriver driver;

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


}
