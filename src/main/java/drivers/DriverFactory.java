package drivers;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import utils.ConfigReader;

public class DriverFactory {

    //create IOS driver
    public static IOSDriver createIOSDriver(AppiumDriverLocalService service) {
        XCUITestOptions options = new XCUITestOptions();
        options.setPlatformName(ConfigReader.getProperty("platformName"));
        options.setDeviceName(ConfigReader.getProperty("deviceName"));
        options.setAutomationName(ConfigReader.getProperty("automationName"));
        options.setPlatformVersion(ConfigReader.getProperty("platformVersion"));
        options.setAutoAcceptAlerts(Boolean.parseBoolean(ConfigReader.getProperty("autoAcceptAlerts")));
        options.setAutoDismissAlerts(Boolean.parseBoolean(ConfigReader.getProperty("autoDismissAlerts")));
        options.setUdid(ConfigReader.getProperty("udid"));
        options.setApp(ConfigReader.getProperty("app"));
        return new IOSDriver(service.getUrl(), options);
    }

}
